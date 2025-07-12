package Control;

import Modelo.Empleado;
import Modelo.Persona;
import Control.Conexion;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesEmpleado {

    // Registrar un nuevo empleado
    public static int registrarEmpleado(Empleado empleado) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO empleado (ID_PERSONA, CARGO, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setInt(1, empleado.getID_PERSONA());
            ps.setString(2, empleado.getCARGO());
            ps.setString(3, empleado.getUSUCRE());
            ps.setTimestamp(4, Timestamp.valueOf(empleado.getFECCRE()));
            ps.setString(5, empleado.getPCCRE());
            ps.setString(6, String.valueOf(empleado.getESTADO()));

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar empleado: " + e.getMessage());
        }
        return status;
    }

    // Actualizar datos del empleado
    public static int actualizarEmpleado(Empleado empleado) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE empleado SET ID_PERSONA=?, CARGO=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_EMPLEADO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setInt(1, empleado.getID_PERSONA());
            ps.setString(2, empleado.getCARGO());
            ps.setString(3, empleado.getUSUMOD());
            ps.setTimestamp(4, Timestamp.valueOf(empleado.getFECMOD()));
            ps.setString(5, empleado.getPCMOD());
            ps.setInt(6, empleado.getID_EMPLEADO());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
        }
        return status;
    }

    // Buscar empleado por ID
    public static Empleado buscarEmpleadoByID(int id) {
        Empleado empleado = new Empleado();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM empleado WHERE ID_EMPLEADO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado.setID_EMPLEADO(rs.getInt("ID_EMPLEADO"));
                empleado.setID_PERSONA(rs.getInt("ID_PERSONA"));
                empleado.setCARGO(rs.getString("CARGO"));
                empleado.setUSUCRE(rs.getString("USUCRE"));
                empleado.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                empleado.setPCCRE(rs.getString("PCCRE"));
                empleado.setUSUMOD(rs.getString("USUMOD"));
                empleado.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                empleado.setPCMOD(rs.getString("PCMOD"));
                empleado.setESTADO(rs.getString("ESTADO").charAt(0));
            }

            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar empleado: " + e.getMessage());
        }
        return empleado;
    }

    // Obtener todos los empleados activos
    public static List<Empleado> getAllEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM empleado WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setID_EMPLEADO(rs.getInt("ID_EMPLEADO"));
                empleado.setID_PERSONA(rs.getInt("ID_PERSONA"));
                empleado.setCARGO(rs.getString("CARGO"));
                lista.add(empleado);
            }

            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return lista;
    }

    // Deshabilitar empleado
    public static int deshabilitarEmpleado(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE empleado SET ESTADO = '0' WHERE ID_EMPLEADO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar empleado: " + e.getMessage());
        }
        return status;
    }
}
