package Servlet;

import Modelo.Persona;
import Control.AccionesPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarPersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String DISTRITO = request.getParameter("DISTRITO");
            String APELLIDO_PATERNO = request.getParameter("APELLIDO_PATERNO");
            String APELLIDO_MATERNO = request.getParameter("APELLIDO_MATERNO");
            String NOMBRE = request.getParameter("NOMBRE");
            String DNI = request.getParameter("DNI");
            String CARNET_EXTRANJERO = request.getParameter("CARNET_EXTRANJERO");
            String ESTADO_CIVIL = request.getParameter("ESTADO_CIVIL");
            LocalDate FECHA_NACIMIENTO = LocalDate.parse(request.getParameter("FECHA_NACIMIENTO"));
            String DIRECCION = request.getParameter("DIRECCION");
            String CELULAR = request.getParameter("CELULAR");
            String EMAIL = request.getParameter("EMAIL");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char ESTADO = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Persona persona = new Persona();
            persona.setDISTRITO(DISTRITO);
            persona.setAPELLIDO_PATERNO(APELLIDO_PATERNO);
            persona.setAPELLIDO_MATERNO(APELLIDO_MATERNO);
            persona.setNOMBRE(NOMBRE);
            persona.setDNI(DNI);
            persona.setCARNET_EXTRANJERO(CARNET_EXTRANJERO);
            persona.setESTADO_CIVIL(ESTADO_CIVIL);
            persona.setFECHA_NACIMIENTO(FECHA_NACIMIENTO);
            persona.setDIRECCION(DIRECCION);
            persona.setCELULAR(CELULAR);
            persona.setEMAIL(EMAIL);
            persona.setUSUCRE(USUCRE);
            persona.setFECCRE(FECCRE);
            persona.setPCCRE(PCCRE);
            persona.setEstado(ESTADO);

            int estatus = AccionesPersona.registrarPersona(persona);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Persona registrada con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar la Persona.");
            }

            request.getRequestDispatcher("registrarPersona.jsp").forward(request, response);
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
        return "Servlet para registrar Persona";
    }
}
