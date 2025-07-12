<%@page import="java.net.InetAddress"%>
<%@page import="Control.AccionesPerfil"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Perfil - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            margin: 30px 0 20px;
            text-align: center;
            color: #007bff;
            font-weight: 700;
            font-size: 1.8rem;
        }
        .form-container {
            max-width: 500px;
            margin: 0 auto 40px;
            padding: 25px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
        }
        label {
            font-weight: 600;
        }
        .btn-submit {
            margin-top: 20px;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registrar Perfil</h1>
        <div class="form-container">
            <form method="post" action="guardarPerfil">
                <div class="mb-3">
                    <label for="NOMBRE_PERFIL" class="form-label">Nombre del Perfil</label>
                    <input type="text" class="form-control" id="NOMBRE_PERFIL" name="NOMBRE_PERFIL" required>
                </div>

                <!-- Datos ocultos -->
                <input type="hidden" name="ESTADO" value="1">
                <input type="hidden" name="USUCRE" value="<%= session.getAttribute("userId") %>">
                <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
                <%
                    String ipv4Address = "";
                    try {
                        ipv4Address = InetAddress.getLocalHost().getHostAddress();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <input type="hidden" name="PCCRE" value="<%= ipv4Address %>">

                <button type="submit" class="btn btn-primary btn-submit">Registrar Perfil</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
