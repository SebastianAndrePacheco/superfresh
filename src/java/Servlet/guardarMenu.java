package Servlet;

import Modelo.Menu;
import Control.AccionesMenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String NOMBRE_MENU = request.getParameter("NOMBRE_MENU");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Menu menu = new Menu();
            menu.setNOMBRE_MENU(NOMBRE_MENU);
            menu.setUSUCRE(USUCRE);
            menu.setFECCRE(FECCRE);
            menu.setPCCRE(PCCRE);

            int estatus = AccionesMenu.registrarMenu(menu);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Menú registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Menú.");
            }

            request.getRequestDispatcher("registrarMenu.jsp").forward(request, response);
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
        return "Servlet para registrar Menu";
    }
}
