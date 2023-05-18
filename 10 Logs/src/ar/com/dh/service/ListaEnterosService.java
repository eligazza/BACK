package ar.com.dh.service;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaEnterosService {

    // Importo el Logger
    private static final Logger LOGGER = Logger.getLogger(ListaEnterosService.class);

    // ATRIBUTOS
    List<Integer> listaEnteros = new ArrayList<>();

    // CONSTRUCTOR
    public ListaEnterosService(int... values) {
        for (int value : values) {
            listaEnteros.add(value);
        }
        if (listaEnteros.size() > 5 && listaEnteros.size() <= 10) {
            LOGGER.info("La longitud de la lista es mayor a 5");
        }
        else if (listaEnteros.size() > 10) {
            LOGGER.info("La longitud de la lista es mayor a 10");
        }
        else if (listaEnteros.size() == 0) {
            LOGGER.error("La lista es igual a cero");
        }

    }

    // METODOS
    public Double getPromedio() {
        double sumatoria = 0.00;
        for (int value : listaEnteros) {
            sumatoria = sumatoria + value;
        }
        double promedio = sumatoria / listaEnteros.size();
        LOGGER.info("El promedio es: " + promedio );
        return promedio;
    }

    public int getMaximoDeLista() {
        return Collections.max(this.listaEnteros);
    }

    public int getMinimoDeLista() {
        return Collections.min(this.listaEnteros);
    }

}



