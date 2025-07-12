<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registro de Despachos - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.9rem;
        }
        h1 {
            margin: 30px 0 20px 0;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .form-label {
            font-weight: 600;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .container {
            max-width: 900px;
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

        String ipv4Address = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            ipv4Address = ip.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
    
    <div class="container mt-4 mb-5">
        <h1>Registro de Despacho</h1>
        <form method="post" action="guardarControlDespacho">
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Tipo</label>
                    <input type="text" class="form-control" name="Tipo" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="Fecha" required>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Cantidad</label>
                    <input type="number" class="form-control" name="Cantidad" min="0" required>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Envase</label>
                    <input type="text" class="form-control" name="Envase">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Lote de Envase</label>
                    <input type="text" class="form-control" name="Lote_envase">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Presentación</label>
                    <input type="text" class="form-control" name="Presentacion">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Lote de Producto</label>
                    <input type="text" class="form-control" name="Lote_producto">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Fecha de Vencimiento</label>
                    <input type="date" class="form-control" name="Fecha_vencimiento">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Cliente</label>
                    <input type="text" class="form-control" name="Cliente">
                </div>
                <div class="col-12">
                    <label class="form-label">Observaciones</label>
                    <textarea class="form-control" name="Observaciones" rows="3"></textarea>
                </div>

                <!-- Campos ocultos -->
                <input type="hidden" name="ESTADO" value="1" />
                <input type="hidden" name="USUCRE" value="<%= userId %>">
                <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
                <input type="hidden" name="PCCRE" value="<%= ipv4Address %>">

                <div class="col-12 text-center mt-3">
                    <button type="submit" class="btn btn-primary px-4">Registrar Despacho</button>
                </div>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
