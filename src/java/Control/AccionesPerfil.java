package Control;

import Modelo.Perfil;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesPerfil {

    public static int registrarPerfil(Perfil perfil) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO perfil (NOMBRE_PERFIL, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, perfil.getNOMBRE_PERFIL());
            ps.setString(2, perfil.getUSUCRE());
            ps.setTimestamp(3, Timestamp.valueOf(perfil.getFECCRE()));
            ps.setString(4, perfil.getPCCRE());
            ps.setString(5, String.valueOf(perfil.getESTADO()));
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar perfil: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarPerfil(Perfil perfil) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE perfil SET NOMBRE_PERFIL=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_PERFIL=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, perfil.getNOMBRE_PERFIL());
            ps.setString(2, perfil.getUSUMOD());
            ps.setTimestamp(3, Timestamp.valueOf(perfil.getFECMOD()));
            ps.setString(4, perfil.getPCMOD());
            ps.setInt(5, perfil.getID_PERFIL());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar perfil: " + e.getMessage());
        }
        return status;
    }

    public static Perfil buscarPerfilByID(int id) {
        Perfil perfil = new Perfil();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM perfil WHERE ID_PERFIL = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                perfil.setID_PERFIL(rs.getInt("ID_PERFIL"));
                perfil.setNOMBRE_PERFIL(rs.getString("NOMBRE_PERFIL"));
                perfil.setUSUCRE(rs.getString("USUCRE"));
                perfil.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                perfil.setPCCRE(rs.getString("PCCRE"));
                perfil.setUSUMOD(rs.getString("USUMOD"));
                perfil.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                perfil.setPCMOD(rs.getString("PCMOD"));
                perfil.setESTADO(rs.getString("ESTADO").charAt(0));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar perfil: " + e.getMessage());
        }
        return perfil;
    }

    public static List<Perfil> getAllPerfiles() {
        List<Perfil> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM perfil WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Perfil perfil = new Perfil();
                perfil.setID_PERFIL(rs.getInt("ID_PERFIL"));
                perfil.setNOMBRE_PERFIL(rs.getString("NOMBRE_PERFIL"));
                lista.add(perfil);
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar perfiles: " + e.getMessage());
        }
        return lista;
    }

    public static int deshabilitarPerfil(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE perfil SET ESTADO = '0' WHERE ID_PERFIL = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar perfil: " + e.getMessage());
        }
        return status;
    }
}
