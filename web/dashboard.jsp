<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard Estadístico</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f1f7ff;
        }

        .dashboard-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 30px 20px;
        }

        h1 {
            text-align: center;
            color: #003366;
            font-size: 28px;
            margin-bottom: 40px;
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(500px, 1fr));
            gap: 30px;
        }

        .chart-box {
            background: #ffffff;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.2s ease;
        }

        .chart-box:hover {
            transform: scale(1.02);
        }

        .chart-box img {
            width: 100%;
            height: auto;
            border-radius: 8px;
            object-fit: contain;
        }

        @media (max-width: 550px) {
            .chart-box {
                padding: 10px;
            }

            h1 {
                font-size: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>Dashboard Estadístico - SUPERFRESH</h1>
        <div class="grid">
            <div class="chart-box">
                <img src="DisplayChart?type=ingresos" alt="Ingresos por Día">
            </div>
            <div class="chart-box">
                <img src="DisplayChart?type=facturacion" alt="Facturación Diaria">
            </div>
            <div class="chart-box">
                <img src="DisplayChart?type=clientes" alt="Clientes Nuevos por Mes">
            </div>
            <div class="chart-box">
                <img src="DisplayChart?type=despachos" alt="Despachos por Cliente">
            </div>
            <div class="chart-box">
                <img src="DisplayChart?type=envases" alt="Rendimiento por Envase">
            </div>
            <div class="chart-box">
                <img src="DisplayChart?type=documentos" alt="Facturación por Documento">
            </div>
        </div>
    </div>
</body>
</html>
