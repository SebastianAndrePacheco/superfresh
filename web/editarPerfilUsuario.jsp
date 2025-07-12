<%@ page import="Modelo.PerfilUsuario" %>
<%@ page import="Modelo.Perfil" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="Control.AccionesPerfilUsuario" %>
<%@ page import="Control.AccionesPerfil" %>
<%@ page import="Control.AccionesUsuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Perfil de Usuario - SUPERFRESH</title>
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
    <h1>Editar Perfil Usuario</h1>
    <div class="form-container">
        <form method="post" action="actualizarPerfilUsuario">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                PerfilUsuario pu = AccionesPerfilUsuario.buscarPerfilUsuarioByID(id);
                String ip = "";
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>

            <input type="hidden" name="ID_PERFIL_USUARIO2" value="<%= pu.getID_PERFIL_USUARIO() %>">

            <div class="mb-3">
                <label class="form-label">Usuario</label>
                <select name="ID_USUARIO2" class="form-select" required>
                    <%
                        List<Usuario> usuarios = AccionesUsuario.getAllUsuarios();
                        for (Usuario u : usuarios) {
                    %>
                    <option value="<%= u.getID_USUARIO() %>" <%= (pu.getID_USUARIO() == u.getID_USUARIO()) ? "selected" : "" %>>
                        <%= u.getLOGEO() %>
                    </option>
                    <% } %>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Perfil</label>
                <select name="ID_PERFIL2" class="form-select" required>
                    <%
                        List<Perfil> perfiles = AccionesPerfil.getAllPerfiles();
                        for (Perfil p : perfiles) {
                    %>
                    <option value="<%= p.getID_PERFIL() %>" <%= (pu.getID_PERFIL() == p.getID_PERFIL()) ? "selected" : "" %>>
                        <%= p.getNOMBRE_PERFIL() %>
                    </option>
                    <% } %>
                </select>
            </div>

            <!-- Campos ocultos de auditoría -->
            <input type="hidden" name="USUMOD2" value="admin">
            <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
            <input type="hidden" name="PCMOD2" value="<%= ip %>">

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary">Actualizar Perfil Usuario</button>
            </div>
        </form>
    </div>
</body>
</html>
