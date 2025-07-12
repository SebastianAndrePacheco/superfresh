package Control;

import Modelo.ControlDespacho;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesControlDespacho {

    public static int registrarControlDespacho(ControlDespacho despacho) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO control_despacho (Tipo, Fecha, Cantidad, Envase, Lote_envase, Presentacion, Lote_producto, Fecha_vencimiento, Cliente, Observaciones, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, despacho.getTipo());
            ps.setDate(2, Date.valueOf(despacho.getFecha()));
            ps.setInt(3, despacho.getCantidad());
            ps.setString(4, despacho.getEnvase());
            ps.setString(5, despacho.getLote_envase());
            ps.setString(6, despacho.getPresentacion());
            ps.setString(7, despacho.getLote_producto());
            ps.setDate(8, Date.valueOf(despacho.getFecha_vencimiento()));
            ps.setString(9, despacho.getCliente());
            ps.setString(10, despacho.getObservaciones());
            ps.setString(11, despacho.getUSUCRE());
            ps.setTimestamp(12, Timestamp.valueOf(despacho.getFECCRE()));
            ps.setString(13, despacho.getPCCRE());
            ps.setString(14, String.valueOf(despacho.getEstado()));

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar control de despacho");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static int actualizarControlDespacho(ControlDespacho despacho) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE control_despacho SET Tipo=?, Fecha=?, Cantidad=?, Envase=?, Lote_envase=?, Presentacion=?, Lote_producto=?, Fecha_vencimiento=?, Cliente=?, Observaciones=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_DESPACHO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, despacho.getTipo());
            ps.setDate(2, Date.valueOf(despacho.getFecha()));
            ps.setInt(3, despacho.getCantidad());
            ps.setString(4, despacho.getEnvase());
            ps.setString(5, despacho.getLote_envase());
            ps.setString(6, despacho.getPresentacion());
            ps.setString(7, despacho.getLote_producto());
            ps.setDate(8, Date.valueOf(despacho.getFecha_vencimiento()));
            ps.setString(9, despacho.getCliente());
            ps.setString(10, despacho.getObservaciones());
            ps.setString(11, despacho.getUSUMOD());
            ps.setTimestamp(12, Timestamp.valueOf(despacho.getFECMOD()));
            ps.setString(13, despacho.getPCMOD());
            ps.setInt(14, despacho.getID_DESPACHO());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar control de despacho");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static ControlDespacho buscarPorId(int id) {
        ControlDespacho despacho = new ControlDespacho();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM control_despacho WHERE ID_DESPACHO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                despacho.setID_DESPACHO(rs.getInt("ID_DESPACHO"));
                despacho.setTipo(rs.getString("Tipo"));
                despacho.setFecha(rs.getDate("Fecha").toLocalDate());
                despacho.setCantidad(rs.getInt("Cantidad"));
                despacho.setEnvase(rs.getString("Envase"));
                despacho.setLote_envase(rs.getString("Lote_envase"));
                despacho.setPresentacion(rs.getString("Presentacion"));
                despacho.setLote_producto(rs.getString("Lote_producto"));
                despacho.setFecha_vencimiento(rs.getDate("Fecha_vencimiento").toLocalDate());
                despacho.setCliente(rs.getString("Cliente"));
                despacho.setObservaciones(rs.getString("Observaciones"));
                despacho.setUSUCRE(rs.getString("USUCRE"));
                despacho.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                despacho.setPCCRE(rs.getString("PCCRE"));
                despacho.setUSUMOD(rs.getString("USUMOD"));
                despacho.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                despacho.setPCMOD(rs.getString("PCMOD"));
                despacho.setEstado(rs.getString("Estado").charAt(0));
            }

            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar control de despacho por ID");
            System.out.println(e.getMessage());
        }
        return despacho;
    }

    public static List<ControlDespacho> listarControlDespachos() {
        List<ControlDespacho> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM control_despacho WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ControlDespacho despacho = new ControlDespacho();
                despacho.setID_DESPACHO(rs.getInt("ID_DESPACHO"));
                despacho.setTipo(rs.getString("Tipo"));
                despacho.setFecha(rs.getDate("Fecha").toLocalDate());
                despacho.setCantidad(rs.getInt("Cantidad"));
                despacho.setEnvase(rs.getString("Envase"));
                despacho.setLote_envase(rs.getString("Lote_envase"));
                despacho.setPresentacion(rs.getString("Presentacion"));
                despacho.setLote_producto(rs.getString("Lote_producto"));
                despacho.setFecha_vencimiento(rs.getDate("Fecha_vencimiento").toLocalDate());
                despacho.setCliente(rs.getString("Cliente"));
                despacho.setObservaciones(rs.getString("Observaciones"));
                lista.add(despacho);
            }

            ps.close();
            cx.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al listar los controles de despacho");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static int deshabilitarControlDespacho(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE control_despacho SET ESTADO = '0' WHERE ID_DESPACHO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar el control de despacho");
            System.out.println(e.getMessage());
        }
        return status;
    }
}