package ar.com.dh.tests;

import ar.com.dh.exceptions.PeliculaNoHabilitadaException;
import ar.com.dh.model.IPCliente;
import ar.com.dh.model.Pelicula;
import ar.com.dh.services.GrillaPeliculasProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GrillaPeliculasProxyTest {

    @Test
    void test_clientebrasilero_peliculacolombiana() {

        // Arrange
            // instancio el proxy
            GrillaPeliculasProxy proxy = new GrillaPeliculasProxy();
            // creo un cliente brasilero
            IPCliente clienteBrasilero = new IPCliente(70,255,255,255);
            // seteo el ip del cliente adentro del proxy
            proxy.setIpCliente(clienteBrasilero);

        // Assert
        Assertions.assertThrows(PeliculaNoHabilitadaException.class, () -> proxy.getPelicula("Ironman")); // ironman está disponible en colombia

    }

    @Test
    void test_clienteargentino_peliculacolombiana() {

        // Arrange
            // instancio el proxy
            GrillaPeliculasProxy proxy = new GrillaPeliculasProxy();
            // creo un cliente argentino
            IPCliente clienteArgentino = new IPCliente(30,255,255,255);
            // seteo el ip del cliente adentro del proxy
            proxy.setIpCliente(clienteArgentino);
        // Assert
            Assertions.assertThrows(PeliculaNoHabilitadaException.class, () -> proxy.getPelicula("Ironman")); // ironman esta disponible para colombia

    }

    @Test
    void test_clienteargentino_peliculaargentina() throws PeliculaNoHabilitadaException {

        // Arrange
            // instancio el proxy
            GrillaPeliculasProxy proxy = new GrillaPeliculasProxy();
            // creo un cliente argentino
            IPCliente clienteArgentino = new IPCliente(30,255,255,255);
            // seteo el ip del cliente adentro del proxy
            proxy.setIpCliente(clienteArgentino);
            // guardo el link esperado
            String expectativa = "http://netflix.com/spiderman";
        // Act
            // busco pelicula argentina con el proxy seteado en ip argentino
            Pelicula peliculaBuscada = proxy.getPelicula("Spider-man");
            // guardo el link de la busqueda
            String realidad = peliculaBuscada.getLink();
        // Assert
        Assertions.assertEquals(expectativa, realidad);

    }


}