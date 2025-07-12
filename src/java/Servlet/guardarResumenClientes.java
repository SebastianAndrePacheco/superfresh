package Servlet;

import Modelo.ResumenClientes;
import Control.AccionesResumenClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarResumenClientes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int Numero = Integer.parseInt(request.getParameter("Numero"));
            String Razon_social = request.getParameter("Razon_social");
            String RUC = request.getParameter("RUC");
            String Direccion = request.getParameter("Direccion");
            String Referencia = request.getParameter("Referencia");
            String Contacto = request.getParameter("Contacto");
            String Telefono = request.getParameter("Telefono");
            String Condicion = request.getParameter("Condicion");
            double Precio_3kg_SF = Double.parseDouble(request.getParameter("Precio_3kg_SF"));
            double Precio_C_C = Double.parseDouble(request.getParameter("Precio_C_C"));
            double Precio_1_5kg = Double.parseDouble(request.getParameter("Precio_1_5kg"));
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            ResumenClientes cliente = new ResumenClientes();
            cliente.setNumero(Numero);
            cliente.setRazon_social(Razon_social);
            cliente.setRUC(RUC);
            cliente.setDireccion(Direccion);
            cliente.setReferencia(Referencia);
            cliente.setContacto(Contacto);
            cliente.setTelefono(Telefono);
            cliente.setCondicion(Condicion);
            cliente.setPrecio_3kg_SF(Precio_3kg_SF);
            cliente.setPrecio_C_C(Precio_C_C);
            cliente.setPrecio_1_5kg(Precio_1_5kg);
            cliente.setUSUCRE(USUCRE);
            cliente.setFECCRE(FECCRE);
            cliente.setPCCRE(PCCRE);
            cliente.setEstado(estado);

            int estatus = AccionesResumenClientes.registrarResumenCliente(cliente);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Resumen de cliente registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el resumen de cliente.");
            }

            request.getRequestDispatcher("registrarResumenClientes.jsp").forward(request, response);
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
        return "Servlet para registrar resumen de clientes";
    }
}
