package Servlet;

import Control.AccionesEmpleado;
import Modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_EMPLEADO = Integer.parseInt(request.getParameter("ID_EMPLEADO2"));
            int ID_PERSONA    = Integer.parseInt(request.getParameter("ID_PERSONA2"));
            String CARGO      = request.getParameter("CARGO2");
            String USUMOD     = request.getParameter("USUMOD2");
            String FECMODStr  = request.getParameter("FECMOD2");
            String PCMOD      = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            Empleado emp = new Empleado();
            emp.setID_EMPLEADO(ID_EMPLEADO);
            emp.setID_PERSONA(ID_PERSONA);
            emp.setCARGO(CARGO);
            emp.setUSUMOD(USUMOD);
            emp.setFECMOD(FECMOD);
            emp.setPCMOD(PCMOD);

            int estatus = AccionesEmpleado.actualizarEmpleado(emp);
            if (estatus > 0) {
                response.sendRedirect("consultarEmpleado.jsp");
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
        return "Servlet para actualizar datos de Empleado";
    }
}
