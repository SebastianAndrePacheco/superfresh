package Servlet;

import Modelo.Submenu;
import Control.AccionesSubmenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarSubmenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int ID_MENU = Integer.parseInt(request.getParameter("ID_MENU"));
            String NOMBRE_SUBMENU = request.getParameter("NOMBRE_SUBMENU");
            String NOMBRE_FORMULARIO = request.getParameter("NOMBRE_FORMULARIO");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Submenu submenu = new Submenu();
            submenu.setID_MENU(ID_MENU);
            submenu.setNOMBRE_SUBMENU(NOMBRE_SUBMENU);
            submenu.setNOMBRE_FORMULARIO(NOMBRE_FORMULARIO);
            submenu.setUSUCRE(USUCRE);
            submenu.setFECCRE(FECCRE);
            submenu.setPCCRE(PCCRE);

            int estatus = AccionesSubmenu.registrarSubmenu(submenu);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Submenú registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Submenú.");
            }

            request.getRequestDispatcher("registrarSubmenu.jsp").forward(request, response);
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
        return "Servlet para registrar Submenú";
    }
}
