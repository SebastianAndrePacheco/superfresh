<%@ page import="Modelo.ResumenClientes" %>
<%@ page import="Control.AccionesResumenClientes" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
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
        input[type="text"], input[type="number"], select {
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
    ResumenClientes c = AccionesResumenClientes.buscarResumenClienteByID(id);
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Editar Cliente</h1>
<form method="post" action="actualizarResumenClientes">
    <table>
        <tr>
            <td>ID Cliente</td>
            <td><input type="text" name="ID_CLIENTE2" value="<%= c.getID_CLIENTE() %>" readonly></td>
        </tr>
        <tr>
            <td>Número</td>
            <td><input type="number" name="Numero2" value="<%= c.getNumero() %>"></td>
        </tr>
        <tr>
            <td>Razón Social</td>
            <td><input type="text" name="Razon_social2" value="<%= c.getRazon_social() %>"></td>
        </tr>
        <tr>
            <td>RUC</td>
            <td><input type="text" name="RUC2" value="<%= c.getRUC() %>"></td>
        </tr>
        <tr>
            <td>Dirección</td>
            <td><input type="text" name="Direccion2" value="<%= c.getDireccion() %>"></td>
        </tr>
        <tr>
            <td>Referencia</td>
            <td><input type="text" name="Referencia2" value="<%= c.getReferencia() %>"></td>
        </tr>
        <tr>
            <td>Contacto</td>
            <td><input type="text" name="Contacto2" value="<%= c.getContacto() %>"></td>
        </tr>
        <tr>
            <td>Teléfono</td>
            <td><input type="text" name="Telefono2" value="<%= c.getTelefono() %>"></td>
        </tr>
        <tr>
            <td>Condición</td>
            <td><input type="text" name="Condicion2" value="<%= c.getCondicion() %>"></td>
        </tr>
        <tr>
            <td>Precio 3kg SF</td>
            <td><input type="number" step="0.01" name="Precio_3kg_SF2" value="<%= c.getPrecio_3kg_SF() %>"></td>
        </tr>
        <tr>
            <td>Precio C.C.</td>
            <td><input type="number" step="0.01" name="Precio_C_C2" value="<%= c.getPrecio_C_C() %>"></td>
        </tr>
        <tr>
            <td>Precio 1.5kg</td>
            <td><input type="number" step="0.01" name="Precio_1_5kg2" value="<%= c.getPrecio_1_5kg() %>"></td>
        </tr>

        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">

        <tr>
            <td colspan="2" class="center"><input type="submit" value="Actualizar Cliente"></td>
        </tr>
    </table>
</form>

</body>
</html>
