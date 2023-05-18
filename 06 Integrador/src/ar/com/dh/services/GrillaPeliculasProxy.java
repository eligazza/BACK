package ar.com.dh.services;

import ar.com.dh.exceptions.PeliculaNoHabilitadaException;
import ar.com.dh.model.IPCliente;
import ar.com.dh.model.Pelicula;

public class GrillaPeliculasProxy implements GetPelicula {

    // ATRIBUTOS
    private IPCliente ipcliente;
    private GrillaPeliculas grilla;

    // CONSTRUCTOR
    public GrillaPeliculasProxy() {
        this.grilla = new GrillaPeliculas();
    }

    // METODOS
    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException {
        // Logica del proxy
        // traigo la película solicitada para poder ver el pais
        Pelicula peliculaSolicitada = grilla.getPelicula(nombre);
        // si el pais de la película coincide con el pais del cliente, devuelvo la pelicula
        if (peliculaSolicitada.getPais().equals(ipcliente.getPais())) {
            return peliculaSolicitada;
        } else {
            throw new PeliculaNoHabilitadaException("Pelicula no disponible en su país");
        }
    }

    // Getters & Setters
    public IPCliente getIpCliente() {
        return ipcliente;
    }
    public void setIpCliente(IPCliente ipCliente) {
        this.ipcliente = ipCliente;
    }
    public GrillaPeliculas getGrilla() {
        return grilla;
    }
    public void setGrilla(GrillaPeliculas grilla) {
        this.grilla = grilla;
    }
}
