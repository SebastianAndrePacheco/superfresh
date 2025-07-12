package Modelo;

import java.time.LocalDateTime;

public class Menu {
    private int ID_MENU;
    private String NOMBRE_MENU;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;

    public Menu() {
    }

    public Menu(int ID_MENU, String NOMBRE_MENU, String USUCRE, LocalDateTime FECCRE,
                String PCCRE, String USUMOD, LocalDateTime FECMOD, String PCMOD) {
        this.ID_MENU = ID_MENU;
        this.NOMBRE_MENU = NOMBRE_MENU;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
    }

    public int getID_MENU() {
        return ID_MENU;
    }

    public void setID_MENU(int ID_MENU) {
        this.ID_MENU = ID_MENU;
    }

    public String getNOMBRE_MENU() {
        return NOMBRE_MENU;
    }

    public void setNOMBRE_MENU(String NOMBRE_MENU) {
        this.NOMBRE_MENU = NOMBRE_MENU;
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
