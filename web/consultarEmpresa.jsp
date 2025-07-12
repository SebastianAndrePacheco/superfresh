<%@page import="Modelo.Empresa"%>
<%@page import="Control.AccionesEmpresa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Empresas - SUPERFRESH</title>
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
        .table thead {
            background-color: #007bff;
            color: white;
            font-size: 0.9rem;
        }
        .table tbody tr td {
            vertical-align: middle;
            white-space: nowrap;
            font-size: 0.82rem;
        }
        .btn-edit {
            background-color: #0d6efd;
            border: none;
            font-size: 0.78rem;
            padding: 4px 8px;
        }
        .btn-edit:hover {
            background-color: #0b5ed7;
        }
        .btn-disable {
            background-color: #dc3545;
            border: none;
            font-size: 0.78rem;
            padding: 4px 8px;
        }
        .btn-disable:hover {
            background-color: #bb2d3b;
        }
        .container {
            margin-bottom: 40px;
        }
        .table-responsive {
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Empresas Registradas</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>Razón Social</th>
                        <th>Nombre Comercial</th>
                        <th>RUC</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Correo Electrónico</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Empresa> lista = AccionesEmpresa.getAllEmpresas(); // Método que debes tener implementado
                        for (Empresa e : lista) {
                    %>
                    <tr>
                        <td><%= e.getRazon_social()%></td>
                        <td><%= e.getNombre_comercial()!= null ? e.getNombre_comercial(): "-" %></td>
                        <td><%= e.getRuc() %></td>
                        <td><%= e.getDireccion() != null ? e.getDireccion() : "-" %></td>
                        <td><%= e.getTelefono() != null ? e.getTelefono() : "-" %></td>
                        <td><%= e.getCorreo_electronico()!= null ? e.getCorreo_electronico(): "-" %></td>
                        <td>
                            <a href="editarEmpresa.jsp?id=<%= e.getId_empresa()%>" class="btn btn-edit btn-sm">Editar</a>
                        </td>
                        <td>
                            <a href="deshabilitarEmpresa?id=<%= e.getId_empresa()%>" class="btn btn-disable btn-sm"
                               onclick="return confirm('¿Está seguro de que desea deshabilitar esta empresa?');">
                               Deshabilitar
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
