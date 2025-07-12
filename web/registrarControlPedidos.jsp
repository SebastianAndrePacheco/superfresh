<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registrar Pedido - SUPERFRESH</title>
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
            max-width: 900px;
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
        <h1>Registrar Pedido</h1>
        <div class="form-container">
            <form method="post" action="guardarControlPedidos">
                <div class="row g-3">
                    <div class="col-md-4">
                        <label>Pedido</label>
                        <input type="text" name="Pedido" class="form-control" required />
                    </div>
                    <div class="col-md-8">
                        <label>Razón Social</label>
                        <input type="text" name="Razon_social" class="form-control" required />
                    </div>
                    <div class="col-md-4">
                        <label>RUC</label>
                        <input type="text" name="RUC" class="form-control" maxlength="11" required />
                    </div>
                    <div class="col-md-8">
                        <label>Dirección</label>
                        <input type="text" name="Direccion" class="form-control" />
                    </div>
                    <div class="col-md-6">
                        <label>Referencia</label>
                        <input type="text" name="Referencia" class="form-control" />
                    </div>
                    <div class="col-md-6">
                        <label>Contacto</label>
                        <input type="text" name="Contacto" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Teléfono</label>
                        <input type="text" name="Telefono" class="form-control" maxlength="9" />
                    </div>
                    <div class="col-md-4">
                        <label>Condición de Pago</label>
                        <input type="text" name="Condicion_pago" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Tipo de Documento</label>
                        <select name="Tipo_documento" class="form-select">
                            <option value="Factura">Factura</option>
                            <option value="Boleta">Boleta</option>
                        </select>
                    </div>

                    <!-- Precios -->
                    <div class="col-md-4">
                        <label>Precio 3kg SF</label>
                        <input type="number" step="0.01" name="Precio_3kg_SF" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Precio C.C</label>
                        <input type="number" step="0.01" name="Precio_C_C" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Precio 1.5kg</label>
                        <input type="number" step="0.01" name="Precio_1_5kg" class="form-control" />
                    </div>

                    <!-- Cantidades -->
                    <div class="col-md-4">
                        <label>Cantidad 3kg</label>
                        <input type="number" name="Cantidad_3kg" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Cantidad C.C</label>
                        <input type="number" name="Cantidad_C_C" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Cantidad 1.5kg</label>
                        <input type="number" name="Cantidad_1_5kg" class="form-control" />
                    </div>

                    <!-- Cambios -->
                    <div class="col-md-4">
                        <label>Cambio 3kg</label>
                        <input type="number" name="Cambio_3kg" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Cambio C.C</label>
                        <input type="number" name="Cambio_C_C" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Cambio 1.5kg</label>
                        <input type="number" name="Cambio_1_5kg" class="form-control" />
                    </div>

                    <!-- Totales -->
                    <div class="col-md-4">
                        <label>Precio a Facturar</label>
                        <input type="number" step="0.01" name="Precio_facturar" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>Valor Venta</label>
                        <input type="number" step="0.01" name="Valor_venta" class="form-control" />
                    </div>
                    <div class="col-md-4">
                        <label>IGV 18%</label>
                        <input type="number" step="0.01" name="IGV_18" class="form-control" />
                    </div>
                </div>

                <!-- Ocultos -->
                <input type="hidden" name="ESTADO" value="1" />
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

                <button type="submit" class="btn btn-primary btn-submit">Registrar Pedido</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
