package Servlet;

import Control.AccionesMenu;
import Modelo.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_MENU = Integer.parseInt(request.getParameter("ID_MENU2"));
            String NOMBRE_MENU = request.getParameter("NOMBRE_MENU2");
            String USUMOD = request.getParameter("USUMOD2");
            String FECMODStr = request.getParameter("FECMOD2");
            String PCMOD = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            Menu menu = new Menu();
            menu.setID_MENU(ID_MENU);
            menu.setNOMBRE_MENU(NOMBRE_MENU);
            menu.setUSUMOD(USUMOD);
            menu.setFECMOD(FECMOD);
            menu.setPCMOD(PCMOD);

            int estatus = AccionesMenu.actualizarMenu(menu);
            if (estatus > 0) {
                response.sendRedirect("consultarMenu.jsp");
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
        return "Servlet para actualizar datos de Menu";
    }
}
