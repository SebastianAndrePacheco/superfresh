<%@ page import="Modelo.Perfil" %>
<%@ page import="Modelo.Submenu" %>
<%@ page import="Modelo.DetallePermiso" %>
<%@ page import="Control.AccionesDetallePermiso" %>
<%@ page import="Control.AccionesPerfil" %>
<%@ page import="Control.AccionesSubmenu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actualizar Permiso</title>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.9rem;
        }

        h1 {
            text-align: center;
            margin: 30px 0;
            color: #007bff;
        }

        table {
            margin: 0 auto;
            width: 60%;
            border-collapse: collapse;
            background-color: #fff;
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
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    DetallePermiso permiso = AccionesDetallePermiso.buscarDetallePermisoByID(id);
    List<Perfil> perfiles = AccionesPerfil.getAllPerfiles();
    List<Submenu> submenus = AccionesSubmenu.getAllSubmenus();
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Actualizar Detalle de Permiso</h1>
<form method="post" action="actualizarDetallePermiso">
    <table>
        <tr>
            <td>ID del Permiso</td>
            <td><input type="text" name="ID_DETALLE_PERMISO2" value="<%= permiso.getID_DETALLE_PERMISO() %>" readonly></td>
        </tr>
        <tr>
            <td>Perfil</td>
            <td>
                <select name="ID_PERFIL2" required>
                    <% for (Perfil p : perfiles) { %>
                        <option value="<%= p.getID_PERFIL() %>" <%= permiso.getID_PERFIL() == p.getID_PERFIL() ? "selected" : "" %>>
                            <%= p.getNOMBRE_PERFIL() %>
                        </option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Submenú</td>
            <td>
                <select name="ID_SUBMENU2" required>
                    <% for (Submenu sm : submenus) { %>
                        <option value="<%= sm.getID_SUBMENU() %>" <%= permiso.getID_SUBMENU() == sm.getID_SUBMENU() ? "selected" : "" %>>
                            <%= sm.getNOMBRE_SUBMENU() %>
                        </option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Acceso</td>
            <td>
                <select name="ACCESO2" required>
                    <option value="1" <%= permiso.getACCESO() == '1' ? "selected" : "" %>>Permitido</option>
                    <option value="0" <%= permiso.getACCESO() == '0' ? "selected" : "" %>>Denegado</option>
                </select>
            </td>
        </tr>

        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">

        <tr>
            <td colspan="2" style="text-align:center">
                <input type="submit" value="Actualizar Permiso">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
