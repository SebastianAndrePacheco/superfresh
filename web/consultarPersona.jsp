<%@page import="Modelo.Persona"%>
<%@page import="Control.AccionesPersona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Personas - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem; /* Letra un poco más pequeña para más contenido visible */
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
            white-space: nowrap; /* Para que no se partan textos */
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
        /* Scroll horizontal si tabla es demasiado ancha */
        .table-responsive {
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Personas Registradas</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>Distrito</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Carnet Extranjero</th>
                        <th>Estado Civil</th>
                        <th>Fecha Nacimiento</th>
                        <th>Dirección</th>
                        <th>Celular</th>
                        <th>Email</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Persona> lista = AccionesPersona.getAllPersonas();
                        for (Persona p : lista) {
                    %>
                    <tr>
                        <td><%= p.getDISTRITO() %></td>
                        <td><%= p.getAPELLIDO_PATERNO() %></td>
                        <td><%= p.getAPELLIDO_MATERNO() %></td>
                        <td><%= p.getNOMBRE() %></td>
                        <td><%= p.getDNI() %></td>
                        <td><%= p.getCARNET_EXTRANJERO() != null ? p.getCARNET_EXTRANJERO() : "-" %></td>
                        <td><%= p.getESTADO_CIVIL() %></td>
                        <td><%= p.getFECHA_NACIMIENTO() != null ? p.getFECHA_NACIMIENTO().toString() : "-" %></td>
                        <td><%= p.getDIRECCION() != null ? p.getDIRECCION() : "-" %></td>
                        <td><%= p.getCELULAR() != null ? p.getCELULAR() : "-" %></td>
                        <td><%= p.getEMAIL() != null ? p.getEMAIL() : "-" %></td>
                        <td>
                            <a href="editarPersona.jsp?id=<%= p.getID_PERSONA() %>" class="btn btn-edit btn-sm">Editar</a>
                        </td>
                        <td>
                            <a href="deshabilitarPersona?id=<%= p.getID_PERSONA() %>" class="btn btn-disable btn-sm" 
                               onclick="return confirm('¿Está seguro de que desea deshabilitar a esta persona?');">
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
