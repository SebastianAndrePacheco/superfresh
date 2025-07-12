package Modelo;

import java.time.LocalDateTime;

public class DetallePermiso {
    private int ID_DETALLE_PERMISO;
    private int ID_PERFIL;
    private int ID_SUBMENU;
    private char ACCESO;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;

    public DetallePermiso() {
    }

    public DetallePermiso(int ID_DETALLE_PERMISO, int ID_PERFIL, int ID_SUBMENU, char ACCESO,
                          String USUCRE, LocalDateTime FECCRE, String PCCRE,
                          String USUMOD, LocalDateTime FECMOD, String PCMOD) {
        this.ID_DETALLE_PERMISO = ID_DETALLE_PERMISO;
        this.ID_PERFIL = ID_PERFIL;
        this.ID_SUBMENU = ID_SUBMENU;
        this.ACCESO = ACCESO;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
    }

    public int getID_DETALLE_PERMISO() {
        return ID_DETALLE_PERMISO;
    }

    public void setID_DETALLE_PERMISO(int ID_DETALLE_PERMISO) {
        this.ID_DETALLE_PERMISO = ID_DETALLE_PERMISO;
    }

    public int getID_PERFIL() {
        return ID_PERFIL;
    }

    public void setID_PERFIL(int ID_PERFIL) {
        this.ID_PERFIL = ID_PERFIL;
    }

    public int getID_SUBMENU() {
        return ID_SUBMENU;
    }

    public void setID_SUBMENU(int ID_SUBMENU) {
        this.ID_SUBMENU = ID_SUBMENU;
    }

    public char getACCESO() {
        return ACCESO;
    }

    public void setACCESO(char ACCESO) {
        this.ACCESO = ACCESO;
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
