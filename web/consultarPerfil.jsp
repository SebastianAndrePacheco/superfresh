<%@page import="Modelo.Perfil"%>
<%@page import="Control.AccionesPerfil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Perfiles - SUPERFRESH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    
    <style>
        body {
            background-color: #f5f9fc;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        h1 {
            margin: 30px 0;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .table thead {
            background-color: #007bff;
            color: white;
        }
        .btn-action {
            font-size: 0.85rem;
            padding: 6px 12px;
        }
        .pdf-button-container {
            text-align: center;
            margin: 20px 0 40px;
        }
        .pdf-button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <script>
        function confirmAction(action, id) {
            const password = prompt("Por favor, ingrese la contraseña para " + action + ":", "");
            if (password === "admin") {
                if (action === "editar") {
                    window.location.href = "editarPerfil.jsp?id=" + id;
                } else if (action === "deshabilitar") {
                    window.location.href = "deshabilitarPerfil?id=" + id;
                }
            } else {
                alert("Contraseña incorrecta. Acción cancelada.");
            }
        }

        function exportToPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listado de Perfiles - SUPERFRESH", 14, 16);

            doc.autoTable({
                startY: 22,
                head: [['ID', 'Nombre del Perfil']],
                body: Array.from(document.querySelectorAll("tbody tr")).map(row => 
                    Array.from(row.querySelectorAll("td")).slice(0, 2).map(cell => cell.innerText)
                )
            });

            doc.save("listado_perfiles.pdf");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Listado de Perfiles</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover text-center align-middle">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre del Perfil</th>
                        <th>Editar</th>
                        <th>Deshabilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Perfil> lista = AccionesPerfil.getAllPerfiles();
                        for (Perfil p : lista) {
                    %>
                    <tr>
                        <td><%= p.getID_PERFIL() %></td>
                        <td><%= p.getNOMBRE_PERFIL() %></td>
                        <td>
                            <button class="btn btn-primary btn-action" onclick="confirmAction('editar', <%= p.getID_PERFIL() %>)">Editar</button>
                        </td>
                        <td>
                            <button class="btn btn-danger btn-action" onclick="confirmAction('deshabilitar', <%= p.getID_PERFIL() %>)">Deshabilitar</button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div class="pdf-button-container">
            <button class="btn btn-outline-primary pdf-button" onclick="exportToPDF()">Exportar a PDF</button>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
