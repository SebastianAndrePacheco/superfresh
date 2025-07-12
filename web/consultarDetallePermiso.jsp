<%@page import="Modelo.DetallePermiso"%>
<%@page import="Control.AccionesDetallePermiso"%>
<%@page import="Control.AccionesPerfil"%>
<%@page import="Control.AccionesSubmenu"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.Submenu"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Detalle Permisos - SUPERFRESH</title>
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
                    window.location.href = "editarDetallePermiso.jsp?id=" + id;
                } else if (action === "deshabilitar") {
                    window.location.href = "deshabilitarDetallePermiso?id=" + id;
                }
            } else {
                alert("Contraseña incorrecta. Acción cancelada.");
            }
        }

        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listado de Detalle Permisos - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 22,
                head: [['ID', 'Perfil', 'Submenú', 'Acceso', 'Editar', 'Deshabilitar']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row =>
                    Array.from(row.querySelectorAll("td")).map(cell => cell.innerText)
                )
            });

            doc.save("listado_detalle_permisos.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Detalle Permisos Registrados</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Perfil</th>
                        <th>Submenú</th>
                        <th>Acceso</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<DetallePermiso> lista = AccionesDetallePermiso.getAllDetallePermisos();
                        for (DetallePermiso d : lista) {
                            Perfil perfil = AccionesPerfil.buscarPerfilByID(d.getID_PERFIL());
                            Submenu submenu = AccionesSubmenu.buscarSubmenuByID(d.getID_SUBMENU());
                    %>
                    <tr>
                        <td><%= d.getID_DETALLE_PERMISO() %></td>
                        <td><%= perfil != null ? perfil.getNOMBRE_PERFIL() : "N/A" %></td>
                        <td><%= submenu != null ? submenu.getNOMBRE_SUBMENU() : "N/A" %></td>
                        <td><%= d.getACCESO() %></td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-edit btn-sm"
                               onclick="confirmAction('editar', <%= d.getID_DETALLE_PERMISO() %>)">Editar</a>
                        </td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-disable btn-sm"
                               onclick="return confirm('¿Está seguro de que desea deshabilitar este detalle permiso?') ? confirmAction('deshabilitar', <%= d.getID_DETALLE_PERMISO() %>) : false;">
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
