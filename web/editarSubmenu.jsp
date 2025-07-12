<%@ page import="Modelo.Menu" %>
<%@ page import="Modelo.Submenu" %>
<%@ page import="Control.AccionesSubmenu" %>
<%@ page import="Control.AccionesMenu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actualizar Submenú</title>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.9rem;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin: 30px 0 20px 0;
            color: #007bff;
            font-weight: bold;
            font-size: 1.6rem;
        }

        table {
            margin: 0 auto;
            width: 60%;
            border-collapse: collapse;
            background-color: #ffffff;
            border: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        td {
            padding: 12px;
            border: 1px solid #ddd;
        }

        input[type="text"],
        select {
            width: 98%;
            padding: 6px;
            font-size: 0.9rem;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            font-size: 0.9rem;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Submenu submenu = AccionesSubmenu.buscarSubmenuByID(id);
    List<Menu> menus = AccionesMenu.getAllMenus();
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Actualizar Submenú</h1>
<form method="post" action="actualizarSubmenu">
    <table>
        <tr>
            <td>ID del Submenú</td>
            <td><input type="text" name="ID_SUBMENU2" value="<%= submenu.getID_SUBMENU() %>" readonly></td>
        </tr>
        <tr>
            <td>Nombre del Submenú</td>
            <td><input type="text" name="NOMBRE_SUBMENU2" value="<%= submenu.getNOMBRE_SUBMENU() %>" required></td>
        </tr>
        <tr>
            <td>Nombre del Formulario</td>
            <td><input type="text" name="NOMBRE_FORMULARIO2" value="<%= submenu.getNOMBRE_FORMULARIO() %>" required></td>
        </tr>
        <tr>
            <td>Menú Principal</td>
            <td>
                <select name="ID_MENU2" required>
                    <% for (Menu m : menus) { %>
                        <option value="<%= m.getID_MENU() %>" <%= submenu.getID_MENU() == m.getID_MENU() ? "selected" : "" %> >
                            <%= m.getNOMBRE_MENU() %>
                        </option>
                    <% } %>
                </select>
            </td>
        </tr>
        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">
        <tr>
            <td colspan="2" style="text-align: center;">
                <input type="submit" value="Actualizar Submenú">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
