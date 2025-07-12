<%@ page import="Modelo.ControlDespacho" %>
<%@ page import="Control.AccionesControlDespacho" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Control de Despacho</title>
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
        input[type="text"], input[type="number"], input[type="date"], textarea {
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
    ControlDespacho despacho = AccionesControlDespacho.buscarPorId(id);
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Editar Control de Despacho</h1>
<form method="post" action="actualizarControlDespacho">
    <table>
        <tr>
            <td>ID Despacho</td>
            <td><input type="text" name="ID_DESPACHO2" value="<%= despacho.getID_DESPACHO() %>" readonly></td>
        </tr>
        <tr>
            <td>Tipo</td>
            <td><input type="text" name="Tipo2" value="<%= despacho.getTipo() %>"></td>
        </tr>
        <tr>
            <td>Fecha</td>
            <td><input type="date" name="Fecha2" value="<%= despacho.getFecha() %>"></td>
        </tr>
        <tr>
            <td>Cantidad</td>
            <td><input type="number" name="Cantidad2" value="<%= despacho.getCantidad() %>"></td>
        </tr>
        <tr>
            <td>Envase</td>
            <td><input type="text" name="Envase2" value="<%= despacho.getEnvase() %>"></td>
        </tr>
        <tr>
            <td>Lote de Envase</td>
            <td><input type="text" name="Lote_envase2" value="<%= despacho.getLote_envase() %>"></td>
        </tr>
        <tr>
            <td>Presentación</td>
            <td><input type="text" name="Presentacion2" value="<%= despacho.getPresentacion() %>"></td>
        </tr>
        <tr>
            <td>Lote Producto</td>
            <td><input type="text" name="Lote_producto2" value="<%= despacho.getLote_producto() %>"></td>
        </tr>
        <tr>
            <td>Fecha de Vencimiento</td>
            <td><input type="date" name="Fecha_vencimiento2" value="<%= despacho.getFecha_vencimiento() %>"></td>
        </tr>
        <tr>
            <td>Cliente</td>
            <td><input type="text" name="Cliente2" value="<%= despacho.getCliente() %>"></td>
        </tr>
        <tr>
            <td>Observaciones</td>
            <td><textarea name="Observaciones2"><%= despacho.getObservaciones() %></textarea></td>
        </tr>

        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">

        <tr>
            <td colspan="2" class="center"><input type="submit" value="Actualizar Despacho"></td>
        </tr>
    </table>
</form>

</body>
</html>
