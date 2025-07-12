<%@ page import="Modelo.IngresoAlmacenProducto" %>
<%@ page import="Control.AccionesIngresoAlmacenProducto" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Ingreso a Almacén</title>
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.9rem;
        }
        h1 {
            text-align: center;
            color: #007bff;
            margin: 30px 0;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        input[type="text"], input[type="number"], input[type="date"], input[type="time"] {
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
        .center {
            text-align: center;
        }
    </style>
</head>
<body>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    IngresoAlmacenProducto ingreso = AccionesIngresoAlmacenProducto.buscarPorId(id);
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Editar Ingreso a Almacén</h1>
<form method="post" action="actualizarIngresoAlmacenProducto">
    <table>
        <tr>
            <td>ID Ingreso</td>
            <td><input type="text" name="ID_INGRESO2" value="<%= ingreso.getID_INGRESO() %>" readonly></td>
        </tr>
        <tr>
            <td>Hora</td>
            <td><input type="time" name="HORA2" value="<%= ingreso.getHORA() %>"></td>
        </tr>
        <tr>
            <td>Cantidad</td>
            <td><input type="number" name="CANTIDAD2" value="<%= ingreso.getCANTIDAD() %>"></td>
        </tr>
        <tr>
            <td>Envase</td>
            <td><input type="text" name="ENVASE2" value="<%= ingreso.getENVASE() %>"></td>
        </tr>
        <tr>
            <td>Lote Envase</td>
            <td><input type="text" name="LOTE_ENVASE2" value="<%= ingreso.getLOTE_ENVASE() %>"></td>
        </tr>
        <tr>
            <td>Presentación</td>
            <td><input type="text" name="PRESENTACION2" value="<%= ingreso.getPRESENTACION() %>"></td>
        </tr>
        <tr>
            <td>Lote Producto</td>
            <td><input type="text" name="LOTE_PRODUCTO2" value="<%= ingreso.getLOTE_PRODUCTO() %>"></td>
        </tr>
        <tr>
            <td>Fecha Vencimiento</td>
            <td><input type="date" name="FECHA_VENCIMIENTO2" value="<%= ingreso.getFECHA_VENCIMIENTO() %>"></td>
        </tr>

        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">

        <tr>
            <td colspan="2" class="center">
                <input type="submit" value="Actualizar Ingreso">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
