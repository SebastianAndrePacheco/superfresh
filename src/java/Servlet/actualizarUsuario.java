package Servlet;

import Control.AccionesUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_USUARIO    = Integer.parseInt(request.getParameter("ID_USUARIO2"));
            int ID_PERSONA    = Integer.parseInt(request.getParameter("ID_PERSONA2"));
            String LOGEO      = request.getParameter("LOGEO2");
            String CLAVE      = request.getParameter("CLAVE2");
            String USUMOD     = request.getParameter("USUMOD2");
            String FECMODStr  = request.getParameter("FECMOD2");
            String PCMOD      = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            Usuario usuario = new Usuario();
            usuario.setID_USUARIO(ID_USUARIO);
            usuario.setID_PERSONA(ID_PERSONA);
            usuario.setLOGEO(LOGEO);
            usuario.setCLAVE(CLAVE);
            usuario.setUSUMOD(USUMOD);
            usuario.setFECMOD(FECMOD);
            usuario.setPCMOD(PCMOD);

            int estatus = AccionesUsuario.actualizarUsuario(usuario);
            if (estatus > 0) {
                response.sendRedirect("consultarUsuario.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
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
        return "Servlet para actualizar datos de Usuario";
    }
}
