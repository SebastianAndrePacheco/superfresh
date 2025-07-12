package Servlet;

import Control.AccionesIngresoAlmacenProducto;
import Modelo.IngresoAlmacenProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarIngresoAlmacenProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_INGRESO = Integer.parseInt(request.getParameter("ID_INGRESO2"));
            LocalTime HORA = LocalTime.parse(request.getParameter("HORA2"));
            int CANTIDAD = Integer.parseInt(request.getParameter("CANTIDAD2"));
            String ENVASE = request.getParameter("ENVASE2");
            String LOTE_ENVASE = request.getParameter("LOTE_ENVASE2");
            String PRESENTACION = request.getParameter("PRESENTACION2");
            String LOTE_PRODUCTO = request.getParameter("LOTE_PRODUCTO2");
            LocalDate FECHA_VENCIMIENTO = LocalDate.parse(request.getParameter("FECHA_VENCIMIENTO2"));
            String USUMOD = request.getParameter("USUMOD2");
            String FECMODStr = request.getParameter("FECMOD2");
            String PCMOD = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            IngresoAlmacenProducto ingreso = new IngresoAlmacenProducto();
            ingreso.setID_INGRESO(ID_INGRESO);
            ingreso.setHORA(HORA);
            ingreso.setCANTIDAD(CANTIDAD);
            ingreso.setENVASE(ENVASE);
            ingreso.setLOTE_ENVASE(LOTE_ENVASE);
            ingreso.setPRESENTACION(PRESENTACION);
            ingreso.setLOTE_PRODUCTO(LOTE_PRODUCTO);
            ingreso.setFECHA_VENCIMIENTO(FECHA_VENCIMIENTO);
            ingreso.setUSUMOD(USUMOD);
            ingreso.setFECMOD(FECMOD);
            ingreso.setPCMOD(PCMOD);

            int estatus = AccionesIngresoAlmacenProducto.actualizarIngreso(ingreso);
            if (estatus > 0) {
                response.sendRedirect("consultarIngresoAlmacenProducto.jsp");
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
        return "Servlet para actualizar IngresoAlmacenProducto";
    }
}
