package Control;

import Modelo.Menu;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesMenu {

    public static int registrarMenu(Menu menu) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO menu (NOMBRE_MENU, USUCRE, FECCRE, PCCRE) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, menu.getNOMBRE_MENU());
            ps.setString(2, menu.getUSUCRE());
            ps.setTimestamp(3, Timestamp.valueOf(menu.getFECCRE()));
            ps.setString(4, menu.getPCCRE());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar menú: " + e.getMessage());
        }
        return status;
    }

    public static int actualizarMenu(Menu menu) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE menu SET NOMBRE_MENU=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_MENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, menu.getNOMBRE_MENU());
            ps.setString(2, menu.getUSUMOD());
            ps.setTimestamp(3, Timestamp.valueOf(menu.getFECMOD()));
            ps.setString(4, menu.getPCMOD());
            ps.setInt(5, menu.getID_MENU());
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar menú: " + e.getMessage());
        }
        return status;
    }

    public static Menu buscarMenuByID(int id) {
        Menu menu = new Menu();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM menu WHERE ID_MENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menu.setID_MENU(rs.getInt("ID_MENU"));
                menu.setNOMBRE_MENU(rs.getString("NOMBRE_MENU"));
                menu.setUSUCRE(rs.getString("USUCRE"));
                menu.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                menu.setPCCRE(rs.getString("PCCRE"));
                menu.setUSUMOD(rs.getString("USUMOD"));
                menu.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                menu.setPCMOD(rs.getString("PCMOD"));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar menú: " + e.getMessage());
        }
        return menu;
    }

    public static List<Menu> getAllMenus() {
        List<Menu> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM menu";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu m = new Menu();
                m.setID_MENU(rs.getInt("ID_MENU"));
                m.setNOMBRE_MENU(rs.getString("NOMBRE_MENU"));
                lista.add(m);
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar menús: " + e.getMessage());
        }
        return lista;
    }

    public static int borrarMenu(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "DELETE FROM menu WHERE ID_MENU=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar menú: " + e.getMessage());
        }
        return status;
    }
}
