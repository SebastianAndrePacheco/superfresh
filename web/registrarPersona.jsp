<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registrar Persona - SUPERFRESH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            margin: 30px 0;
            text-align: center;
            color: #007bff;
            font-weight: 700;
        }
        label {
            font-weight: 600;
        }
        .form-control {
            font-size: 0.9rem;
        }
        .btn-primary {
            font-size: 0.85rem;
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

    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<div class="container mt-4 mb-5">
    <h1>Registrar Persona</h1>
    <form method="post" action="guardarPersona" class="row g-3">
        <div class="col-md-6">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" name="NOMBRE" id="nombre" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label for="apellidoPaterno" class="form-label">Apellido Paterno</label>
            <input type="text" name="APELLIDO_PATERNO" id="apellidoPaterno" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label for="apellidoMaterno" class="form-label">Apellido Materno</label>
            <input type="text" name="APELLIDO_MATERNO" id="apellidoMaterno" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="dni" class="form-label">DNI</label>
            <input type="text" name="DNI" id="dni" class="form-control" maxlength="8">
        </div>
        <div class="col-md-6">
            <label for="carnet" class="form-label">Carnet Extranjero</label>
            <input type="text" name="CARNET_EXTRANJERO" id="carnet" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="estadoCivil" class="form-label">Estado Civil</label>
            <select name="ESTADO_CIVIL" id="estadoCivil" class="form-select">
                <option value="SO">Soltero</option>
                <option value="CA">Casado</option>
                <option value="VI">Viudo</option>
                <option value="DI">Divorciado</option>
            </select>
        </div>
        <div class="col-md-6">
            <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
            <input type="date" name="FECHA_NACIMIENTO" id="fechaNacimiento" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="distrito" class="form-label">Distrito</label>
            <input type="text" name="DISTRITO" id="distrito" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" name="DIRECCION" id="direccion" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="celular" class="form-label">Celular</label>
            <input type="text" name="CELULAR" id="celular" class="form-control" maxlength="9">
        </div>
        <div class="col-md-6">
            <label for="email" class="form-label">Correo Electrónico</label>
            <input type="email" name="EMAIL" id="email" class="form-control">
        </div>

        <!-- Campos ocultos de auditoría -->
        <input type="hidden" name="USUCRE" value="<%= userId %>">
        <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCCRE" value="<%= ip %>">
        <input type="hidden" name="ESTADO" value="1">

        <div class="col-12 text-center mt-3">
            <button type="submit" class="btn btn-primary px-5">Registrar Persona</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
