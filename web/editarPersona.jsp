<%@page import="Modelo.Persona"%>
<%@page import="Control.AccionesPersona"%>
<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Editar Persona - SUPERFRESH</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #e9f7fd;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 0.85rem;
        }
        h1 {
            text-align: center;
            margin: 30px 0;
            color: #007bff;
            font-weight: 700;
        }
        .form-container {
            width: 70%;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
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
    <h1>Editar Persona</h1>
    <div class="form-container">
        <form method="post" action="actualizarPersona">
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Persona persona = AccionesPersona.buscarPersonaByID(id);
                String ipv4Address = "";
                try {
                    InetAddress ip = InetAddress.getLocalHost();
                    ipv4Address = ip.getHostAddress();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            <input type="hidden" name="ID_PERSONA2" value="<%=persona.getID_PERSONA()%>">
            <div class="row mb-3">
                <div class="col">
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="NOMBRE2" value="<%=persona.getNOMBRE()%>" required>
                </div>
                <div class="col">
                    <label>Apellido Paterno</label>
                    <input type="text" class="form-control" name="APELLIDO_PATERNO2" value="<%=persona.getAPELLIDO_PATERNO()%>" required>
                </div>
                <div class="col">
                    <label>Apellido Materno</label>
                    <input type="text" class="form-control" name="APELLIDO_MATERNO2" value="<%=persona.getAPELLIDO_MATERNO()%>" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <label>DNI</label>
                    <input type="text" class="form-control" name="DNI2" value="<%=persona.getDNI()%>">
                </div>
                <div class="col">
                    <label>Carnet Extranjero</label>
                    <input type="text" class="form-control" name="CARNET_EXTRANJERO2" value="<%=persona.getCARNET_EXTRANJERO()%>">
                </div>
                <div class="col">
                    <label>Estado Civil</label>
                    <input type="text" class="form-control" name="ESTADO_CIVIL2" value="<%=persona.getESTADO_CIVIL()%>">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <label>Fecha de Nacimiento</label>
                    <input type="date" class="form-control" name="FECHA_NACIMIENTO2" value="<%=persona.getFECHA_NACIMIENTO()%>">
                </div>
                <div class="col">
                    <label>Distrito</label>
                    <input type="text" class="form-control" name="DISTRITO2" value="<%=persona.getDISTRITO()%>">
                </div>
                <div class="col">
                    <label>Dirección</label>
                    <input type="text" class="form-control" name="DIRECCION2" value="<%=persona.getDIRECCION()%>">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <label>Celular</label>
                    <input type="text" class="form-control" name="CELULAR2" value="<%=persona.getCELULAR()%>">
                </div>
                <div class="col">
                    <label>Email</label>
                    <input type="email" class="form-control" name="EMAIL2" value="<%=persona.getEMAIL()%>">
                </div>
            </div>

            <!-- Datos de modificación -->
            <input type="hidden" name="USUMOD2" value="admin">
            <input type="hidden" name="FECMOD2" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>">
            <input type="hidden" name="PCMOD2" value="<%= ipv4Address %>">

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Actualizar Persona</button>
            </div>
        </form>
    </div>
</body>
</html>
