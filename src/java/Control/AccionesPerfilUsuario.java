package Control;

import Modelo.PerfilUsuario;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesPerfilUsuario {

    public static int registrarPerfilUsuario(PerfilUsuario perfilUsuario) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO perfil_usuario (ID_PERFIL, ID_USUARIO, USUCRE, FECCRE, PCCRE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, perfilUsuario.getID_PERFIL());
            ps.setInt(2, perfilUsuario.getID_USUARIO());
            ps.setString(3, perfilUsuario.getUSUCRE());
            ps.setTimestamp(4, Timestamp.valueOf(perfilUsuario.getFECCRE()));
            ps.setString(5, perfilUsuario.getPCCRE());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar perfil_usuario: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarPerfilUsuario(PerfilUsuario perfilUsuario) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE perfil_usuario SET ID_PERFIL=?, ID_USUARIO=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_PERFIL_USUARIO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, perfilUsuario.getID_PERFIL());
            ps.setInt(2, perfilUsuario.getID_USUARIO());
            ps.setString(3, perfilUsuario.getUSUMOD());
            ps.setTimestamp(4, Timestamp.valueOf(perfilUsuario.getFECMOD()));
            ps.setString(5, perfilUsuario.getPCMOD());
            ps.setInt(6, perfilUsuario.getID_PERFIL_USUARIO());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar perfil_usuario: " + e.getMessage());
        }
        return status;
    }

    public static PerfilUsuario buscarPerfilUsuarioByID(int id) {
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM perfil_usuario WHERE ID_PERFIL_USUARIO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                perfilUsuario.setID_PERFIL_USUARIO(rs.getInt("ID_PERFIL_USUARIO"));
                perfilUsuario.setID_PERFIL(rs.getInt("ID_PERFIL"));
                perfilUsuario.setID_USUARIO(rs.getInt("ID_USUARIO"));
                perfilUsuario.setUSUCRE(rs.getString("USUCRE"));
                perfilUsuario.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                perfilUsuario.setPCCRE(rs.getString("PCCRE"));
                perfilUsuario.setUSUMOD(rs.getString("USUMOD"));
                perfilUsuario.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                perfilUsuario.setPCMOD(rs.getString("PCMOD"));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar perfil_usuario: " + e.getMessage());
        }
        return perfilUsuario;
    }

    public static List<PerfilUsuario> getAllPerfilUsuarios() {
    List<PerfilUsuario> lista = new ArrayList<>();
    Conexion cx = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = cx.conectar();
        String sql = "SELECT * FROM perfil_usuario";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            PerfilUsuario pu = new PerfilUsuario();
            pu.setID_PERFIL_USUARIO(rs.getInt("ID_PERFIL_USUARIO"));
            pu.setID_PERFIL(rs.getInt("ID_PERFIL"));
            pu.setID_USUARIO(rs.getInt("ID_USUARIO"));
            lista.add(pu);
        }
    } catch (Exception e) {
        System.out.println("Error al listar perfil_usuario: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close(); // Cierra correctamente aquí
        } catch (Exception e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return lista;
}


    public static int borrarPerfilUsuario(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "DELETE FROM perfil_usuario WHERE ID_PERFIL_USUARIO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar perfil_usuario: " + e.getMessage());
        }
        return status;
    }
}
