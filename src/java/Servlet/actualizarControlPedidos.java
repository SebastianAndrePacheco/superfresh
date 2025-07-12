package Servlet;

import Control.AccionesControlPedidos;
import Modelo.ControlPedidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarControlPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_PEDIDO = Integer.parseInt(request.getParameter("ID_PEDIDO2"));
            String Pedido          = request.getParameter("Pedido2");
            String Razon_social    = request.getParameter("Razon_social2");
            String RUC             = request.getParameter("RUC2");
            String Direccion       = request.getParameter("Direccion2");
            String Referencia      = request.getParameter("Referencia2");
            String Contacto        = request.getParameter("Contacto2");
            String Telefono        = request.getParameter("Telefono2");
            String Condicion_pago  = request.getParameter("Condicion_pago2");
            double Precio_3kg_SF   = Double.parseDouble(request.getParameter("Precio_3kg_SF2"));
            double Precio_C_C      = Double.parseDouble(request.getParameter("Precio_C_C2"));
            double Precio_1_5kg    = Double.parseDouble(request.getParameter("Precio_1_5kg2"));
            String Tipo_documento  = request.getParameter("Tipo_documento2");
            int Cantidad_3kg       = Integer.parseInt(request.getParameter("Cantidad_3kg2"));
            int Cantidad_C_C       = Integer.parseInt(request.getParameter("Cantidad_C_C2"));
            int Cantidad_1_5kg     = Integer.parseInt(request.getParameter("Cantidad_1_5kg2"));
            int Cambio_3kg         = Integer.parseInt(request.getParameter("Cambio_3kg2"));
            int Cambio_C_C         = Integer.parseInt(request.getParameter("Cambio_C_C2"));
            int Cambio_1_5kg       = Integer.parseInt(request.getParameter("Cambio_1_5kg2"));
            double Precio_facturar = Double.parseDouble(request.getParameter("Precio_facturar2"));
            double Valor_venta     = Double.parseDouble(request.getParameter("Valor_venta2"));
            double IGV_18          = Double.parseDouble(request.getParameter("IGV_182"));
            String USUMOD          = request.getParameter("USUMOD2");
            String FECMODStr       = request.getParameter("FECMOD2");
            String PCMOD           = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            ControlPedidos pedido = new ControlPedidos();
            pedido.setID_PEDIDO(ID_PEDIDO);
            pedido.setPedido(Pedido);
            pedido.setRazon_social(Razon_social);
            pedido.setRUC(RUC);
            pedido.setDireccion(Direccion);
            pedido.setReferencia(Referencia);
            pedido.setContacto(Contacto);
            pedido.setTelefono(Telefono);
            pedido.setCondicion_pago(Condicion_pago);
            pedido.setPrecio_3kg_SF(Precio_3kg_SF);
            pedido.setPrecio_C_C(Precio_C_C);
            pedido.setPrecio_1_5kg(Precio_1_5kg);
            pedido.setTipo_documento(Tipo_documento);
            pedido.setCantidad_3kg(Cantidad_3kg);
            pedido.setCantidad_C_C(Cantidad_C_C);
            pedido.setCantidad_1_5kg(Cantidad_1_5kg);
            pedido.setCambio_3kg(Cambio_3kg);
            pedido.setCambio_C_C(Cambio_C_C);
            pedido.setCambio_1_5kg(Cambio_1_5kg);
            pedido.setPrecio_facturar(Precio_facturar);
            pedido.setValor_venta(Valor_venta);
            pedido.setIGV_18(IGV_18);
            pedido.setUSUMOD(USUMOD);
            pedido.setFECMOD(FECMOD);
            pedido.setPCMOD(PCMOD);

            int estatus = AccionesControlPedidos.actualizarPedido(pedido);
            if (estatus > 0) {
                response.sendRedirect("consultarControlPedidos.jsp");
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
        return "Servlet para actualizar Control de Pedidos";
    }
}
