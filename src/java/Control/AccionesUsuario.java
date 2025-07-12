package Control;

import Modelo.Usuario;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesUsuario {

    public static int registrarUsuario(Usuario usuario) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO usuario (ID_PERSONA, LOGEO, CLAVE, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, usuario.getID_PERSONA());
            ps.setString(2, usuario.getLOGEO());
            ps.setString(3, usuario.getCLAVE());
            ps.setString(4, usuario.getUSUCRE());
            ps.setTimestamp(5, Timestamp.valueOf(usuario.getFECCRE()));
            ps.setString(6, usuario.getPCCRE());
            ps.setString(7, String.valueOf(usuario.getESTADO()));
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarUsuario(Usuario usuario) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE usuario SET ID_PERSONA=?, LOGEO=?, CLAVE=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_USUARIO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, usuario.getID_PERSONA());
            ps.setString(2, usuario.getLOGEO());
            ps.setString(3, usuario.getCLAVE());
            ps.setString(4, usuario.getUSUMOD());
            ps.setTimestamp(5, Timestamp.valueOf(usuario.getFECMOD()));
            ps.setString(6, usuario.getPCMOD());
            ps.setInt(7, usuario.getID_USUARIO());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
        return status;
    }

    public static Usuario buscarUsuarioByID(int id) {
        Usuario usuario = new Usuario();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM usuario WHERE ID_USUARIO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setID_USUARIO(rs.getInt("ID_USUARIO"));
                usuario.setID_PERSONA(rs.getInt("ID_PERSONA"));
                usuario.setLOGEO(rs.getString("LOGEO"));
                usuario.setCLAVE(rs.getString("CLAVE"));
                usuario.setUSUCRE(rs.getString("USUCRE"));
                usuario.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                usuario.setPCCRE(rs.getString("PCCRE"));
                usuario.setUSUMOD(rs.getString("USUMOD"));
                usuario.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                usuario.setPCMOD(rs.getString("PCMOD"));
                usuario.setESTADO(rs.getString("ESTADO").charAt(0));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return usuario;
    }

    public static List<Usuario> getAllUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM usuario WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setID_USUARIO(rs.getInt("ID_USUARIO"));
                usuario.setID_PERSONA(rs.getInt("ID_PERSONA"));
                usuario.setLOGEO(rs.getString("LOGEO"));
                lista.add(usuario);
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public static int deshabilitarUsuario(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE usuario SET ESTADO = '0' WHERE ID_USUARIO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar usuario: " + e.getMessage());
        }
        return status;
    }
}
