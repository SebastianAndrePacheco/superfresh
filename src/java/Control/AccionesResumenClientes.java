package Control;

import Modelo.ResumenClientes;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccionesResumenClientes {

    public static int registrarResumenCliente(ResumenClientes cliente) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "INSERT INTO resumen_clientes(Numero, Razon_social, RUC, Direccion, Referencia, Contacto, Telefono, Condicion, Precio_3kg_SF, Precio_C_C, Precio_1_5kg, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setInt(1, cliente.getNumero());
            ps.setString(2, cliente.getRazon_social());
            ps.setString(3, cliente.getRUC());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getReferencia());
            ps.setString(6, cliente.getContacto());
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getCondicion());
            ps.setDouble(9, cliente.getPrecio_3kg_SF());
            ps.setDouble(10, cliente.getPrecio_C_C());
            ps.setDouble(11, cliente.getPrecio_1_5kg());
            ps.setString(12, cliente.getUSUCRE());
            ps.setTimestamp(13, Timestamp.valueOf(cliente.getFECCRE()));
            ps.setString(14, cliente.getPCCRE());
            ps.setString(15, String.valueOf(cliente.getEstado()));

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al registrar el cliente");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static int actualizarResumenCliente(ResumenClientes cliente) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE resumen_clientes SET Numero=?, Razon_social=?, RUC=?, Direccion=?, Referencia=?, Contacto=?, Telefono=?, Condicion=?, Precio_3kg_SF=?, Precio_C_C=?, Precio_1_5kg=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_CLIENTE=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);

            ps.setInt(1, cliente.getNumero());
            ps.setString(2, cliente.getRazon_social());
            ps.setString(3, cliente.getRUC());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getReferencia());
            ps.setString(6, cliente.getContacto());
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getCondicion());
            ps.setDouble(9, cliente.getPrecio_3kg_SF());
            ps.setDouble(10, cliente.getPrecio_C_C());
            ps.setDouble(11, cliente.getPrecio_1_5kg());
            ps.setString(12, cliente.getUSUMOD());
            ps.setTimestamp(13, Timestamp.valueOf(cliente.getFECMOD()));
            ps.setString(14, cliente.getPCMOD());
            ps.setInt(15, cliente.getID_CLIENTE());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente");
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static ResumenClientes buscarResumenClienteByID(int id) {
        Conexion cx = new Conexion();
        ResumenClientes cliente = new ResumenClientes();
        try {
            String sql = "SELECT * FROM resumen_clientes WHERE ID_CLIENTE=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setID_CLIENTE(rs.getInt("ID_CLIENTE"));
                cliente.setNumero(rs.getInt("Numero"));
                cliente.setRazon_social(rs.getString("Razon_social"));
                cliente.setRUC(rs.getString("RUC"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setReferencia(rs.getString("Referencia"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setCondicion(rs.getString("Condicion"));
                cliente.setPrecio_3kg_SF(rs.getDouble("Precio_3kg_SF"));
                cliente.setPrecio_C_C(rs.getDouble("Precio_C_C"));
                cliente.setPrecio_1_5kg(rs.getDouble("Precio_1_5kg"));
                cliente.setUSUCRE(rs.getString("USUCRE"));
                cliente.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                cliente.setPCCRE(rs.getString("PCCRE"));
                cliente.setUSUMOD(rs.getString("USUMOD"));
                cliente.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                cliente.setPCMOD(rs.getString("PCMOD"));
                cliente.setEstado(rs.getString("Estado").charAt(0));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente");
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    public static List<ResumenClientes> getAllResumenClientes() {
        Conexion cx = new Conexion();
        List<ResumenClientes> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM resumen_clientes WHERE Estado = '1'";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ResumenClientes cliente = new ResumenClientes();
                cliente.setID_CLIENTE(rs.getInt("ID_CLIENTE"));
                cliente.setNumero(rs.getInt("Numero"));
                cliente.setRazon_social(rs.getString("Razon_social"));
                cliente.setRUC(rs.getString("RUC"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setReferencia(rs.getString("Referencia"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setCondicion(rs.getString("Condicion"));
                cliente.setPrecio_3kg_SF(rs.getDouble("Precio_3kg_SF"));
                cliente.setPrecio_C_C(rs.getDouble("Precio_C_C"));
                cliente.setPrecio_1_5kg(rs.getDouble("Precio_1_5kg"));
                lista.add(cliente);
            }
            ps.close();
            cx.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static int deshabilitarResumenClientes(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE resumen_clientes SET Estado = '0' WHERE ID_CLIENTE = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar cliente");
            System.out.println(e.getMessage());
        }
        return status;
    }
}
