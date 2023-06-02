package ar.com.dh.model;

import java.io.Serializable;

public class Empleado implements Serializable {

    private String nombre;
    private String apellido;
    private String legajo;
    private Integer sueldo;

    public Empleado(String nombre, String apellido, String legajo, Integer sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo='" + legajo + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }

    public String getCSV() {
        return nombre + ";" + apellido + ";" + legajo + ";" + sueldo;
    }
}
