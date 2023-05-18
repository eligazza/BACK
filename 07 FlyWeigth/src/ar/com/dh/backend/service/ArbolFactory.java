package ar.com.dh.backend.service;

import ar.com.dh.backend.model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {

    // ATRIBUTOS
    private final static Map <String, Arbol> arboles = new HashMap<>();

    // CONSTRUCTOR
    // METODOS
    public Arbol getArboles(int alto, int ancho, String color, String tipo){
        if(!arboles.containsKey(tipo)){ // si no hay, lo crea
            arboles.put(tipo,new Arbol(alto,ancho,color,tipo));
            return arboles.get(tipo);
        }
        return arboles.get(tipo);
    }

    // Getters & Setters
}
