package com.clinicadental.models;

import java.time.LocalDate;

public class Turno {

    // ATRIBUTOS
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fecha;

    // CONSTRUCTOR
    public Turno(Odontologo odontologo, Paciente paciente, LocalDate fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    // Getters & Setters
    public Odontologo getOdontologo() {
        return odontologo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}