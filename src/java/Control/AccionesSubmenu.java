package Control;

import Modelo.Submenu;
import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesSubmenu {

    public static int registrarSubmenu(Submenu submenu) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO submenu (ID_MENU, NOMBRE_SUBMENU, NOMBRE_FORMULARIO, USUCRE, FECCRE, PCCRE) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, submenu.getID_MENU());
            ps.setString(2, submenu.getNOMBRE_SUBMENU());
            ps.setString(3, submenu.getNOMBRE_FORMULARIO());
            ps.setString(4, submenu.getUSUCRE());
            ps.setTimestamp(5, Timestamp.valueOf(submenu.getFECCRE()));
            ps.setString(6, submenu.getPCCRE());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar submenu: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarSubmenu(Submenu submenu) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE submenu SET ID_MENU=?, NOMBRE_SUBMENU=?, NOMBRE_FORMULARIO=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_SUBMENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, submenu.getID_MENU());
            ps.setString(2, submenu.getNOMBRE_SUBMENU());
            ps.setString(3, submenu.getNOMBRE_FORMULARIO());
            ps.setString(4, submenu.getUSUMOD());
            ps.setTimestamp(5, Timestamp.valueOf(submenu.getFECMOD()));
            ps.setString(6, submenu.getPCMOD());
            ps.setInt(7, submenu.getID_SUBMENU());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar submenu: " + e.getMessage());
        }
        return status;
    }

    public static Submenu buscarSubmenuByID(int id) {
        Submenu submenu = new Submenu();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM submenu WHERE ID_SUBMENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                submenu.setID_SUBMENU(rs.getInt("ID_SUBMENU"));
                submenu.setID_MENU(rs.getInt("ID_MENU"));
                submenu.setNOMBRE_SUBMENU(rs.getString("NOMBRE_SUBMENU"));
                submenu.setNOMBRE_FORMULARIO(rs.getString("NOMBRE_FORMULARIO"));
                submenu.setUSUCRE(rs.getString("USUCRE"));
                submenu.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                submenu.setPCCRE(rs.getString("PCCRE"));
                submenu.setUSUMOD(rs.getString("USUMOD"));
                submenu.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                submenu.setPCMOD(rs.getString("PCMOD"));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar submenu: " + e.getMessage());
        }
        return submenu;
    }

    public static List<Submenu> getAllSubmenus() {
        List<Submenu> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM submenu";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Submenu s = new Submenu();
                s.setID_SUBMENU(rs.getInt("ID_SUBMENU"));
                s.setID_MENU(rs.getInt("ID_MENU"));
                s.setNOMBRE_SUBMENU(rs.getString("NOMBRE_SUBMENU"));
                s.setNOMBRE_FORMULARIO(rs.getString("NOMBRE_FORMULARIO"));
                lista.add(s);
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar submenus: " + e.getMessage());
        }
        return lista;
    }

    public static int borrarSubmenu(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "DELETE FROM submenu WHERE ID_SUBMENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar submenu: " + e.getMessage());
        }
        return status;
    }
}
