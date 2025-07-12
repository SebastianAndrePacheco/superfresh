package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class IngresoAlmacenProducto {
    private int ID_INGRESO;
    private LocalTime HORA;
    private int CANTIDAD;
    private String ENVASE;
    private String LOTE_ENVASE;
    private String PRESENTACION;
    private String LOTE_PRODUCTO;
    private LocalDate FECHA_VENCIMIENTO;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char ESTADO;

    public IngresoAlmacenProducto() {
    }

    public IngresoAlmacenProducto(int ID_INGRESO, LocalTime HORA, int CANTIDAD, String ENVASE, String LOTE_ENVASE,
                                  String PRESENTACION, String LOTE_PRODUCTO, LocalDate FECHA_VENCIMIENTO,
                                  String USUCRE, LocalDateTime FECCRE, String PCCRE,
                                  String USUMOD, LocalDateTime FECMOD, String PCMOD, char ESTADO) {
        this.ID_INGRESO = ID_INGRESO;
        this.HORA = HORA;
        this.CANTIDAD = CANTIDAD;
        this.ENVASE = ENVASE;
        this.LOTE_ENVASE = LOTE_ENVASE;
        this.PRESENTACION = PRESENTACION;
        this.LOTE_PRODUCTO = LOTE_PRODUCTO;
        this.FECHA_VENCIMIENTO = FECHA_VENCIMIENTO;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.ESTADO = ESTADO;
    }

    // Getters y Setters

    public int getID_INGRESO() {
        return ID_INGRESO;
    }

    public void setID_INGRESO(int ID_INGRESO) {
        this.ID_INGRESO = ID_INGRESO;
    }

    public LocalTime getHORA() {
        return HORA;
    }

    public void setHORA(LocalTime HORA) {
        this.HORA = HORA;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getENVASE() {
        return ENVASE;
    }

    public void setENVASE(String ENVASE) {
        this.ENVASE = ENVASE;
    }

    public String getLOTE_ENVASE() {
        return LOTE_ENVASE;
    }

    public void setLOTE_ENVASE(String LOTE_ENVASE) {
        this.LOTE_ENVASE = LOTE_ENVASE;
    }

    public String getPRESENTACION() {
        return PRESENTACION;
    }

    public void setPRESENTACION(String PRESENTACION) {
        this.PRESENTACION = PRESENTACION;
    }

    public String getLOTE_PRODUCTO() {
        return LOTE_PRODUCTO;
    }

    public void setLOTE_PRODUCTO(String LOTE_PRODUCTO) {
        this.LOTE_PRODUCTO = LOTE_PRODUCTO;
    }

    public LocalDate getFECHA_VENCIMIENTO() {
        return FECHA_VENCIMIENTO;
    }

    public void setFECHA_VENCIMIENTO(LocalDate FECHA_VENCIMIENTO) {
        this.FECHA_VENCIMIENTO = FECHA_VENCIMIENTO;
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

    public char getESTADO() {
        return ESTADO;
    }

    public void setESTADO(char ESTADO) {
        this.ESTADO = ESTADO;
    }
}
