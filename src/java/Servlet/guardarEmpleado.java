package Servlet;

import Modelo.Empleado;
import Control.AccionesEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int ID_PERSONA = Integer.parseInt(request.getParameter("ID_PERSONA"));
            String CARGO = request.getParameter("CARGO");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Empleado empleado = new Empleado();
            empleado.setID_PERSONA(ID_PERSONA);
            empleado.setCARGO(CARGO);
            empleado.setUSUCRE(USUCRE);
            empleado.setFECCRE(FECCRE);
            empleado.setPCCRE(PCCRE);
            empleado.setESTADO(estado);

            int estatus = AccionesEmpleado.registrarEmpleado(empleado);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Empleado registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Empleado.");
            }

            request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
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
        return "Servlet para registrar Empleado";
    }
}
