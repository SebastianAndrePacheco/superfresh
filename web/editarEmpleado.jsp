<%@ page import="Modelo.Empleado" %>
<%@ page import="Modelo.Persona" %>
<%@ page import="Control.AccionesEmpleado" %>
<%@ page import="Control.AccionesPersona" %>
<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        h1 {
            text-align: center;
            margin: 30px 0;
            color: #007bff;
            font-weight: bold;
        }
        .form-container {
            width: 70%;
            margin: 0 auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 0px 8px rgba(0,0,0,0.1);
        }
        .form-group label {
            font-weight: 600;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Editar Empleado</h1>
    <div class="form-container">
        <form method="post" action="actualizarEmpleado">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Empleado emp = AccionesEmpleado.buscarEmpleadoByID(id);
                Persona persona = AccionesPersona.buscarPersonaByID(emp.getID_PERSONA());
                String ip = "";
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            <input type="hidden" name="ID_EMPLEADO2" value="<%= emp.getID_EMPLEADO() %>" />
            <input type="hidden" name="ID_PERSONA2" value="<%= persona.getID_PERSONA() %>" />

            <div class="mb-3">
                <label class="form-label">Nombre Completo</label>
                <input type="text" class="form-control" value="<%= persona.getNOMBRE() + ' ' + persona.getAPELLIDO_PATERNO() + ' ' + persona.getAPELLIDO_MATERNO() %>" disabled>
            </div>

            <div class="mb-3">
                <label class="form-label">Cargo</label>
                <input type="text" class="form-control" name="CARGO2" value="<%= emp.getCARGO() %>" required>
            </div>

            <!-- Auditoría -->
            <input type="hidden" name="USUMOD2" value="admin" />
            <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>" />
            <input type="hidden" name="PCMOD2" value="<%= ip %>" />

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary">Actualizar Empleado</button>
            </div>
        </form>
    </div>
</body>
</html>
