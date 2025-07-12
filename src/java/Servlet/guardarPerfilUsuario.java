package Servlet;

import Modelo.PerfilUsuario;
import Control.AccionesPerfilUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarPerfilUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int ID_PERFIL = Integer.parseInt(request.getParameter("ID_PERFIL"));
            int ID_USUARIO = Integer.parseInt(request.getParameter("ID_USUARIO"));
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            PerfilUsuario perfilUsuario = new PerfilUsuario();
            perfilUsuario.setID_PERFIL(ID_PERFIL);
            perfilUsuario.setID_USUARIO(ID_USUARIO);
            perfilUsuario.setUSUCRE(USUCRE);
            perfilUsuario.setFECCRE(FECCRE);
            perfilUsuario.setPCCRE(PCCRE);

            int estatus = AccionesPerfilUsuario.registrarPerfilUsuario(perfilUsuario);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Perfil de usuario registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el perfil de usuario.");
            }

            request.getRequestDispatcher("registrarPerfilUsuario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para registrar PerfilUsuario";
    }
}
