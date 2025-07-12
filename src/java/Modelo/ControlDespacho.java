package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControlDespacho {
    private int ID_DESPACHO;
    private String Tipo;
    private LocalDate Fecha;
    private int Cantidad;
    private String Envase;
    private String Lote_envase;
    private String Presentacion;
    private String Lote_producto;
    private LocalDate Fecha_vencimiento;
    private String Cliente;
    private String Observaciones;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char Estado;

    public ControlDespacho() {
    }

    public ControlDespacho(int ID_DESPACHO, String Tipo, LocalDate Fecha, int Cantidad, String Envase,
                           String Lote_envase, String Presentacion, String Lote_producto, LocalDate Fecha_vencimiento,
                           String Cliente, String Observaciones, String USUCRE, LocalDateTime FECCRE,
                           String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD, char Estado) {
        this.ID_DESPACHO = ID_DESPACHO;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
        this.Cantidad = Cantidad;
        this.Envase = Envase;
        this.Lote_envase = Lote_envase;
        this.Presentacion = Presentacion;
        this.Lote_producto = Lote_producto;
        this.Fecha_vencimiento = Fecha_vencimiento;
        this.Cliente = Cliente;
        this.Observaciones = Observaciones;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.Estado = Estado;
    }

    // Getters y Setters

    public int getID_DESPACHO() {
        return ID_DESPACHO;
    }

    public void setID_DESPACHO(int ID_DESPACHO) {
        this.ID_DESPACHO = ID_DESPACHO;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getEnvase() {
        return Envase;
    }

    public void setEnvase(String Envase) {
        this.Envase = Envase;
    }

    public String getLote_envase() {
        return Lote_envase;
    }

    public void setLote_envase(String Lote_envase) {
        this.Lote_envase = Lote_envase;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public String getLote_producto() {
        return Lote_producto;
    }

    public void setLote_producto(String Lote_producto) {
        this.Lote_producto = Lote_producto;
    }

    public LocalDate getFecha_vencimiento() {
        return Fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate Fecha_vencimiento) {
        this.Fecha_vencimiento = Fecha_vencimiento;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
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

    public void setEstado(char Estado) {
        this.Estado = Estado;
    }
}
