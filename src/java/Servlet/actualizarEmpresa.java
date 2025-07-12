package Servlet;

import Control.AccionesEmpresa;
import Modelo.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id_empresa = Integer.parseInt(request.getParameter("id_empresa2"));
            String razon_social = request.getParameter("razon_social2");
            String nombre_comercial = request.getParameter("nombre_comercial2");
            String ruc = request.getParameter("ruc2");
            String direccion = request.getParameter("direccion2");
            String telefono = request.getParameter("telefono2");
            String correo_electronico = request.getParameter("correo_electronico2");
            String usumod = request.getParameter("usumod2");
            String fecmodStr = request.getParameter("fecmod2");
            String pcmod = request.getParameter("pcmod2");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fecmod = LocalDateTime.parse(fecmodStr, dtf);

            Empresa emp = new Empresa();
            emp.setId_empresa(id_empresa);
            emp.setRazon_social(razon_social);
            emp.setNombre_comercial(nombre_comercial);
            emp.setRuc(ruc);
            emp.setDireccion(direccion);
            emp.setTelefono(telefono);
            emp.setCorreo_electronico(correo_electronico);
            emp.setUSUMOD(usumod);
            emp.setFECMOD(fecmod);
            emp.setPCMOD(pcmod);

            int estatus = AccionesEmpresa.actualizarEmpresa(emp);
            if (estatus > 0) {
                response.sendRedirect("consultarEmpresa.jsp");
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
        return "Servlet para actualizar datos de Empresa";
    }
}
