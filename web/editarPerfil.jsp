<%@ page import="Modelo.Perfil" %>
<%@ page import="Control.AccionesPerfil" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Perfil - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
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
            width: 60%;
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
    <h1>Editar Perfil</h1>
    <div class="form-container">
        <form method="post" action="actualizarPerfil">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Perfil perfil = AccionesPerfil.buscarPerfilByID(id);
                String ip = "";
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>

            <input type="hidden" name="ID_PERFIL2" value="<%= perfil.getID_PERFIL() %>">

            <div class="mb-3">
                <label class="form-label">Nombre del Perfil</label>
                <input type="text" name="NOMBRE_PERFIL2" class="form-control" value="<%= perfil.getNOMBRE_PERFIL() %>" required>
            </div>

            <!-- Campos ocultos de auditoría -->
            <input type="hidden" name="USUMOD2" value="admin">
            <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
            <input type="hidden" name="PCMOD2" value="<%= ip %>">

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary">Actualizar Perfil</button>
            </div>
        </form>
    </div>
</body>
</html>
