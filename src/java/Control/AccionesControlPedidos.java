package Control;

import Modelo.ControlPedidos;
import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesControlPedidos {

    // Actualizar un pedido existente
    public static int actualizarPedido(ControlPedidos pedido) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE control_pedidos SET Pedido=?, Razon_social=?, RUC=?, Direccion=?, Referencia=?, Contacto=?, Telefono=?, Condicion_pago=?, Precio_3kg_SF=?, Precio_C_C=?, Precio_1_5kg=?, Tipo_documento=?, Cantidad_3kg=?, Cantidad_C_C=?, Cantidad_1_5kg=?, Cambio_3kg=?, Cambio_C_C=?, Cambio_1_5kg=?, Precio_facturar=?, Valor_venta=?, IGV_18=?, USUMOD=?, FECMOD=?, PCMOD=? WHERE ID_PEDIDO=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, pedido.getPedido());
            ps.setString(2, pedido.getRazon_social());
            ps.setString(3, pedido.getRUC());
            ps.setString(4, pedido.getDireccion());
            ps.setString(5, pedido.getReferencia());
            ps.setString(6, pedido.getContacto());
            ps.setString(7, pedido.getTelefono());
            ps.setString(8, pedido.getCondicion_pago());
            ps.setDouble(9, pedido.getPrecio_3kg_SF());
            ps.setDouble(10, pedido.getPrecio_C_C());
            ps.setDouble(11, pedido.getPrecio_1_5kg());
            ps.setString(12, pedido.getTipo_documento());
            ps.setInt(13, pedido.getCantidad_3kg());
            ps.setInt(14, pedido.getCantidad_C_C());
            ps.setInt(15, pedido.getCantidad_1_5kg());
            ps.setInt(16, pedido.getCambio_3kg());
            ps.setInt(17, pedido.getCambio_C_C());
            ps.setInt(18, pedido.getCambio_1_5kg());
            ps.setDouble(19, pedido.getPrecio_facturar());
            ps.setDouble(20, pedido.getValor_venta());
            ps.setDouble(21, pedido.getIGV_18());
            ps.setString(22, pedido.getUSUMOD());
            ps.setTimestamp(23, Timestamp.valueOf(pedido.getFECMOD()));
            ps.setString(24, pedido.getPCMOD());
            ps.setInt(25, pedido.getID_PEDIDO());

            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pedido: " + e.getMessage());
        }
        return status;
    }

    // Buscar un pedido por su ID
    public static ControlPedidos buscarPedidoByID(int id) {
        ControlPedidos pedido = new ControlPedidos();
        Conexion cx = new Conexion();
        try {
            String sql = "SELECT * FROM control_pedidos WHERE ID_PEDIDO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido.setID_PEDIDO(rs.getInt("ID_PEDIDO"));
                pedido.setPedido(rs.getString("Pedido"));
                pedido.setRazon_social(rs.getString("Razon_social"));
                pedido.setRUC(rs.getString("RUC"));
                pedido.setDireccion(rs.getString("Direccion"));
                pedido.setReferencia(rs.getString("Referencia"));
                pedido.setContacto(rs.getString("Contacto"));
                pedido.setTelefono(rs.getString("Telefono"));
                pedido.setCondicion_pago(rs.getString("Condicion_pago"));
                pedido.setPrecio_3kg_SF(rs.getDouble("Precio_3kg_SF"));
                pedido.setPrecio_C_C(rs.getDouble("Precio_C_C"));
                pedido.setPrecio_1_5kg(rs.getDouble("Precio_1_5kg"));
                pedido.setTipo_documento(rs.getString("Tipo_documento"));
                pedido.setCantidad_3kg(rs.getInt("Cantidad_3kg"));
                pedido.setCantidad_C_C(rs.getInt("Cantidad_C_C"));
                pedido.setCantidad_1_5kg(rs.getInt("Cantidad_1_5kg"));
                pedido.setCambio_3kg(rs.getInt("Cambio_3kg"));
                pedido.setCambio_C_C(rs.getInt("Cambio_C_C"));
                pedido.setCambio_1_5kg(rs.getInt("Cambio_1_5kg"));
                pedido.setPrecio_facturar(rs.getDouble("Precio_facturar"));
                pedido.setValor_venta(rs.getDouble("Valor_venta"));
                pedido.setIGV_18(rs.getDouble("IGV_18"));
                pedido.setUSUCRE(rs.getString("USUCRE"));
                pedido.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
                pedido.setPCCRE(rs.getString("PCCRE"));
                pedido.setUSUMOD(rs.getString("USUMOD"));
                pedido.setFECMOD(rs.getTimestamp("FECMOD").toLocalDateTime());
                pedido.setPCMOD(rs.getString("PCMOD"));
                pedido.setEstado(rs.getString("ESTADO").charAt(0));
            }
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar el pedido: " + e.getMessage());
        }
        return pedido;
    }

    // Deshabilitar (cambio de estado) un pedido
    public static int deshabilitarControlPedidos(int id) {
        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "UPDATE control_pedidos SET ESTADO = '0' WHERE ID_PEDIDO = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
            cx.desconectar();
        } catch (Exception e) {
            System.out.println("Error al deshabilitar el pedido: " + e.getMessage());
        }
        return status;
    }
    // Registrar un nuevo pedido
public static int registrarPedido(ControlPedidos pedido) {
    Conexion cx = new Conexion();
    int status = 0;
    try {
        String sql = "INSERT INTO control_pedidos (Pedido, Razon_social, RUC, Direccion, Referencia, Contacto, Telefono, Condicion_pago, Precio_3kg_SF, Precio_C_C, Precio_1_5kg, Tipo_documento, Cantidad_3kg, Cantidad_C_C, Cantidad_1_5kg, Cambio_3kg, Cambio_C_C, Cambio_1_5kg, Precio_facturar, Valor_venta, IGV_18, USUCRE, FECCRE, PCCRE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = cx.conectar().prepareStatement(sql);
        ps.setString(1, pedido.getPedido());
        ps.setString(2, pedido.getRazon_social());
        ps.setString(3, pedido.getRUC());
        ps.setString(4, pedido.getDireccion());
        ps.setString(5, pedido.getReferencia());
        ps.setString(6, pedido.getContacto());
        ps.setString(7, pedido.getTelefono());
        ps.setString(8, pedido.getCondicion_pago());
        ps.setDouble(9, pedido.getPrecio_3kg_SF());
        ps.setDouble(10, pedido.getPrecio_C_C());
        ps.setDouble(11, pedido.getPrecio_1_5kg());
        ps.setString(12, pedido.getTipo_documento());
        ps.setInt(13, pedido.getCantidad_3kg());
        ps.setInt(14, pedido.getCantidad_C_C());
        ps.setInt(15, pedido.getCantidad_1_5kg());
        ps.setInt(16, pedido.getCambio_3kg());
        ps.setInt(17, pedido.getCambio_C_C());
        ps.setInt(18, pedido.getCambio_1_5kg());
        ps.setDouble(19, pedido.getPrecio_facturar());
        ps.setDouble(20, pedido.getValor_venta());
        ps.setDouble(21, pedido.getIGV_18());
        ps.setString(22, pedido.getUSUCRE());
        ps.setTimestamp(23, Timestamp.valueOf(pedido.getFECCRE()));
        ps.setString(24, pedido.getPCCRE());
        ps.setString(25, String.valueOf(pedido.getEstado()));

        status = ps.executeUpdate();
        ps.close();
        cx.desconectar();
    } catch (Exception e) {
        System.out.println("Error al registrar el pedido: " + e.getMessage());
    }
    return status;
}
public static List<ControlPedidos> getAllPedidos() {
    List<ControlPedidos> listaPedidos = new ArrayList<>();
    Conexion cx = new Conexion();
    try {
        String sql = "SELECT * FROM control_pedidos WHERE ESTADO = '1'"; // solo activos, puedes ajustar filtro
        PreparedStatement ps = cx.conectar().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            ControlPedidos pedido = new ControlPedidos();
            pedido.setID_PEDIDO(rs.getInt("ID_PEDIDO"));
            pedido.setPedido(rs.getString("Pedido"));
            pedido.setRazon_social(rs.getString("Razon_social"));
            pedido.setRUC(rs.getString("RUC"));
            pedido.setDireccion(rs.getString("Direccion"));
            pedido.setReferencia(rs.getString("Referencia"));
            pedido.setContacto(rs.getString("Contacto"));
            pedido.setTelefono(rs.getString("Telefono"));
            pedido.setCondicion_pago(rs.getString("Condicion_pago"));
            pedido.setPrecio_3kg_SF(rs.getDouble("Precio_3kg_SF"));
            pedido.setPrecio_C_C(rs.getDouble("Precio_C_C"));
            pedido.setPrecio_1_5kg(rs.getDouble("Precio_1_5kg"));
            pedido.setTipo_documento(rs.getString("Tipo_documento"));
            pedido.setCantidad_3kg(rs.getInt("Cantidad_3kg"));
            pedido.setCantidad_C_C(rs.getInt("Cantidad_C_C"));
            pedido.setCantidad_1_5kg(rs.getInt("Cantidad_1_5kg"));
            pedido.setCambio_3kg(rs.getInt("Cambio_3kg"));
            pedido.setCambio_C_C(rs.getInt("Cambio_C_C"));
            pedido.setCambio_1_5kg(rs.getInt("Cambio_1_5kg"));
            pedido.setPrecio_facturar(rs.getDouble("Precio_facturar"));
            pedido.setValor_venta(rs.getDouble("Valor_venta"));
            pedido.setIGV_18(rs.getDouble("IGV_18"));
            pedido.setUSUCRE(rs.getString("USUCRE"));
            pedido.setFECCRE(rs.getTimestamp("FECCRE").toLocalDateTime());
            pedido.setPCCRE(rs.getString("PCCRE"));
            pedido.setUSUMOD(rs.getString("USUMOD"));
            pedido.setFECMOD(rs.getTimestamp("FECMOD") != null ? rs.getTimestamp("FECMOD").toLocalDateTime() : null);
            pedido.setPCMOD(rs.getString("PCMOD"));
            pedido.setEstado(rs.getString("ESTADO").charAt(0));

            listaPedidos.add(pedido);
        }
        
        rs.close();
        ps.close();
        cx.desconectar();
    } catch (Exception e) {
        System.out.println("Error al obtener lista de pedidos: " + e.getMessage());
    }
    return listaPedidos;
}
}
