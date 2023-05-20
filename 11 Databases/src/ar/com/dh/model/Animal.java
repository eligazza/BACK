package ar.com.dh.model;

public class Animal {

    private Integer id;
    private String nombre;
    private String tipo;

    public Animal(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
