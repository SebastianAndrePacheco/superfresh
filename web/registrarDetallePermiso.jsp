<%@page import="Control.AccionesPerfil"%>
<%@page import="Control.AccionesSubmenu"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.Submenu"%>
<%@page import="Control.AccionesDetallePermiso"%>
<%@page import="java.util.List"%>
<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Detalle de Permiso - SUPERFRESH</title>
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
            max-width: 700px;
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
        <h1>Registrar Detalle de Permiso</h1>
        <div class="form-container">
            <form method="post" action="guardarDetallePermiso">
                <div class="mb-3">
                    <label for="ID_PERFIL" class="form-label">Perfil</label>
                    <select name="ID_PERFIL" id="ID_PERFIL" class="form-select" required>
                        <%
                            List<Perfil> perfiles = AccionesPerfil.getAllPerfiles();
                            for (Perfil p : perfiles) {
                        %>
                        <option value="<%= p.getID_PERFIL() %>"><%= p.getNOMBRE_PERFIL() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="ID_SUBMENU" class="form-label">Submenú</label>
                    <select name="ID_SUBMENU" id="ID_SUBMENU" class="form-select" required>
                        <%
                            List<Submenu> submenus = AccionesSubmenu.getAllSubmenus();
                            for (Submenu sm : submenus) {
                        %>
                        <option value="<%= sm.getID_SUBMENU() %>"><%= sm.getNOMBRE_SUBMENU() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="ACCESO" class="form-label">Acceso</label>
                    <select name="ACCESO" id="ACCESO" class="form-select" required>
                        <option value="1">Permitido</option>
                        <option value="0">Denegado</option>
                    </select>
                </div>

                <!-- Campos ocultos -->
                <input type="hidden" name="USUCRE" value="<%= session.getAttribute("userId") %>">
                <input type="hidden" name="FECCRE" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
                <%
                    String ip = "";
                    try {
                        ip = InetAddress.getLocalHost().getHostAddress();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <input type="hidden" name="PCCRE" value="<%= ip %>">

                <button type="submit" class="btn btn-primary btn-submit">Registrar Permiso</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
