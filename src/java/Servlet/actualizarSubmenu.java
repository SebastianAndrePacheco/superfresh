package Servlet;

import Control.AccionesSubmenu;
import Modelo.Submenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarSubmenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_SUBMENU = Integer.parseInt(request.getParameter("ID_SUBMENU2"));
            int ID_MENU = Integer.parseInt(request.getParameter("ID_MENU2"));
            String NOMBRE_SUBMENU = request.getParameter("NOMBRE_SUBMENU2");
            String NOMBRE_FORMULARIO = request.getParameter("NOMBRE_FORMULARIO2");
            String USUMOD = request.getParameter("USUMOD2");
            String FECMODStr = request.getParameter("FECMOD2");
            String PCMOD = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            Submenu submenu = new Submenu();
            submenu.setID_SUBMENU(ID_SUBMENU);
            submenu.setID_MENU(ID_MENU);
            submenu.setNOMBRE_SUBMENU(NOMBRE_SUBMENU);
            submenu.setNOMBRE_FORMULARIO(NOMBRE_FORMULARIO);
            submenu.setUSUMOD(USUMOD);
            submenu.setFECMOD(FECMOD);
            submenu.setPCMOD(PCMOD);

            int estatus = AccionesSubmenu.actualizarSubmenu(submenu);
            if (estatus > 0) {
                response.sendRedirect("consultarSubmenu.jsp");
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
        return "Servlet para actualizar datos de Submenu";
    }
}
