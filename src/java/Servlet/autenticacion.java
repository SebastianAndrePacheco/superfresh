package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Control.Conexion;

@WebServlet("/AutenticacionServlet")
public class autenticacion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Conexion conexion = new Conexion();
        Connection con = null;

        try {
            con = conexion.conectar();
            String query = "SELECT ID_USUARIO, CLAVE FROM usuario WHERE LOGEO = ? AND ESTADO = '1'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("CLAVE");
                int userId = rs.getInt("ID_USUARIO");

                if (password.equals(storedPassword)) { // Aquí podrías usar BCrypt.checkpw(password, storedPassword) si estás usando hashed passwords
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userId);
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=1");
                }
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=2");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
