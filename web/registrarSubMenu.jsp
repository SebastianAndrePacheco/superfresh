<%@page import="Control.AccionesMenu"%>
<%@page import="Modelo.Menu"%>
<%@page import="Control.AccionesSubmenu"%>
<%@page import="java.util.List"%>
<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Submenú - SUPERFRESH</title>
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
        <h1>Registrar Submenú</h1>
        <div class="form-container">
            <form method="post" action="guardarSubmenu">
                <div class="mb-3">
                    <label for="ID_MENU" class="form-label">Menú Principal</label>
                    <select name="ID_MENU" id="ID_MENU" class="form-select" required>
                        <%
                            List<Menu> menus = AccionesMenu.getAllMenus();
                            for (Menu m : menus) {
                        %>
                        <option value="<%= m.getID_MENU() %>"><%= m.getNOMBRE_MENU() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="NOMBRE_SUBMENU" class="form-label">Nombre del Submenú</label>
                    <input type="text" name="NOMBRE_SUBMENU" id="NOMBRE_SUBMENU" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label for="NOMBRE_FORMULARIO" class="form-label">Nombre del Formulario</label>
                    <input type="text" name="NOMBRE_FORMULARIO" id="NOMBRE_FORMULARIO" class="form-control" required />
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

                <button type="submit" class="btn btn-primary btn-submit">Registrar Submenú</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
