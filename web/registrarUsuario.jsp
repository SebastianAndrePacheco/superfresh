<%@page import="Control.AccionesPersona"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.util.List"%>
<%@page import="Control.AccionesUsuario"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            margin: 30px 0 20px;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto 40px;
            padding: 25px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
        }
        label {
            font-weight: 600;
        }
        .btn-submit {
            margin-top: 20px;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registrar Usuario</h1>
        <div class="form-container">
            <form method="post" action="guardarUsuario">
                <div class="mb-3">
                    <label for="ID_PERSONA" class="form-label">Persona Asociada</label>
                    <select class="form-select" name="ID_PERSONA" id="ID_PERSONA" required>
                        <option value="" disabled selected>Seleccione una persona</option>
                        <%
                            List<Persona> personas = AccionesPersona.getAllPersonas();
                            for (Persona p : personas) {
                        %>
                            <option value="<%= p.getID_PERSONA() %>"><%= p.getNOMBRE() %> <%= p.getAPELLIDO_PATERNO() %></option>
                        <% } %>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="LOGEO" class="form-label">Nombre de Usuario</label>
                    <input type="text" class="form-control" id="LOGEO" name="LOGEO" required>
                </div>

                <div class="mb-3">
                    <label for="CLAVE" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="CLAVE" name="CLAVE" required>
                </div>

                <!-- Campos ocultos -->
                <input type="hidden" name="ESTADO" value="1">
                <input type="hidden" name="USUCRE" value="<%= session.getAttribute("userId") %>">
                <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
                <%
                    String ipv4Address = "";
                    try {
                        ipv4Address = InetAddress.getLocalHost().getHostAddress();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <input type="hidden" name="PCCRE" value="<%= ipv4Address %>">

                <button type="submit" class="btn btn-primary btn-submit">Registrar Usuario</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
