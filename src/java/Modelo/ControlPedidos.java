package Modelo;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class ControlPedidos {
    private int ID_PEDIDO;
    private String Pedido;
    private String Razon_social;
    private String RUC;
    private String Direccion;
    private String Referencia;
    private String Contacto;
    private String Telefono;
    private String Condicion_pago;
    private double Precio_3kg_SF;
    private double Precio_C_C;
    private double Precio_1_5kg;
    private String Tipo_documento;
    private int Cantidad_3kg;
    private int Cantidad_C_C;
    private int Cantidad_1_5kg;
    private int Cambio_3kg;
    private int Cambio_C_C;
    private int Cambio_1_5kg;
    private double Precio_facturar;
    private double Valor_venta;
    private double IGV_18;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char Estado;

    public ControlPedidos() {
    }

    public ControlPedidos(int ID_PEDIDO, String Pedido, String Razon_social, String RUC, String Direccion, String Referencia, String Contacto, String Telefono, String Condicion_pago,
                          double Precio_3kg_SF, double Precio_C_C, double Precio_1_5kg, String Tipo_documento,
                          int Cantidad_3kg, int Cantidad_C_C, int Cantidad_1_5kg, int Cambio_3kg, int Cambio_C_C, int Cambio_1_5kg,
                          double Precio_facturar, double Valor_venta, double IGV_18,
                          String USUCRE, LocalDateTime FECCRE, String PCCRE,
                          String USUMOD, LocalDateTime FECMOD, String PCMOD, char Estado) {
        this.ID_PEDIDO = ID_PEDIDO;
        this.Pedido = Pedido;
        this.Razon_social = Razon_social;
        this.RUC = RUC;
        this.Direccion = Direccion;
        this.Referencia = Referencia;
        this.Contacto = Contacto;
        this.Telefono = Telefono;
        this.Condicion_pago = Condicion_pago;
        this.Precio_3kg_SF = Precio_3kg_SF;
        this.Precio_C_C = Precio_C_C;
        this.Precio_1_5kg = Precio_1_5kg;
        this.Tipo_documento = Tipo_documento;
        this.Cantidad_3kg = Cantidad_3kg;
        this.Cantidad_C_C = Cantidad_C_C;
        this.Cantidad_1_5kg = Cantidad_1_5kg;
        this.Cambio_3kg = Cambio_3kg;
        this.Cambio_C_C = Cambio_C_C;
        this.Cambio_1_5kg = Cambio_1_5kg;
        this.Precio_facturar = Precio_facturar;
        this.Valor_venta = Valor_venta;
        this.IGV_18 = IGV_18;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.Estado = Estado;
    }

    // Getters y Setters

    public int getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(int ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String pedido) {
        Pedido = pedido;
    }

    public String getRazon_social() {
        return Razon_social;
    }

    public void setRazon_social(String razon_social) {
        Razon_social = razon_social;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCondicion_pago() {
        return Condicion_pago;
    }

    public void setCondicion_pago(String condicion_pago) {
        Condicion_pago = condicion_pago;
    }

    public double getPrecio_3kg_SF() {
        return Precio_3kg_SF;
    }

    public void setPrecio_3kg_SF(double precio_3kg_SF) {
        Precio_3kg_SF = precio_3kg_SF;
    }

    public double getPrecio_C_C() {
        return Precio_C_C;
    }

    public void setPrecio_C_C(double precio_C_C) {
        Precio_C_C = precio_C_C;
    }

    public double getPrecio_1_5kg() {
        return Precio_1_5kg;
    }

    public void setPrecio_1_5kg(double precio_1_5kg) {
        Precio_1_5kg = precio_1_5kg;
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        Tipo_documento = tipo_documento;
    }

    public int getCantidad_3kg() {
        return Cantidad_3kg;
    }

    public void setCantidad_3kg(int cantidad_3kg) {
        Cantidad_3kg = cantidad_3kg;
    }

    public int getCantidad_C_C() {
        return Cantidad_C_C;
    }

    public void setCantidad_C_C(int cantidad_C_C) {
        Cantidad_C_C = cantidad_C_C;
    }

    public int getCantidad_1_5kg() {
        return Cantidad_1_5kg;
    }

    public void setCantidad_1_5kg(int cantidad_1_5kg) {
        Cantidad_1_5kg = cantidad_1_5kg;
    }

    public int getCambio_3kg() {
        return Cambio_3kg;
    }

    public void setCambio_3kg(int cambio_3kg) {
        Cambio_3kg = cambio_3kg;
    }

    public int getCambio_C_C() {
        return Cambio_C_C;
    }

    public void setCambio_C_C(int cambio_C_C) {
        Cambio_C_C = cambio_C_C;
    }

    public int getCambio_1_5kg() {
        return Cambio_1_5kg;
    }

    public void setCambio_1_5kg(int cambio_1_5kg) {
        Cambio_1_5kg = cambio_1_5kg;
    }

    public double getPrecio_facturar() {
        return Precio_facturar;
    }

    public void setPrecio_facturar(double precio_facturar) {
        Precio_facturar = precio_facturar;
    }

    public double getValor_venta() {
        return Valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        Valor_venta = valor_venta;
    }

    public double getIGV_18() {
        return IGV_18;
    }

    public void setIGV_18(double IGV_18) {
        this.IGV_18 = IGV_18;
    }

    public String getUSUCRE() {
        return USUCRE;
    }

    public void setUSUCRE(String USUCRE) {
        this.USUCRE = USUCRE;
    }

    public LocalDateTime getFECCRE() {
        return FECCRE;
    }

    public void setFECCRE(LocalDateTime FECCRE) {
        this.FECCRE = FECCRE;
    }

    public String getPCCRE() {
        return PCCRE;
    }

    public void setPCCRE(String PCCRE) {
        this.PCCRE = PCCRE;
    }

    public String getUSUMOD() {
        return USUMOD;
    }

    public void setUSUMOD(String USUMOD) {
        this.USUMOD = USUMOD;
    }

    public LocalDateTime getFECMOD() {
        return FECMOD;
    }

    public void setFECMOD(LocalDateTime FECMOD) {
        this.FECMOD = FECMOD;
    }

    public String getPCMOD() {
        return PCMOD;
    }

    public void setPCMOD(String PCMOD) {
        this.PCMOD = PCMOD;
    }

    public char getEstado() {
        return Estado;
    }

    public void setEstado(char estado) {
        Estado = estado;
    }
}
