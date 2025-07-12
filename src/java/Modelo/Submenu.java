package Modelo;

import java.time.LocalDateTime;

public class Submenu {
    private int ID_SUBMENU;
    private int ID_MENU;
    private String NOMBRE_SUBMENU;
    private String NOMBRE_FORMULARIO;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;

    public Submenu() {
    }

    public Submenu(int ID_SUBMENU, int ID_MENU, String NOMBRE_SUBMENU, String NOMBRE_FORMULARIO,
                   String USUCRE, LocalDateTime FECCRE, String PCCRE, String USUMOD,
                   LocalDateTime FECMOD, String PCMOD) {
        this.ID_SUBMENU = ID_SUBMENU;
        this.ID_MENU = ID_MENU;
        this.NOMBRE_SUBMENU = NOMBRE_SUBMENU;
        this.NOMBRE_FORMULARIO = NOMBRE_FORMULARIO;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
    }

    public int getID_SUBMENU() {
        return ID_SUBMENU;
    }

    public void setID_SUBMENU(int ID_SUBMENU) {
        this.ID_SUBMENU = ID_SUBMENU;
    }

    public int getID_MENU() {
        return ID_MENU;
    }

    public void setID_MENU(int ID_MENU) {
        this.ID_MENU = ID_MENU;
    }

    public String getNOMBRE_SUBMENU() {
        return NOMBRE_SUBMENU;
    }

    public void setNOMBRE_SUBMENU(String NOMBRE_SUBMENU) {
        this.NOMBRE_SUBMENU = NOMBRE_SUBMENU;
    }

    public String getNOMBRE_FORMULARIO() {
        return NOMBRE_FORMULARIO;
    }

    public void setNOMBRE_FORMULARIO(String NOMBRE_FORMULARIO) {
        this.NOMBRE_FORMULARIO = NOMBRE_FORMULARIO;
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
