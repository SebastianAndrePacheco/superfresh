package Control;

import Modelo.DetallePermiso;
import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesDetallePermiso {

    public static int registrarDetallePermiso(DetallePermiso permiso) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO detalle_permiso (ID_PERFIL, ID_SUBMENU, ACCESO, USUCRE, FECCRE, PCCRE) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, permiso.getID_PERFIL());
            ps.setInt(2, permiso.getID_SUBMENU());
            ps.setString(3, String.valueOf(permiso.getACCESO()));
            ps.setString(4, permiso.getUSUCRE());
            ps.setTimestamp(5, Timestamp.valueOf(permiso.getFECCRE()));
            ps.setString(6, permiso.getPCCRE());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar detalle permiso: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarDetallePermiso(DetallePermiso permiso) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE detalle_permiso SET ID_PERFIL=?, ID_SUBMENU=?, ACCESO=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_DETALLE_PERMISO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, permiso.getID_PERFIL());
            ps.setInt(2, permiso.getID_SUBMENU());
            ps.setString(3, String.valueOf(permiso.getACCESO()));
            ps.setString(4, permiso.getUSUMOD());
            ps.setTimestamp(5, Timestamp.valueOf(permiso.getFECMOD()));
            ps.setString(6, permiso.getPCMOD());
            ps.setInt(7, permiso.getID_DETALLE_PERMISO());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle permiso: " + e.getMessage());
        }
        return status;
    }

    public static DetallePermiso buscarDetallePermisoByID(int id) {
        DetallePermiso permiso = new DetallePermiso();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM detalle_permiso WHERE ID_DETALLE_PERMISO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                permiso.setID_DETALLE_PERMISO(rs.getInt("ID_DETALLE_PERMISO"));
                permiso.setID_PERFIL(rs.getInt("ID_PERFIL"));
                permiso.setID_SUBMENU(rs.getInt("ID_SUBMENU"));
                permiso.setACCESO(rs.getString("ACCESO").charAt(0));
                permiso.setUSUCRE(rs.getString("USUCRE"));
                permiso.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                permiso.setPCCRE(rs.getString("PCCRE"));
                permiso.setUSUMOD(rs.getString("USUMOD"));
                permiso.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                permiso.setPCMOD(rs.getString("PCMOD"));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar detalle permiso: " + e.getMessage());
        }
        return permiso;
    }

    public static List<DetallePermiso> getAllDetallePermisos() {
        List<DetallePermiso> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM detalle_permiso";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePermiso permiso = new DetallePermiso();
                permiso.setID_DETALLE_PERMISO(rs.getInt("ID_DETALLE_PERMISO"));
                permiso.setID_PERFIL(rs.getInt("ID_PERFIL"));
                permiso.setID_SUBMENU(rs.getInt("ID_SUBMENU"));
                permiso.setACCESO(rs.getString("ACCESO").charAt(0));
                lista.add(permiso);
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar detalle permisos: " + e.getMessage());
        }
        return lista;
    }

    public static int borrarDetallePermiso(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "DELETE FROM detalle_permiso WHERE ID_DETALLE_PERMISO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar detalle permiso: " + e.getMessage());
        }
        return status;
    }
}
