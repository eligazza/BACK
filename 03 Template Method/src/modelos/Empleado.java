package modelos;

import java.util.ArrayList;

public class Empleado extends Vendedor {

    // ATRIBUTOS
    private ArrayList<Vendedor> listaDeAfiliados;
    private int antiguedad;

    // CONSTRUCTOR
    public Empleado(String nombre, int cantidadDeVentas, int puntaje, int antiguedad) {
        super(nombre, cantidadDeVentas, puntaje);
        this.listaDeAfiliados = new ArrayList<Vendedor>();
        this.antiguedad = antiguedad;
    }

    // METODOS
    public void agregarAfiliado(Vendedor nuevoAfiliado) {
        this.listaDeAfiliados.add(nuevoAfiliado);
    }

    @Override
    public int calcularPuntos() {
        return (this.getCantidadDeVentas() * 5)
                + (this.listaDeAfiliados.size() * 10)
                + (this.antiguedad * 5);
    }

    // Getters & Setters
    public ArrayList<Vendedor> getListaDeAfiliados() {
        return listaDeAfiliados;
    }
    public void setListaDeAfiliados(ArrayList<Vendedor> listaDeAfiliados) {
        this.listaDeAfiliados = listaDeAfiliados;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
