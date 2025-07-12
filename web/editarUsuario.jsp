<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.Persona" %>
<%@ page import="Control.AccionesUsuario" %>
<%@ page import="Control.AccionesPersona" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario - SUPERFRESH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        h1 {
            text-align: center;
            margin: 30px 0;
            color: #007bff;
            font-weight: bold;
        }
        .form-container {
            width: 65%;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-label {
            font-weight: 600;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Editar Usuario</h1>
    <div class="form-container">
        <form method="post" action="actualizarUsuario">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = AccionesUsuario.buscarUsuarioByID(id);
                String ip = "";
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>

            <input type="hidden" name="ID_USUARIO2" value="<%= usuario.getID_USUARIO() %>">

            <div class="mb-3">
                <label class="form-label">Persona asignada</label>
                <select name="ID_PERSONA2" class="form-select" required>
                    <%
                        List<Persona> lista = AccionesPersona.getAllPersonas();
                        for (Persona p : lista) {
                    %>
                        <option value="<%= p.getID_PERSONA() %>" <%= (usuario.getID_PERSONA() == p.getID_PERSONA()) ? "selected" : "" %>>
                            <%= p.getNOMBRE() + " " + p.getAPELLIDO_PATERNO() + " " + p.getAPELLIDO_MATERNO() %>
                        </option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Nombre de Usuario</label>
                <input type="text" name="LOGEO2" class="form-control" value="<%= usuario.getLOGEO() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input type="text" name="CLAVE2" class="form-control" value="<%= usuario.getCLAVE() %>" required>
            </div>

            <!-- Campos ocultos de auditoría -->
            <input type="hidden" name="USUMOD2" value="admin">
            <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
            <input type="hidden" name="PCMOD2" value="<%= ip %>">

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary">Actualizar Usuario</button>
            </div>
        </form>
    </div>
</body>
</html>
