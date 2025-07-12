package Modelo;

import java.time.LocalDateTime;

public class Perfil {
    private int ID_PERFIL;
    private String NOMBRE_PERFIL;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char ESTADO;

    public Perfil() {
    }

    public Perfil(int ID_PERFIL, String NOMBRE_PERFIL, String USUCRE, LocalDateTime FECCRE,
                  String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD, char ESTADO) {
        this.ID_PERFIL = ID_PERFIL;
        this.NOMBRE_PERFIL = NOMBRE_PERFIL;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.ESTADO = ESTADO;
    }

    public int getID_PERFIL() {
        return ID_PERFIL;
    }

    public void setID_PERFIL(int ID_PERFIL) {
        this.ID_PERFIL = ID_PERFIL;
    }

    public String getNOMBRE_PERFIL() {
        return NOMBRE_PERFIL;
    }

    public void setNOMBRE_PERFIL(String NOMBRE_PERFIL) {
        this.NOMBRE_PERFIL = NOMBRE_PERFIL;
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
