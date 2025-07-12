package Servlet;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

@WebServlet("/ChartServlet")
public class DisplayChart extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chartType = request.getParameter("type");
        JFreeChart chart = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/superfresh", "root", "admin");
            Statement st = conn.createStatement();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            switch (chartType) {
                case "ingresos":
                    ResultSet rs1 = st.executeQuery("SELECT fecha, total_ingresado FROM vw_ingresos_diarios");
                    while (rs1.next())
                        dataset.addValue(rs1.getDouble("total_ingresado"), "Ingresos", rs1.getString("fecha"));
                    chart = ChartFactory.createLineChart("Ingresos por Día", "Fecha", "Cantidad", dataset);
                    break;

                case "facturacion":
                    ResultSet rs2 = st.executeQuery("SELECT fecha, total_facturado FROM vw_pedidos_agrupados");
                    while (rs2.next())
                        dataset.addValue(rs2.getDouble("total_facturado"), "Facturación", rs2.getString("fecha"));
                    chart = ChartFactory.createBarChart("Facturación Diaria", "Fecha", "S/.", dataset);
                    break;

                case "clientes":
                    ResultSet rs3 = st.executeQuery("SELECT mes, nuevos_clientes FROM vw_clientes_por_mes");
                    while (rs3.next())
                        dataset.addValue(rs3.getInt("nuevos_clientes"), "Clientes", rs3.getString("mes"));
                    chart = ChartFactory.createLineChart("Clientes Nuevos por Mes", "Mes", "Cantidad", dataset);
                    break;

                case "despachos":
                    ResultSet rs4 = st.executeQuery("SELECT Cliente, total_unidades FROM vw_despachos_por_cliente");
                    while (rs4.next())
                        dataset.addValue(rs4.getDouble("total_unidades"), "Unidades", rs4.getString("Cliente"));
                    chart = ChartFactory.createBarChart("Despachos por Cliente", "Cliente", "Unidades", dataset);
                    break;

                case "envases":
                    ResultSet rs5 = st.executeQuery("SELECT ENVASE, promedio_ingresado FROM vw_rendimiento_producto");
                    while (rs5.next())
                        dataset.addValue(rs5.getDouble("promedio_ingresado"), "Promedio", rs5.getString("ENVASE"));
                    chart = ChartFactory.createBarChart("Rendimiento por Envase", "Envase", "Promedio", dataset);
                    break;

                case "documentos":
                    ResultSet rs6 = st.executeQuery("SELECT Tipo_documento, total_facturado FROM vw_control_documentos");
                    while (rs6.next())
                        dataset.addValue(rs6.getDouble("total_facturado"), "Facturación", rs6.getString("Tipo_documento"));
                    chart = ChartFactory.createBarChart("Facturación por Tipo de Documento", "Tipo", "S/.", dataset);
                    break;

                default:
                    throw new IllegalArgumentException("Tipo de gráfico no válido");
            }

            if (chart != null) {
                estilizarGrafico(chart);
                response.setContentType("image/png");
                OutputStream out = response.getOutputStream();
                ChartUtils.writeChartAsPNG(out, chart, 650, 350);
                out.close();
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se pudo generar el gráfico.");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void estilizarGrafico(JFreeChart chart) {
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));
        chart.setAntiAlias(true);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(new Color(220, 220, 220));

        plot.getDomainAxis().setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
        plot.getRangeAxis().setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
        plot.getDomainAxis().setLabelFont(new Font("Segoe UI", Font.BOLD, 14));
        plot.getRangeAxis().setLabelFont(new Font("Segoe UI", Font.BOLD, 14));

        // Mostrar etiquetas de valor encima de cada punto/barra
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
        renderer.setDefaultItemLabelPaint(Color.BLACK);

        // Estilo visual del gráfico
        if (renderer instanceof LineAndShapeRenderer lineRenderer) {
            lineRenderer.setSeriesStroke(0, new BasicStroke(2.5f));
            lineRenderer.setSeriesPaint(0, new Color(72, 118, 255));    
            lineRenderer.setUseFillPaint(true);
            lineRenderer.setSeriesFillPaint(0, Color.WHITE);
        } else if (renderer instanceof BarRenderer barRenderer) {
            barRenderer.setDrawBarOutline(false);
            barRenderer.setBarPainter(new StandardBarPainter());
            barRenderer.setSeriesPaint(0, new GradientPaint(0f, 0f, new Color(255, 145, 145), 0f, 0f, new Color(255, 75, 75)));
            barRenderer.setItemMargin(0.1);
        }

        // Extiende el eje Y para evitar que las etiquetas se salgan
        if (plot.getRangeAxis() instanceof NumberAxis rangeAxis) {
            rangeAxis.setAutoRange(true);
            rangeAxis.setUpperMargin(0.20); // espacio adicional arriba
            rangeAxis.setLowerMargin(0.05); // opcional: espacio abajo
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        }
    }
}
