<%@page import="Control.AccionesPersona"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="Control.AccionesEmpleado"%>
<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Empleado</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        h1 {
            margin: 30px 0 20px 0;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            background-color: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
        }
        label {
            font-weight: 600;
            margin-top: 10px;
        }
        .btn-primary {
            margin-top: 20px;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registrar Empleado</h1>
        <div class="form-container">
            <form method="post" action="guardarEmpleado">
                <div class="mb-3">
                    <label for="ID_PERSONA" class="form-label">Seleccione una Persona</label>
                    <select class="form-select" name="ID_PERSONA" id="ID_PERSONA" required>
                        <option value="">-- Seleccione --</option>
                        <%
                            List<Persona> personas = AccionesPersona.getAllPersonas();
                            for (Persona p : personas) {
                        %>
                        <option value="<%= p.getID_PERSONA() %>">
                            <%= p.getNOMBRE() %> <%= p.getAPELLIDO_PATERNO() %> <%= p.getAPELLIDO_MATERNO() %>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="CARGO" class="form-label">Cargo del Empleado</label>
                    <input type="text" class="form-control" name="CARGO" id="CARGO" required>
                </div>

                <!-- Datos ocultos -->
                <input type="hidden" name="ESTADO" value="1">
                <input type="hidden" name="USUCRE" value="<%= session.getAttribute("userId") %>">
                <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
                <%
                    String ipv4Address = "";
                    try {
                        InetAddress ip = InetAddress.getLocalHost();
                        ipv4Address = ip.getHostAddress();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <input type="hidden" name="PCCRE" value="<%= ipv4Address %>">

                <button type="submit" class="btn btn-primary">Registrar Empleado</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
