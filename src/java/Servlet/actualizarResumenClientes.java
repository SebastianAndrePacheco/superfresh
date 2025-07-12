package Servlet;

import Control.AccionesResumenClientes;
import Modelo.ResumenClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarResumenClientes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int ID_CLIENTE      = Integer.parseInt(request.getParameter("ID_CLIENTE2"));
            int Numero          = Integer.parseInt(request.getParameter("Numero2"));
            String Razon_social = request.getParameter("Razon_social2");
            String RUC          = request.getParameter("RUC2");
            String Direccion    = request.getParameter("Direccion2");
            String Referencia   = request.getParameter("Referencia2");
            String Contacto     = request.getParameter("Contacto2");
            String Telefono     = request.getParameter("Telefono2");
            String Condicion    = request.getParameter("Condicion2");
            double Precio_3kg_SF = Double.parseDouble(request.getParameter("Precio_3kg_SF2"));
            double Precio_C_C    = Double.parseDouble(request.getParameter("Precio_C_C2"));
            double Precio_1_5kg  = Double.parseDouble(request.getParameter("Precio_1_5kg2"));
            String USUMOD       = request.getParameter("USUMOD2");
            String FECMODStr    = request.getParameter("FECMOD2");
            String PCMOD        = request.getParameter("PCMOD2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMODStr, dtf);

            ResumenClientes cliente = new ResumenClientes();
            cliente.setID_CLIENTE(ID_CLIENTE);
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
            cliente.setUSUMOD(USUMOD);
            cliente.setFECMOD(FECMOD);
            cliente.setPCMOD(PCMOD);

            int estatus = AccionesResumenClientes.actualizarResumenCliente(cliente);
            if (estatus > 0) {
                response.sendRedirect("consultarResumenClientes.jsp");
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
        return "Servlet para actualizar ResumenClientes";
    }
}
