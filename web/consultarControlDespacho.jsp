<%@page import="Modelo.ControlDespacho"%>
<%@page import="Control.AccionesControlDespacho"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Control de Despacho - SUPERFRESH</title>
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
        .pdf-button-container {
            text-align: center;
            margin: 20px;
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
                    window.location.href = "editarControlDespacho.jsp?id=" + id;
                } else if (action === "deshabilitar") {
                    window.location.href = "deshabilitarControlDespacho?id=" + id;
                }
            } else {
                alert("Contraseña incorrecta. Acción cancelada.");
            }
        }

        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Control de Despacho - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 20,
                head: [['ID', 'Tipo', 'Fecha', 'Cantidad', 'Envase', 'Lote Envase', 'Presentación', 'Lote Producto', 'Fecha Vencimiento', 'Cliente', 'Estado']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row => 
                    Array.from(row.querySelectorAll("td")).map(cell => cell.innerText)
                )
            });

            doc.save("control_despacho.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Control de Despacho</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>Cantidad</th>
                        <th>Envase</th>
                        <th>Lote Envase</th>
                        <th>Presentación</th>
                        <th>Lote Producto</th>
                        <th>Fecha Vencimiento</th>
                        <th>Cliente</th>
                        <th>Estado</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<ControlDespacho> lista = AccionesControlDespacho.listarControlDespachos();
                        for (ControlDespacho d : lista) {
                    %>
                    <tr>
                        <td><%= d.getID_DESPACHO() %></td>
                        <td><%= d.getTipo() != null ? d.getTipo() : "-" %></td>
                        <td><%= d.getFecha() != null ? d.getFecha() : "-" %></td>
                        <td><%= d.getCantidad() %></td>
                        <td><%= d.getEnvase() != null ? d.getEnvase() : "-" %></td>
                        <td><%= d.getLote_envase() != null ? d.getLote_envase() : "-" %></td>
                        <td><%= d.getPresentacion() != null ? d.getPresentacion() : "-" %></td>
                        <td><%= d.getLote_producto() != null ? d.getLote_producto() : "-" %></td>
                        <td><%= d.getFecha_vencimiento() != null ? d.getFecha_vencimiento() : "-" %></td>
                        <td><%= d.getCliente() != null ? d.getCliente() : "-" %></td>
                        <td><%= d.getEstado() %></td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-edit btn-sm" onclick="confirmAction('editar', <%= d.getID_DESPACHO() %>)">Editar</a>
                        </td>
                        <td>
                            <a href="javascript:void(0);" class="btn btn-disable btn-sm" onclick="confirmAction('deshabilitar', <%= d.getID_DESPACHO() %>)">Deshabilitar</a>
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
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
