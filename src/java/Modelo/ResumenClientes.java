package Modelo;

import java.time.LocalDateTime;

public class ResumenClientes {
    private int ID_CLIENTE;
    private int Numero;
    private String Razon_social;
    private String RUC;
    private String Direccion;
    private String Referencia;
    private String Contacto;
    private String Telefono;
    private String Condicion;
    private double Precio_3kg_SF;
    private double Precio_C_C;
    private double Precio_1_5kg;
    private String USUCRE;
    private LocalDateTime FECCRE;
    private String PCCRE;
    private String USUMOD;
    private LocalDateTime FECMOD;
    private String PCMOD;
    private char Estado;

    public ResumenClientes() {
    }

    public ResumenClientes(int ID_CLIENTE, int Numero, String Razon_social, String RUC, String Direccion,
                           String Referencia, String Contacto, String Telefono, String Condicion,
                           double Precio_3kg_SF, double Precio_C_C, double Precio_1_5kg,
                           String USUCRE, LocalDateTime FECCRE, String PCCRE,
                           String USUMOD, LocalDateTime FECMOD, String PCMOD, char Estado) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.Numero = Numero;
        this.Razon_social = Razon_social;
        this.RUC = RUC;
        this.Direccion = Direccion;
        this.Referencia = Referencia;
        this.Contacto = Contacto;
        this.Telefono = Telefono;
        this.Condicion = Condicion;
        this.Precio_3kg_SF = Precio_3kg_SF;
        this.Precio_C_C = Precio_C_C;
        this.Precio_1_5kg = Precio_1_5kg;
        this.USUCRE = USUCRE;
        this.FECCRE = FECCRE;
        this.PCCRE = PCCRE;
        this.USUMOD = USUMOD;
        this.FECMOD = FECMOD;
        this.PCMOD = PCMOD;
        this.Estado = Estado;
    }

    // Getters y Setters

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
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

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String condicion) {
        Condicion = condicion;
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
