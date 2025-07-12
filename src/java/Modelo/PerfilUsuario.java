package Modelo;

import java.time.LocalDateTime;

public class PerfilUsuario {
    private int ID_PERFIL_USUARIO;
    private int ID_PERFIL;
    private int ID_USUARIO;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;

    public PerfilUsuario() {
    }

    public PerfilUsuario(int ID_PERFIL_USUARIO, int ID_PERFIL, int ID_USUARIO, String USUCRE,
                         LocalDateTime FECCRE, String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD) {
        this.ID_PERFIL_USUARIO = ID_PERFIL_USUARIO;
        this.ID_PERFIL = ID_PERFIL;
        this.ID_USUARIO = ID_USUARIO;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
    }

    public int getID_PERFIL_USUARIO() {
        return ID_PERFIL_USUARIO;
    }

    public void setID_PERFIL_USUARIO(int ID_PERFIL_USUARIO) {
        this.ID_PERFIL_USUARIO = ID_PERFIL_USUARIO;
    }

    public int getID_PERFIL() {
        return ID_PERFIL;
    }

    public void setID_PERFIL(int ID_PERFIL) {
        this.ID_PERFIL = ID_PERFIL;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
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
}
