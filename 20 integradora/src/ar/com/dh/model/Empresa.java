package ar.com.dh.model;

import java.io.Serializable;
import java.util.*;

public class Empresa implements Serializable {

    // ATRIBUTOS
    private String razonSocial;
    private String cuit;
    private List<Empleado> listaEmpleados = new ArrayList<>();

    // Getters & Setters
    public String getRazonSocial() {
        return razonSocial;
    }
    public static void main(String[] args) {
        System.out.println("estoy en un main de empresa");
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
}
