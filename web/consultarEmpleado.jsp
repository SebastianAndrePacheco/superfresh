<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Control.AccionesEmpleado"%>
<%@page import="Control.AccionesPersona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Empleados - SUPERFRESH</title>
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
            text-align: right;
            margin-bottom: 10px;
        }
        .btn-pdf {
            background-color: #28a745;
            border: none;
            color: white;
            font-size: 0.9rem;
            padding: 6px 12px;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-pdf:hover {
            background-color: #218838;
        }
    </style>

    <!-- jsPDF and AutoTable -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <script>
        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listado de Empleados - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 22,
                head: [['Nombre Completo', 'Cargo']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row =>
                    Array.from(row.querySelectorAll("td")).slice(0, 2).map(cell => cell.innerText)
                ),
                styles: { fontSize: 8 }
            });

            doc.save("empleados.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Empleados Registrados</h1>

        <div class="pdf-button-container">
            <button class="btn-pdf" onclick="exportToPDF()">Exportar a PDF</button>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>Nombre Completo</th>
                        <th>Cargo</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Empleado> lista = AccionesEmpleado.getAllEmpleados();
                        for (Empleado emp : lista) {
                            Persona persona= AccionesPersona.buscarPersonaByID(emp.getID_PERSONA());
                    %>
                    <tr>
                        <td><%= persona.getNOMBRE() + " " + persona.getAPELLIDO_PATERNO() + " " + persona.getAPELLIDO_MATERNO() %></td>
                        <td><%= emp.getCARGO() %></td>
                        <td>
                            <a href="editarEmpleado.jsp?id=<%= emp.getID_EMPLEADO() %>" class="btn btn-edit btn-sm">Editar</a>
                        </td>
                        <td>
                            <a href="deshabilitarEmpleado?id=<%= emp.getID_EMPLEADO() %>" class="btn btn-disable btn-sm"
                               onclick="return confirm('¿Está seguro de que desea deshabilitar este empleado?');">
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
