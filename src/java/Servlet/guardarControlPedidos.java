package Servlet;

import Modelo.ControlPedidos;
import Control.AccionesControlPedidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarControlPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String Pedido = request.getParameter("Pedido");
            String Razon_social = request.getParameter("Razon_social");
            String RUC = request.getParameter("RUC");
            String Direccion = request.getParameter("Direccion");
            String Referencia = request.getParameter("Referencia");
            String Contacto = request.getParameter("Contacto");
            String Telefono = request.getParameter("Telefono");
            String Condicion_pago = request.getParameter("Condicion_pago");

            double Precio_3kg_SF = Double.parseDouble(request.getParameter("Precio_3kg_SF"));
            double Precio_C_C = Double.parseDouble(request.getParameter("Precio_C_C"));
            double Precio_1_5kg = Double.parseDouble(request.getParameter("Precio_1_5kg"));

            String Tipo_documento = request.getParameter("Tipo_documento");

            int Cantidad_3kg = Integer.parseInt(request.getParameter("Cantidad_3kg"));
            int Cantidad_C_C = Integer.parseInt(request.getParameter("Cantidad_C_C"));
            int Cantidad_1_5kg = Integer.parseInt(request.getParameter("Cantidad_1_5kg"));

            int Cambio_3kg = Integer.parseInt(request.getParameter("Cambio_3kg"));
            int Cambio_C_C = Integer.parseInt(request.getParameter("Cambio_C_C"));
            int Cambio_1_5kg = Integer.parseInt(request.getParameter("Cambio_1_5kg"));

            double Precio_facturar = Double.parseDouble(request.getParameter("Precio_facturar"));
            double Valor_venta = Double.parseDouble(request.getParameter("Valor_venta"));
            double IGV_18 = Double.parseDouble(request.getParameter("IGV_18"));

            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char Estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            ControlPedidos pedido = new ControlPedidos();
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
            pedido.setUSUCRE(USUCRE);
            pedido.setFECCRE(FECCRE);
            pedido.setPCCRE(PCCRE);
            pedido.setEstado(Estado);

            int estatus = AccionesControlPedidos.registrarPedido(pedido);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Pedido registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Pedido.");
            }

            request.getRequestDispatcher("registrarControlPedidos.jsp").forward(request, response);
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
        return "Servlet para registrar Control de Pedidos";
    }
}
