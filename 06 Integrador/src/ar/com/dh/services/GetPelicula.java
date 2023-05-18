package ar.com.dh.services;

import ar.com.dh.exceptions.PeliculaNoHabilitadaException;
import ar.com.dh.model.Pelicula;

public interface GetPelicula {
    public Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException;
}
