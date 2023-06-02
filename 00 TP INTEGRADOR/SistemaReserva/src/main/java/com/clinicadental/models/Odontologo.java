package com.clinicadental.models;

public class Odontologo {

    //ATRIBUTOS
    private int id;
    private String nombre;
    private String apellido;
    private String matricula;

    // CONSTRUCTOR
    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getMatricula() {
        return matricula;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
