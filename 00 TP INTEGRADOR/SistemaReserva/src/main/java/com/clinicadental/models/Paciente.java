package com.clinicadental.models;

import java.time.LocalDate;
import java.util.List;

public class Paciente {

    // ATRIBUTOS
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private LocalDate fechaAlta;
    private List<Turno> turnos;

    // CONSTRUCTOR
    public Paciente(String nombre, String apellido, int dni, String domicilio, LocalDate fechaAlta, List<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.turnos = turnos;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getDni() {
        return dni;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public List<Turno> getTurnos() {
        return turnos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
