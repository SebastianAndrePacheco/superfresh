package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona {
    private int ID_PERSONA;
    private String DISTRITO;
    private String APELLIDO_PATERNO;
    private String APELLIDO_MATERNO;
    private String NOMBRE;
    private String DNI;
    private String CARNET_EXTRANJERO;
    private String ESTADO_CIVIL;
    private LocalDate FECHA_NACIMIENTO;
    private String DIRECCION;
    private String CELULAR;
    private String EMAIL;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char estado;

    public Persona() {
    }

    public Persona(int ID_PERSONA, String DISTRITO, String APELLIDO_PATERNO, String APELLIDO_MATERNO, String NOMBRE,
                   String DNI, String CARNET_EXTRANJERO, String ESTADO_CIVIL, LocalDate FECHA_NACIMIENTO,
                   String DIRECCION, String CELULAR, String EMAIL, String USUCRE, LocalDateTime FECCRE,
                   String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD, char estado) {
        this.ID_PERSONA = ID_PERSONA;
        this.DISTRITO = DISTRITO;
        this.APELLIDO_PATERNO = APELLIDO_PATERNO;
        this.APELLIDO_MATERNO = APELLIDO_MATERNO;
        this.NOMBRE = NOMBRE;
        this.DNI = DNI;
        this.CARNET_EXTRANJERO = CARNET_EXTRANJERO;
        this.ESTADO_CIVIL = ESTADO_CIVIL;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.DIRECCION = DIRECCION;
        this.CELULAR = CELULAR;
        this.EMAIL = EMAIL;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.estado = estado;
    }

    public int getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(int ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getAPELLIDO_PATERNO() {
        return APELLIDO_PATERNO;
    }

    public void setAPELLIDO_PATERNO(String APELLIDO_PATERNO) {
        this.APELLIDO_PATERNO = APELLIDO_PATERNO;
    }

    public String getAPELLIDO_MATERNO() {
        return APELLIDO_MATERNO;
    }

    public void setAPELLIDO_MATERNO(String APELLIDO_MATERNO) {
        this.APELLIDO_MATERNO = APELLIDO_MATERNO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCARNET_EXTRANJERO() {
        return CARNET_EXTRANJERO;
    }

    public void setCARNET_EXTRANJERO(String CARNET_EXTRANJERO) {
        this.CARNET_EXTRANJERO = CARNET_EXTRANJERO;
    }

    public String getESTADO_CIVIL() {
        return ESTADO_CIVIL;
    }

    public void setESTADO_CIVIL(String ESTADO_CIVIL) {
        this.ESTADO_CIVIL = ESTADO_CIVIL;
    }

    public LocalDate getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(LocalDate FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
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
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
