package ar.com.dh.services;

import ar.com.dh.model.Pelicula;

public class GrillaPeliculas implements GetPelicula {
    @Override
    public Pelicula getPelicula(String nombre) {
        // Logica de la grilla (diferente a la del proxy)
        // Voy a poner una lista de películas que encuentro con la lógica
        // quizás debería diseñar un array de peliculas y que busque dentro del array
        // pero eso implicaría otro diseño
        return switch (nombre) {
            case "Ironman" -> new Pelicula("Iroman", "Colombia", "http://netflix.com/iroman");
            case "Hulk" -> new Pelicula("Hulk", "Brazil", "http://netflix.com/hulk");
            case "Spider-man" -> new Pelicula("Spider-man", "Argentina", "http://netflix.com/spiderman");
            default -> null;
        };
    }
}
