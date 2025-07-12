package Control;

import Modelo.IngresoAlmacenProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesIngresoAlmacenProducto {

    public static int registrarIngreso(IngresoAlmacenProducto ingreso) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO ingreso_almacen_producto (HORA, CANTIDAD, ENVASE, LOTE_ENVASE, PRESENTACION, LOTE_PRODUCTO, FECHA_VENCIMIENTO, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setTime(1, Time.valueOf(ingreso.getHORA()));
            ps.setInt(2, ingreso.getCANTIDAD());
            ps.setString(3, ingreso.getENVASE());
            ps.setString(4, ingreso.getLOTE_ENVASE());
            ps.setString(5, ingreso.getPRESENTACION());
            ps.setString(6, ingreso.getLOTE_PRODUCTO());
            ps.setDate(7, Date.valueOf(ingreso.getFECHA_VENCIMIENTO()));
            ps.setString(8, ingreso.getUSUCRE());
            ps.setTimestamp(9, Timestamp.valueOf(ingreso.getFECCRE()));
            ps.setString(10, ingreso.getPCCRE());
            ps.setString(11, String.valueOf(ingreso.getESTADO()));

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar ingreso a almacén");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static int actualizarIngreso(IngresoAlmacenProducto ingreso) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE ingreso_almacen_producto SET HORA=?, CANTIDAD=?, ENVASE=?, LOTE_ENVASE=?, PRESENTACION=?, LOTE_PRODUCTO=?, FECHA_VENCIMIENTO=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_INGRESO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setTime(1, Time.valueOf(ingreso.getHORA()));
            ps.setInt(2, ingreso.getCANTIDAD());
            ps.setString(3, ingreso.getENVASE());
            ps.setString(4, ingreso.getLOTE_ENVASE());
            ps.setString(5, ingreso.getPRESENTACION());
            ps.setString(6, ingreso.getLOTE_PRODUCTO());
            ps.setDate(7, Date.valueOf(ingreso.getFECHA_VENCIMIENTO()));
            ps.setString(8, ingreso.getUSUMOD());
            ps.setTimestamp(9, Timestamp.valueOf(ingreso.getFECMOD()));
            ps.setString(10, ingreso.getPCMOD());
            ps.setInt(11, ingreso.getID_INGRESO());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar ingreso a almacén");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static IngresoAlmacenProducto buscarPorId(int id) {
        IngresoAlmacenProducto ingreso = new IngresoAlmacenProducto();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM ingreso_almacen_producto WHERE ID_INGRESO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ingreso.setID_INGRESO(rs.getInt("ID_INGRESO"));
                ingreso.setHORA(rs.getTime("HORA").toLocalTime());
                ingreso.setCANTIDAD(rs.getInt("CANTIDAD"));
                ingreso.setENVASE(rs.getString("ENVASE"));
                ingreso.setLOTE_ENVASE(rs.getString("LOTE_ENVASE"));
                ingreso.setPRESENTACION(rs.getString("PRESENTACION"));
                ingreso.setLOTE_PRODUCTO(rs.getString("LOTE_PRODUCTO"));
                ingreso.setFECHA_VENCIMIENTO(rs.getDate("FECHA_VENCIMIENTO").toLocalDate());
                ingreso.setUSUCRE(rs.getString("USUCRE"));
                ingreso.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                ingreso.setPCCRE(rs.getString("PCCRE"));
                ingreso.setUSUMOD(rs.getString("USUMOD"));
                ingreso.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                ingreso.setPCMOD(rs.getString("PCMOD"));
                ingreso.setESTADO(rs.getString("ESTADO").charAt(0));
            }

            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar ingreso a almacén por ID");
            System.out.println(e.getMessage());
        }
        return ingreso;
    }

    public static List<IngresoAlmacenProducto> listarIngresos() {
        List<IngresoAlmacenProducto> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM ingreso_almacen_producto WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IngresoAlmacenProducto ingreso = new IngresoAlmacenProducto();
                ingreso.setID_INGRESO(rs.getInt("ID_INGRESO"));
                ingreso.setHORA(rs.getTime("HORA").toLocalTime());
                ingreso.setCANTIDAD(rs.getInt("CANTIDAD"));
                ingreso.setENVASE(rs.getString("ENVASE"));
                ingreso.setLOTE_ENVASE(rs.getString("LOTE_ENVASE"));
                ingreso.setPRESENTACION(rs.getString("PRESENTACION"));
                ingreso.setLOTE_PRODUCTO(rs.getString("LOTE_PRODUCTO"));
                ingreso.setFECHA_VENCIMIENTO(rs.getDate("FECHA_VENCIMIENTO").toLocalDate());
                lista.add(ingreso);
            }

            ps.close();
            cx.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al listar ingresos a almacén");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static int deshabilitarIngreso(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE ingreso_almacen_producto SET ESTADO = '0' WHERE ID_INGRESO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar ingreso a almacén");
            System.out.println(e.getMessage());
        }
        return status;
    }
}
