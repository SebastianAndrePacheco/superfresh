package Modelo;

import java.time.LocalDateTime;

public class Usuario {
    private int ID_USUARIO;
    private int ID_PERSONA;
    private String LOGEO;
    private String CLAVE;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char ESTADO;

    public Usuario() {
    }

    public Usuario(int ID_USUARIO, int ID_PERSONA, String LOGEO, String CLAVE, String USUCRE, LocalDateTime FECCRE,
                   String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD, char ESTADO) {
        this.ID_USUARIO = ID_USUARIO;
        this.ID_PERSONA = ID_PERSONA;
        this.LOGEO = LOGEO;
        this.CLAVE = CLAVE;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.ESTADO = ESTADO;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public int getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(int ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getLOGEO() {
        return LOGEO;
    }

    public void setLOGEO(String LOGEO) {
        this.LOGEO = LOGEO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
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
