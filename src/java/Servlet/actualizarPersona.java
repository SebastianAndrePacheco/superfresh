package Servlet;

import Control.AccionesPersona;
import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actualizarPersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            int ID_PERSONA = Integer.parseInt(request.getParameter("ID_PERSONA2"));
            String DISTRITO = request.getParameter("DISTRITO2");
            String APELLIDO_PATERNO = request.getParameter("APELLIDO_PATERNO2");
            String APELLIDO_MATERNO = request.getParameter("APELLIDO_MATERNO2");
            String NOMBRE = request.getParameter("NOMBRE2");
            String DNI = request.getParameter("DNI2");
            String CARNET_EXTRANJERO = request.getParameter("CARNET_EXTRANJERO2");
            String ESTADO_CIVIL = request.getParameter("ESTADO_CIVIL2");
            String FECHA_NACIMIENTO_STR = request.getParameter("FECHA_NACIMIENTO2");
            String DIRECCION = request.getParameter("DIRECCION2");
            String CELULAR = request.getParameter("CELULAR2");
            String EMAIL = request.getParameter("EMAIL2");
            String USUMOD = request.getParameter("USUMOD2");
            String FECMOD_STR = request.getParameter("FECMOD2");
            String PCMOD = request.getParameter("PCMOD2");

            // Formateadores
            LocalDate FECHA_NACIMIENTO = LocalDate.parse(FECHA_NACIMIENTO_STR);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECMOD = LocalDateTime.parse(FECMOD_STR, dtf);

            Persona persona = new Persona();
            persona.setID_PERSONA(ID_PERSONA);
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
            persona.setUSUMOD(USUMOD);
            persona.setFECMOD(FECMOD);
            persona.setPCMOD(PCMOD);

            int estatus = AccionesPersona.actualizarPersona(persona);

            if (estatus > 0) {
                response.sendRedirect("consultarPersona.jsp");
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
        return "Actualiza los datos de una persona";
    }
}
