package Servlet;

import Modelo.Usuario;
import Control.AccionesUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int ID_PERSONA = Integer.parseInt(request.getParameter("ID_PERSONA"));
            String LOGEO = request.getParameter("LOGEO");
            String CLAVE = request.getParameter("CLAVE");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char ESTADO = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Usuario usuario = new Usuario();
            usuario.setID_PERSONA(ID_PERSONA);
            usuario.setLOGEO(LOGEO);
            usuario.setCLAVE(CLAVE);
            usuario.setUSUCRE(USUCRE);
            usuario.setFECCRE(FECCRE);
            usuario.setPCCRE(PCCRE);
            usuario.setESTADO(ESTADO);

            int estatus = AccionesUsuario.registrarUsuario(usuario);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Usuario registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Usuario.");
            }

            request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
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
        return "Servlet para registrar Usuario";
    }
}
