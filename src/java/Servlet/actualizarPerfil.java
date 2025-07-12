package Servlet;

import Control.AccionesPerfil;
import Modelo.Perfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarPerfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_PERFIL = Integer.parseInt(request.getParameter("ID_PERFIL2"));
            String NOMBRE_PERFIL = request.getParameter("NOMBRE_PERFIL2");
            String USUMOD = request.getParameter("USUMOD2");
            String FECMODStr = request.getParameter("FECMOD2");
            String PCMOD = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            Perfil perfil = new Perfil();
            perfil.setID_PERFIL(ID_PERFIL);
            perfil.setNOMBRE_PERFIL(NOMBRE_PERFIL);
            perfil.setUSUMOD(USUMOD);
            perfil.setFECMOD(FECMOD);
            perfil.setPCMOD(PCMOD);

            int estatus = AccionesPerfil.actualizarPerfil(perfil);
            if (estatus > 0) {
                response.sendRedirect("consultarPerfil.jsp");
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
        return "Servlet para actualizar datos de Perfil";
    }
}
