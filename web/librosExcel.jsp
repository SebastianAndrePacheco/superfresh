<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    String tabla = request.getParameter("tabla");
    String mes = request.getParameter("mes");

    // Tablas y su columna de fecha correspondiente
    Map<String, String> tablaFecha = new HashMap<>();
    tablaFecha.put("control_pedidos", "FECCRE");
    tablaFecha.put("resumen_clientes", "FECCRE");
    tablaFecha.put("control_despacho", "FECCRE");
    tablaFecha.put("ingreso_almacen_producto", "FECCRE");

    if (tabla != null) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + tabla + "_mes_" + mes + ".xls\"");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/superfresh", "root", "admin");

            String columnaFecha = tablaFecha.getOrDefault(tabla, "FECCRE");
            String sql = "SELECT * FROM " + tabla + " WHERE MONTH(" + columnaFecha + ") = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(mes));
            rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <table border="1">
        <tr>
            <% for (int i = 1; i <= colCount; i++) { %>
                <th><%= meta.getColumnName(i) %></th>
            <% } %>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <% for (int i = 1; i <= colCount; i++) { %>
                <td><%= rs.getString(i) %></td>
            <% } %>
        </tr>
        <% } %>
    </table>
</body>
</html>
<%
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Descargar Libros Excel</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f4faff;
            padding: 40px;
            text-align: center;
        }
        h1 { color: #064663; }
        .form-group {
            margin: 20px auto;
        }
        select, button {
            padding: 10px;
            margin: 8px;
            font-size: 16px;
        }
        button {
            background: #007ACC;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        button:hover {
            background: #005fa3;
        }
    </style>
</head>
<body>
    <h1>Descargar Registros por Mes (.xls)</h1>
    <form method="get">
        <div class="form-group">
            <label for="mes">Selecciona un mes:</label>
            <select name="mes" id="mes" required>
                <option value="">-- Mes --</option>
                <option value="1">Enero</option>
                <option value="2">Febrero</option>
                <option value="3">Marzo</option>
                <option value="4">Abril</option>
                <option value="5">Mayo</option>
                <option value="6">Junio</option>
                <option value="7">Julio</option>
                <option value="8">Agosto</option>
                <option value="9">Setiembre</option>
                <option value="10">Octubre</option>
                <option value="11">Noviembre</option>
                <option value="12">Diciembre</option>
            </select>
        </div>
        <div class="form-group">
            <button name="tabla" value="control_pedidos"> Control de Pedidos</button>
            <button name="tabla" value="resumen_clientes"> Resumen Clientes</button>
            <button name="tabla" value="control_despacho"> Control Despacho</button>
            <button name="tabla" value="ingreso_almacen_producto"> Ingreso Almacén</button>
        </div>
    </form>
</body>
</html>
