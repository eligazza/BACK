package ar.com.dh.backend.tests;

import ar.com.dh.backend.model.Arbol;
import ar.com.dh.backend.service.ArbolFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolFactoryTest {

    @Test
    void test_diferentes_arboles() {
        // Arrange
        ArbolFactory factory = new ArbolFactory();
        List<Arbol> listaArboles = new ArrayList<>();

        // Act
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                listaArboles.add(factory.getArboles(200, 400, "verde", "ornamental"));
            } else if (i < 3) {
                listaArboles.add(factory.getArboles(500, 300, "rojo", "frutales"));
            } else {
                listaArboles.add(factory.getArboles(100, 200, "celeste", "floral"));
            }
        }
        // Assert
        Assertions.assertEquals( 3 , listaArboles.size());
    }

}

}