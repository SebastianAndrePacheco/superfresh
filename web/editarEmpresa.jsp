<%@page import="Modelo.Empresa"%>
<%@page import="Control.AccionesEmpresa"%>
<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Empresa - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            text-align: center;
            margin: 30px 0;
            color: #007bff;
            font-weight: 700;
        }
        .form-container {
            width: 70%;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        .form-group label {
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
    <h1>Editar Empresa</h1>
    <div class="form-container">
        <form method="post" action="actualizarEmpresa">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Empresa emp = AccionesEmpresa.buscarEmpresaByID(id);
                String ip = "";
                try {
                    ip = java.net.InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            <input type="hidden" name="id_empresa2" value="<%= emp.getId_empresa() %>">
            <div class="row mb-3">
                <div class="col">
                    <label>Razón Social</label>
                    <input type="text" class="form-control" name="razon_social2" value="<%= emp.getRazon_social() %>" required>
                </div>
                <div class="col">
                    <label>Nombre Comercial</label>
                    <input type="text" class="form-control" name="nombre_comercial2" value="<%= emp.getNombre_comercial() %>">
                </div>
                <div class="col">
                    <label>RUC</label>
                    <input type="text" class="form-control" name="ruc2" value="<%= emp.getRuc() %>" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <label>Dirección</label>
                    <input type="text" class="form-control" name="direccion2" value="<%= emp.getDireccion() %>">
                </div>
                <div class="col">
                    <label>Teléfono</label>
                    <input type="text" class="form-control" name="telefono2" value="<%= emp.getTelefono() %>">
                </div>
                <div class="col">
                    <label>Correo Electrónico</label>
                    <input type="email" class="form-control" name="correo_electronico2" value="<%= emp.getCorreo_electronico() %>">
                </div>
            </div>

            <!-- Datos de modificación -->
            <input type="hidden" name="usumod2" value="admin">
            <input type="hidden" name="fecmod2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
            <input type="hidden" name="pcmod2" value="<%= ip %>">

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Actualizar Empresa</button>
            </div>
        </form>
    </div>
</body>
</html>
