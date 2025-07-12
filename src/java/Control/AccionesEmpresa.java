package Control;

import Modelo.Empresa;
import Control.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesEmpresa {

    // Registrar empresa
    public static int registrarEmpresa(Empresa empresa) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO empresa (razon_social, nombre_comercial, ruc, direccion, telefono, correo_electronico, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setString(1, empresa.getRazon_social());
            ps.setString(2, empresa.getNombre_comercial());
            ps.setString(3, empresa.getRuc());
            ps.setString(4, empresa.getDireccion());
            ps.setString(5, empresa.getTelefono());
            ps.setString(6, empresa.getCorreo_electronico());
            ps.setString(7, empresa.getUSUCRE());
            ps.setTimestamp(8, Timestamp.valueOf(empresa.getFECCRE()));
            ps.setString(9, empresa.getPCCRE());
            ps.setString(10, String.valueOf(empresa.getEstado()));

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar empresa: " + e.getMessage());
        }
        return status;
    }

    // Actualizar empresa
    public static int actualizarEmpresa(Empresa empresa) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE empresa SET razon_social=?, nombre_comercial=?, ruc=?, direccion=?, telefono=?, correo_electronico=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE id_empresa=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setString(1, empresa.getRazon_social());
            ps.setString(2, empresa.getNombre_comercial());
            ps.setString(3, empresa.getRuc());
            ps.setString(4, empresa.getDireccion());
            ps.setString(5, empresa.getTelefono());
            ps.setString(6, empresa.getCorreo_electronico());
            ps.setString(7, empresa.getUSUMOD());
            ps.setTimestamp(8, Timestamp.valueOf(empresa.getFECMOD()));
            ps.setString(9, empresa.getPCMOD());
            ps.setInt(10, empresa.getId_empresa());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar empresa: " + e.getMessage());
        }
        return status;
    }

    // Buscar empresa por ID
    public static Empresa buscarEmpresaByID(int id) {
        Empresa empresa = new Empresa();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM empresa WHERE id_empresa=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empresa.setId_empresa(rs.getInt("id_empresa"));
                empresa.setRazon_social(rs.getString("razon_social"));
                empresa.setNombre_comercial(rs.getString("nombre_comercial"));
                empresa.setRuc(rs.getString("ruc"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setCorreo_electronico(rs.getString("correo_electronico"));
                empresa.setUSUCRE(rs.getString("USUCRE"));
                empresa.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                empresa.setPCCRE(rs.getString("PCCRE"));
                empresa.setUSUMOD(rs.getString("USUMOD"));
                empresa.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                empresa.setPCMOD(rs.getString("PCMOD"));
                empresa.setEstado(rs.getString("ESTADO").charAt(0));
            }

            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar empresa: " + e.getMessage());
        }
        return empresa;
    }

    // Obtener todas las empresas activas
    public static List<Empresa> getAllEmpresas() {
        List<Empresa> lista = new ArrayList<>();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM empresa WHERE ESTADO='1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId_empresa(rs.getInt("id_empresa"));
                empresa.setRazon_social(rs.getString("razon_social"));
                empresa.setNombre_comercial(rs.getString("nombre_comercial"));
                empresa.setRuc(rs.getString("ruc"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(empresa);
            }

            ps.close();
            cx.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al listar empresas: " + e.getMessage());
        }
        return lista;
    }

    // Deshabilitar empresa (cambio de estado)
    public static int deshabilitarEmpresa(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE empresa SET ESTADO='0' WHERE id_empresa=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar empresa: " + e.getMessage());
        }
        return status;
    }
}
