package Servlet;

import Control.AccionesPerfilUsuario;
import Modelo.PerfilUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarPerfilUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_PERFIL_USUARIO = Integer.parseInt(request.getParameter("ID_PERFIL_USUARIO2"));
            int ID_PERFIL         = Integer.parseInt(request.getParameter("ID_PERFIL2"));
            int ID_USUARIO        = Integer.parseInt(request.getParameter("ID_USUARIO2"));
            String USUMOD         = request.getParameter("USUMOD2");
            String FECMODStr      = request.getParameter("FECMOD2");
            String PCMOD          = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            PerfilUsuario pu = new PerfilUsuario();
            pu.setID_PERFIL_USUARIO(ID_PERFIL_USUARIO);
            pu.setID_PERFIL(ID_PERFIL);
            pu.setID_USUARIO(ID_USUARIO);
            pu.setUSUMOD(USUMOD);
            pu.setFECMOD(FECMOD);
            pu.setPCMOD(PCMOD);

            int estatus = AccionesPerfilUsuario.actualizarPerfilUsuario(pu);
            if (estatus > 0) {
                response.sendRedirect("consultarPerfilUsuario.jsp");
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
        return "Servlet para actualizar asociación Perfil-Usuario";
    }
}
