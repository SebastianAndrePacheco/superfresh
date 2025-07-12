package Servlet;

import Modelo.DetallePermiso;
import Control.AccionesDetallePermiso;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarDetallePermiso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int ID_PERFIL = Integer.parseInt(request.getParameter("ID_PERFIL"));
            int ID_SUBMENU = Integer.parseInt(request.getParameter("ID_SUBMENU"));
            char ACCESO = request.getParameter("ACCESO").charAt(0);
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            DetallePermiso permiso = new DetallePermiso();
            permiso.setID_PERFIL(ID_PERFIL);
            permiso.setID_SUBMENU(ID_SUBMENU);
            permiso.setACCESO(ACCESO);
            permiso.setUSUCRE(USUCRE);
            permiso.setFECCRE(FECCRE);
            permiso.setPCCRE(PCCRE);

            int estatus = AccionesDetallePermiso.registrarDetallePermiso(permiso);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Permiso registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Permiso.");
            }

            request.getRequestDispatcher("registrarDetallePermiso.jsp").forward(request, response);
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
        return "Servlet para registrar Detalle Permiso";
    }
}
