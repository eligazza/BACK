package ar.com.dh.model;

import java.util.Date;

public class Persona {

    private Integer dni;
    private String apellido;
    private String nombre;
    private Date fechaAsignada;

    private String vacunaAsignada;

    public Persona(Integer dni, String apellido, String nombre, Date fechaAsignada, String vacunaAsignada) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaAsignada = fechaAsignada;
        this.vacunaAsignada = vacunaAsignada;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getVacunaAsignada() {
        return vacunaAsignada;
    }

    public void setVacunaAsignada(String vacunaAsignada) {
        this.vacunaAsignada = vacunaAsignada;
    }
}
