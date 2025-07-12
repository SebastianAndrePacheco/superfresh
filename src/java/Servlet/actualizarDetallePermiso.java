package Servlet;

import Control.AccionesDetallePermiso;
import Modelo.DetallePermiso;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarDetallePermiso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_DETALLE_PERMISO = Integer.parseInt(request.getParameter("ID_DETALLE_PERMISO2"));
            int ID_PERFIL          = Integer.parseInt(request.getParameter("ID_PERFIL2"));
            int ID_SUBMENU         = Integer.parseInt(request.getParameter("ID_SUBMENU2"));
            String ACCESO          = request.getParameter("ACCESO2");
            String USUMOD          = request.getParameter("USUMOD2");
            String FECMODStr       = request.getParameter("FECMOD2");
            String PCMOD           = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            DetallePermiso permiso = new DetallePermiso();
            permiso.setID_DETALLE_PERMISO(ID_DETALLE_PERMISO);
            permiso.setID_PERFIL(ID_PERFIL);
            permiso.setID_SUBMENU(ID_SUBMENU);
            permiso.setACCESO(ACCESO.charAt(0));
            permiso.setUSUMOD(USUMOD);
            permiso.setFECMOD(FECMOD);
            permiso.setPCMOD(PCMOD);

            int estatus = AccionesDetallePermiso.actualizarDetallePermiso(permiso);
            if (estatus > 0) {
                response.sendRedirect("consultarDetallePermiso.jsp");
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
        return "Servlet para actualizar datos de DetallePermiso";
    }
}
