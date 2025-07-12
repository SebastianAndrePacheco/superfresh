<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registrar Empresa - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            margin: 30px 0 20px 0;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .form-label {
            font-weight: bold;
            font-size: 0.85rem;
        }
        .form-control {
            font-size: 0.85rem;
        }
        .btn-primary {
            font-size: 0.85rem;
        }
        .container {
            max-width: 700px;
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String ipv4Address = "";
    try {
        InetAddress ip = InetAddress.getLocalHost();
        ipv4Address = ip.getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<div class="container">
    <h1>Registrar Nueva Empresa</h1>
    <form method="post" action="guardarEmpresa">
        <div class="mb-3">
            <label for="razon_social" class="form-label">Razón Social *</label>
            <input type="text" class="form-control" name="razon_social" required>
        </div>
        <div class="mb-3">
            <label for="nombre_comercial" class="form-label">Nombre Comercial</label>
            <input type="text" class="form-control" name="nombre_comercial">
        </div>
        <div class="mb-3">
            <label for="ruc" class="form-label">RUC *</label>
            <input type="text" class="form-control" name="ruc" maxlength="11" required>
        </div>
        <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" name="direccion">
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono</label>
            <input type="text" class="form-control" name="telefono" maxlength="9">
        </div>
        <div class="mb-3">
            <label for="correo_electronico" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" name="correo_electronico">
        </div>

        <!-- Datos ocultos para auditoría -->
        <input type="hidden" name="ESTADO" value="1">
        <input type="hidden" name="USUCRE" value="<%= userId %>">
        <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCCRE" value="<%= ipv4Address %>">

        <div class="text-center mt-4">
            <input type="submit" class="btn btn-primary" value="Registrar Empresa">
        </div>
    </form>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
