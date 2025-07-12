package Servlet;

import Modelo.IngresoAlmacenProducto;
import Control.AccionesIngresoAlmacenProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarIngresoAlmacenProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String horaStr = request.getParameter("HORA");
            int cantidad = Integer.parseInt(request.getParameter("CANTIDAD"));
            String envase = request.getParameter("ENVASE");
            String loteEnvase = request.getParameter("LOTE_ENVASE");
            String presentacion = request.getParameter("PRESENTACION");
            String loteProducto = request.getParameter("LOTE_PRODUCTO");
            String fechaVencimientoStr = request.getParameter("FECHA_VENCIMIENTO");
            String usucre = request.getParameter("USUCRE");
            String feccreStr = request.getParameter("FECCRE");
            String pccre = request.getParameter("PCCRE");
            char estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalTime hora = LocalTime.parse(horaStr, timeFormatter);
            LocalDate fechaVencimiento = LocalDate.parse(fechaVencimientoStr, dateFormatter);
            LocalDateTime feccre = LocalDateTime.parse(feccreStr, dateTimeFormatter);

            IngresoAlmacenProducto ingreso = new IngresoAlmacenProducto();
            ingreso.setHORA(hora);
            ingreso.setCANTIDAD(cantidad);
            ingreso.setENVASE(envase);
            ingreso.setLOTE_ENVASE(loteEnvase);
            ingreso.setPRESENTACION(presentacion);
            ingreso.setLOTE_PRODUCTO(loteProducto);
            ingreso.setFECHA_VENCIMIENTO(fechaVencimiento);
            ingreso.setUSUCRE(usucre);
            ingreso.setFECCRE(feccre);
            ingreso.setPCCRE(pccre);
            ingreso.setESTADO(estado);

            int estatus = AccionesIngresoAlmacenProducto.registrarIngreso(ingreso);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Ingreso registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el ingreso.");
            }

            request.getRequestDispatcher("registrarIngresoAlmacen.jsp").forward(request, response);
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
        return "Servlet para registrar ingreso a almacén de producto terminado";
    }
}
