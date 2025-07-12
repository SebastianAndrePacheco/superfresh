<%@page import="Modelo.ResumenClientes"%>
<%@page import="Control.AccionesResumenClientes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Clientes - SUPERFRESH</title>
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
        .pdf-button {
            margin: 10px auto 30px auto;
            display: block;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 8px 16px;
            font-size: 0.9rem;
            border-radius: 4px;
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
                    window.location.href = "editarResumenClientes.jsp?id=" + id;
                } else if (action === "deshabilitar") {
                    window.location.href = "deshabilitarResumensCliente?id=" + id;
                }
            } else {
                alert("Contraseña incorrecta. Acción cancelada.");
            }
        }

        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listado de Clientes - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 20,
                head: [['ID', 'Razon Social', 'RUC', 'Dirección', 'Contacto', 'Teléfono', 'Condición']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row =>
                    Array.from(row.querySelectorAll("td")).slice(0,7).map(cell => cell.innerText)
                )
            });

            doc.save("listado_clientes.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Listado de Clientes</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Razon Social</th>
                        <th>RUC</th>
                        <th>Dirección</th>
                        <th>Contacto</th>
                        <th>Teléfono</th>
                        <th>Condición</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<ResumenClientes> lista = AccionesResumenClientes.getAllResumenClientes();
                        for(ResumenClientes cliente : lista){
                    %>
                    <tr>
                        <td><%= cliente.getID_CLIENTE() %></td>
                        <td><%= cliente.getRazon_social() %></td>
                        <td><%= cliente.getRUC() %></td>
                        <td><%= cliente.getDireccion() != null ? cliente.getDireccion() : "-" %></td>
                        <td><%= cliente.getContacto() != null ? cliente.getContacto() : "-" %></td>
                        <td><%= cliente.getTelefono() != null ? cliente.getTelefono() : "-" %></td>
                        <td><%= cliente.getCondicion() != null ? cliente.getCondicion() : "-" %></td>
                        <td>
                            <button class="btn btn-edit btn-sm" onclick="confirmAction('editar', <%= cliente.getID_CLIENTE() %>)">Editar</button>
                        </td>
                        <td>
                            <button class="btn btn-disable btn-sm" onclick="confirmAction('deshabilitar', <%= cliente.getID_CLIENTE() %>)">Deshabilitar</button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <button class="pdf-button" onclick="exportToPDF()">Exportar a PDF</button>
    </div>
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
