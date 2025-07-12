package Servlet;

import Modelo.Empresa;
import Control.AccionesEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String razon_social = request.getParameter("razon_social");
            String nombre_comercial = request.getParameter("nombre_comercial");
            String ruc = request.getParameter("ruc");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String correo_electronico = request.getParameter("correo_electronico");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char estado = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Empresa empresa = new Empresa();
            empresa.setRazon_social(razon_social);
            empresa.setNombre_comercial(nombre_comercial);
            empresa.setRuc(ruc);
            empresa.setDireccion(direccion);
            empresa.setTelefono(telefono);
            empresa.setCorreo_electronico(correo_electronico);
            empresa.setUSUCRE(USUCRE);
            empresa.setFECCRE(FECCRE);
            empresa.setPCCRE(PCCRE);
            empresa.setEstado(estado);

            int estatus = AccionesEmpresa.registrarEmpresa(empresa);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Empresa registrada con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar la Empresa.");
            }

            request.getRequestDispatcher("registrarEmpresa.jsp").forward(request, response);
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
        return "Servlet para registrar Empresa";
    }
}
