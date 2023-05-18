package ar.com.dh.models;

public class Tarjeta {

    private Integer numero;
    private String banco;

    public Tarjeta(int numero, String banco) {
        this.numero = numero;
        this.banco = banco;

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
