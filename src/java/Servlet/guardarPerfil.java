package Servlet;

import Modelo.Perfil;
import Control.AccionesPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class guardarPerfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String NOMBRE_PERFIL = request.getParameter("NOMBRE_PERFIL");
            String USUCRE = request.getParameter("USUCRE");
            String FECCREString = request.getParameter("FECCRE");
            String PCCRE = request.getParameter("PCCRE");
            char ESTADO = request.getParameter("ESTADO").charAt(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime FECCRE = LocalDateTime.parse(FECCREString, formatter);

            Perfil perfil = new Perfil();
            perfil.setNOMBRE_PERFIL(NOMBRE_PERFIL);
            perfil.setUSUCRE(USUCRE);
            perfil.setFECCRE(FECCRE);
            perfil.setPCCRE(PCCRE);
            perfil.setESTADO(ESTADO);

            int estatus = AccionesPerfil.registrarPerfil(perfil);

            if (estatus > 0) {
                request.setAttribute("mensaje", "Perfil registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el Perfil.");
            }

            request.getRequestDispatcher("registrarPerfil.jsp").forward(request, response);
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
        return "Servlet para registrar Perfil";
    }
}
