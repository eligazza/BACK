package ar.com.dh.models;

public class Ropa {
    private String talle;
    private String tipo;
    private Boolean esNuevo;
    private Boolean esImportada;

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public Boolean getEsImportada() {
        return esImportada;
    }

    public void setEsImportada(Boolean esImportada) {
        this.esImportada = esImportada;
    }

    public Ropa(String talle, String tipo, Boolean esNuevo, Boolean esImportada) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.esImportada = esImportada;
    }
}
