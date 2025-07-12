package Servlet;

import Modelo.ControlDespacho;
import Control.AccionesControlDespacho;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarControlDespacho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String Tipo = request.getParameter("Tipo");
            String FechaStr = request.getParameter("Fecha");
            int Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
            String Envase = request.getParameter("Envase");
            String Lote_envase = request.getParameter("Lote_envase");
            String Presentacion = request.getParameter("Presentacion");
            String Lote_producto = request.getParameter("Lote_producto");
            String Fecha_vencimientoStr = request.getParameter("Fecha_vencimiento");
            String Cliente = request.getParameter("Cliente");
            String Observaciones = request.getParameter("Observaciones");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREStr = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDate Fecha = LocalDate.parse(FechaStr, dateFormatter);
            LocalDate Fecha_vencimiento = LocalDate.parse(Fecha_vencimientoStr, dateFormatter);
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREStr, datetimeFormatter);

            ControlDespacho despacho = new ControlDespacho();
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
            despacho.setUSUCRE(USUCRE);
            despacho.setFECCRE(FECCRE);
            despacho.setPCCRE(PCCRE);
            despacho.setEstado(estado);

            int estatus = AccionesControlDespacho.registrarControlDespacho(despacho);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Despacho registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el despacho.");
            }

            request.getRequestDispatcher("registrarControlDespacho.jsp").forward(request, response);
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
        return "Servlet para registrar control de despacho";
    }
}
