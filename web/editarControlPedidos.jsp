<%@ page import="Modelo.ControlPedidos" %>
<%@ page import="Control.AccionesControlPedidos" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Pedido</title>
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
    ControlPedidos p = AccionesControlPedidos.buscarPedidoByID(id);
    String ip = "";
    try {
        ip = InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<h1>Editar Pedido</h1>
<form method="post" action="actualizarControlPedidos">
    <table>
        <tr>
            <td>ID del Pedido</td>
            <td><input type="text" name="ID_PEDIDO2" value="<%= p.getID_PEDIDO() %>" readonly></td>
        </tr>
        <tr>
            <td>Pedido</td>
            <td><input type="text" name="Pedido2" value="<%= p.getPedido() %>" required></td>
        </tr>
        <tr>
            <td>Razón Social</td>
            <td><input type="text" name="Razon_social2" value="<%= p.getRazon_social() %>" required></td>
        </tr>
        <tr>
            <td>RUC</td>
            <td><input type="text" name="RUC2" value="<%= p.getRUC() %>" required></td>
        </tr>
        <tr>
            <td>Dirección</td>
            <td><input type="text" name="Direccion2" value="<%= p.getDireccion() %>"></td>
        </tr>
        <tr>
            <td>Referencia</td>
            <td><input type="text" name="Referencia2" value="<%= p.getReferencia() %>"></td>
        </tr>
        <tr>
            <td>Contacto</td>
            <td><input type="text" name="Contacto2" value="<%= p.getContacto() %>"></td>
        </tr>
        <tr>
            <td>Teléfono</td>
            <td><input type="text" name="Telefono2" value="<%= p.getTelefono() %>"></td>
        </tr>
        <tr>
            <td>Condición de Pago</td>
            <td><input type="text" name="Condicion_pago2" value="<%= p.getCondicion_pago() %>"></td>
        </tr>
        <tr>
            <td>Tipo Documento</td>
            <td>
                <select name="Tipo_documento2" required>
                    <option value="Factura" <%= "Factura".equals(p.getTipo_documento()) ? "selected" : "" %>>Factura</option>
                    <option value="Boleta" <%= "Boleta".equals(p.getTipo_documento()) ? "selected" : "" %>>Boleta</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Precio 3kg SF</td>
            <td><input type="number" step="0.01" name="Precio_3kg_SF2" value="<%= p.getPrecio_3kg_SF() %>"></td>
        </tr>
        <tr>
            <td>Precio C.C.</td>
            <td><input type="number" step="0.01" name="Precio_C_C2" value="<%= p.getPrecio_C_C() %>"></td>
        </tr>
        <tr>
            <td>Precio 1.5kg</td>
            <td><input type="number" step="0.01" name="Precio_1_5kg2" value="<%= p.getPrecio_1_5kg() %>"></td>
        </tr>
        <tr>
            <td>Cantidades (3kg / C.C. / 1.5kg)</td>
            <td>
                <input type="number" name="Cantidad_3kg2" value="<%= p.getCantidad_3kg() %>" placeholder="3kg"> /
                <input type="number" name="Cantidad_C_C2" value="<%= p.getCantidad_C_C() %>" placeholder="C.C."> /
                <input type="number" name="Cantidad_1_5kg2" value="<%= p.getCantidad_1_5kg() %>" placeholder="1.5kg">
            </td>
        </tr>
        <tr>
            <td>Cambios (3kg / C.C. / 1.5kg)</td>
            <td>
                <input type="number" name="Cambio_3kg2" value="<%= p.getCambio_3kg() %>" placeholder="3kg"> /
                <input type="number" name="Cambio_C_C2" value="<%= p.getCambio_C_C() %>" placeholder="C.C."> /
                <input type="number" name="Cambio_1_5kg2" value="<%= p.getCambio_1_5kg() %>" placeholder="1.5kg">
            </td>
        </tr>
        <tr>
            <td>Precio a Facturar</td>
            <td><input type="number" step="0.01" name="Precio_facturar2" value="<%= p.getPrecio_facturar() %>"></td>
        </tr>
        <tr>
            <td>Valor de Venta</td>
            <td><input type="number" step="0.01" name="Valor_venta2" value="<%= p.getValor_venta() %>"></td>
        </tr>
        <tr>
            <td>IGV 18%</td>
            <td><input type="number" step="0.01" name="IGV_182" value="<%= p.getIGV_18() %>"></td>
        </tr>

        <input type="hidden" name="USUMOD2" value="admin">
        <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
        <input type="hidden" name="PCMOD2" value="<%= ip %>">

        <tr>
            <td colspan="2" class="center"><input type="submit" value="Actualizar Pedido"></td>
        </tr>
    </table>
</form>

</body>
</html>
