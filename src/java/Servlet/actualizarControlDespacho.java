package Servlet;

import Control.AccionesControlDespacho;
import Modelo.ControlDespacho;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarControlDespacho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_DESPACHO = Integer.parseInt(request.getParameter("ID_DESPACHO2"));
            String Tipo               = request.getParameter("Tipo2");
            LocalDate Fecha           = LocalDate.parse(request.getParameter("Fecha2"));
            int Cantidad              = Integer.parseInt(request.getParameter("Cantidad2"));
            String Envase             = request.getParameter("Envase2");
            String Lote_envase        = request.getParameter("Lote_envase2");
            String Presentacion       = request.getParameter("Presentacion2");
            String Lote_producto      = request.getParameter("Lote_producto2");
            LocalDate Fecha_vencimiento = LocalDate.parse(request.getParameter("Fecha_vencimiento2"));
            String Cliente            = request.getParameter("Cliente2");
            String Observaciones      = request.getParameter("Observaciones2");
            String USUMOD             = request.getParameter("USUMOD2");
            String FECMODStr          = request.getParameter("FECMOD2");
            String PCMOD              = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            ControlDespacho despacho = new ControlDespacho();
            despacho.setID_DESPACHO(ID_DESPACHO);
            despacho.setTipo(Tipo);
            despacho.setFecha(Fecha);
            despacho.setCantidad(Cantidad);
            despacho.setEnvase(Envase);
            despacho.setLote_envase(Lote_envase);
            despacho.setPresentacion(Presentacion);
            despacho.setLote_producto(Lote_producto);
            despacho.setFecha_vencimiento(Fecha_vencimiento);
            despacho.setCliente(Cliente);
            despacho.setObservaciones(Observaciones);
            despacho.setUSUMOD(USUMOD);
            despacho.setFECMOD(FECMOD);
            despacho.setPCMOD(PCMOD);

            int estatus = AccionesControlDespacho.actualizarControlDespacho(despacho);
            if (estatus > 0) {
                response.sendRedirect("consultarControlDespacho.jsp");
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
        return "Servlet para actualizar Control de Despacho";
    }
}
