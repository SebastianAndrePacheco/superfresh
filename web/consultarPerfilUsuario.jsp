<%@page import="Modelo.PerfilUsuario"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Control.AccionesPerfilUsuario"%>
<%@page import="Control.AccionesPerfil"%>
<%@page import="Control.AccionesUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Perfiles por Usuario - SUPERFRESH</title>
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
            color: white;
        }
        .btn-edit:hover {
            background-color: #0b5ed7;
        }
        .btn-disable {
            background-color: #dc3545;
            border: none;
            font-size: 0.78rem;
            padding: 4px 8px;
            color: white;
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
        .pdf-button-container {
            text-align: center;
            margin: 20px 0;
        }
        .pdf-button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .pdf-button:hover {
            background-color: #0056b3;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <script>
        function confirmAction(action, id) {
            const password = prompt("Por favor, ingrese la contraseña para " + action + ":", "");
            if (password === "admin") {
                if (action === "editar") {
                    window.location.href = "editarPerfilUsuario.jsp?id=" + id;
                } else if (action === "deshabilitar") {
                    window.location.href = "deshabilitarPerfilUsuario?id=" + id;
                }
            } else {
                alert("Contraseña incorrecta. Acción cancelada.");
            }
        }

        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listado de Perfiles por Usuario - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 22,
                head: [['ID Perfil Usuario', 'Nombre Perfil', 'Usuario', 'Editar', 'Deshabilitar']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row =>
                    Array.from(row.querySelectorAll("td")).map(cell => cell.innerText)
                )
            });

            doc.save("listado_perfiles_usuarios.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Perfiles Asignados a Usuarios</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID Perfil Usuario</th>
                        <th>Nombre Perfil</th>
                        <th>Usuario (Login)</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<PerfilUsuario> lista = AccionesPerfilUsuario.getAllPerfilUsuarios();
                        for (PerfilUsuario pu : lista) {
                            Perfil perfil = AccionesPerfil.buscarPerfilByID(pu.getID_PERFIL());
                            Usuario usuario = AccionesUsuario.buscarUsuarioByID(pu.getID_USUARIO());
                    %>
                    <tr>
                        <td><%= pu.getID_PERFIL_USUARIO() %></td>
                        <td><%= perfil != null ? perfil.getNOMBRE_PERFIL(): "-" %></td>
                        <td><%= usuario != null ? usuario.getLOGEO() : "-" %></td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-edit btn-sm"
                               onclick="confirmAction('editar', <%= pu.getID_PERFIL_USUARIO() %>)">Editar</a>
                        </td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-disable btn-sm"
                               onclick="return confirm('¿Está seguro de que desea deshabilitar este perfil de usuario?') ? confirmAction('deshabilitar', <%= pu.getID_PERFIL_USUARIO() %>) : false;">
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
        <div class="pdf-button-container">
            <button class="pdf-button" onclick="exportToPDF()">Exportar a PDF</button>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
