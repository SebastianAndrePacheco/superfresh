package Control;

import Modelo.Persona;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesPersona {

    // Registrar Persona
    public static int registrarPersona(Persona persona) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO persona (DISTRITO, APELLIDO_PATERNO, APELLIDO_MATERNO, NOMBRE, DNI, CARNET_EXTRANJERO, ESTADO_CIVIL, FECHA_NACIMIENTO, DIRECCION, CELULAR, EMAIL, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setString(1, persona.getDISTRITO());
            ps.setString(2, persona.getAPELLIDO_PATERNO());
            ps.setString(3, persona.getAPELLIDO_MATERNO());
            ps.setString(4, persona.getNOMBRE());
            ps.setString(5, persona.getDNI());
            ps.setString(6, persona.getCARNET_EXTRANJERO());
            ps.setString(7, persona.getESTADO_CIVIL());
            ps.setDate(8, Date.valueOf(persona.getFECHA_NACIMIENTO()));
            ps.setString(9, persona.getDIRECCION());
            ps.setString(10, persona.getCELULAR());
            ps.setString(11, persona.getEMAIL());
            ps.setString(12, persona.getUSUCRE());
            ps.setTimestamp(13, Timestamp.valueOf(persona.getFECCRE()));
            ps.setString(14, persona.getPCCRE());
            ps.setString(15, String.valueOf(persona.getEstado()));

            status = ps.executeUpdate();
            System.out.println("Persona registrada exitosamente");
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar la persona: " + e.getMessage());
        }
        return status;
    }

    // Actualizar Persona
    public static int actualizarPersona(Persona persona) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE persona SET DISTRITO=?, APELLIDO_PATERNO=?, APELLIDO_MATERNO=?, NOMBRE=?, DNI=?, CARNET_EXTRANJERO=?, ESTADO_CIVIL=?, FECHA_NACIMIENTO=?, DIRECCION=?, CELULAR=?, EMAIL=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_PERSONA=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setString(1, persona.getDISTRITO());
            ps.setString(2, persona.getAPELLIDO_PATERNO());
            ps.setString(3, persona.getAPELLIDO_MATERNO());
            ps.setString(4, persona.getNOMBRE());
            ps.setString(5, persona.getDNI());
            ps.setString(6, persona.getCARNET_EXTRANJERO());
            ps.setString(7, persona.getESTADO_CIVIL());
            ps.setDate(8, Date.valueOf(persona.getFECHA_NACIMIENTO()));
            ps.setString(9, persona.getDIRECCION());
            ps.setString(10, persona.getCELULAR());
            ps.setString(11, persona.getEMAIL());
            ps.setString(12, persona.getUSUMOD());
            ps.setTimestamp(13, Timestamp.valueOf(persona.getFECMOD()));
            ps.setString(14, persona.getPCMOD());
            ps.setInt(15, persona.getID_PERSONA());

            status = ps.executeUpdate();
            System.out.println("Persona actualizada exitosamente");
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar la persona: " + e.getMessage());
        }
        return status;
    }

    // Buscar por ID
    public static Persona buscarPersonaByID(int id) {
        Persona persona = new Persona();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM persona WHERE ID_PERSONA=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                persona.setID_PERSONA(rs.getInt("ID_PERSONA"));
                persona.setDISTRITO(rs.getString("DISTRITO"));
                persona.setAPELLIDO_PATERNO(rs.getString("APELLIDO_PATERNO"));
                persona.setAPELLIDO_MATERNO(rs.getString("APELLIDO_MATERNO"));
                persona.setNOMBRE(rs.getString("NOMBRE"));
                persona.setDNI(rs.getString("DNI"));
                persona.setCARNET_EXTRANJERO(rs.getString("CARNET_EXTRANJERO"));
                persona.setESTADO_CIVIL(rs.getString("ESTADO_CIVIL"));
                persona.setFECHA_NACIMIENTO(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                persona.setDIRECCION(rs.getString("DIRECCION"));
                persona.setCELULAR(rs.getString("CELULAR"));
                persona.setEMAIL(rs.getString("EMAIL"));
                persona.setUSUCRE(rs.getString("USUCRE"));
                persona.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                persona.setPCCRE(rs.getString("PCCRE"));
                persona.setUSUMOD(rs.getString("USUMOD"));
                persona.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                persona.setPCMOD(rs.getString("PCMOD"));
                persona.setEstado(rs.getString("ESTADO").charAt(0));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar persona: " + e.getMessage());
        }
        return persona;
    }

    // Obtener todas las personas activas
    public static List<Persona> getAllPersonas() {
        List<Persona> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM persona WHERE ESTADO = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setID_PERSONA(rs.getInt("ID_PERSONA"));
                persona.setDISTRITO(rs.getString("DISTRITO"));
                persona.setAPELLIDO_PATERNO(rs.getString("APELLIDO_PATERNO"));
                persona.setAPELLIDO_MATERNO(rs.getString("APELLIDO_MATERNO"));
                persona.setNOMBRE(rs.getString("NOMBRE"));
                persona.setDNI(rs.getString("DNI"));
                persona.setCARNET_EXTRANJERO(rs.getString("CARNET_EXTRANJERO"));
                persona.setESTADO_CIVIL(rs.getString("ESTADO_CIVIL"));
                persona.setFECHA_NACIMIENTO(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                persona.setDIRECCION(rs.getString("DIRECCION"));
                persona.setCELULAR(rs.getString("CELULAR"));
                persona.setEMAIL(rs.getString("EMAIL"));
                lista.add(persona);
            }
            ps.close();
            cx.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al obtener personas: " + e.getMessage());
        }
        return lista;
    }

    // Deshabilitar (cambio de estado)
    public static int deshabilitarPersona(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE persona SET ESTADO='0' WHERE ID_PERSONA=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
            System.out.println("Persona deshabilitada correctamente");
        } catch (Exception e) {
            System.out.println("Error al deshabilitar persona: " + e.getMessage());
        }
        return status;
    }
}
