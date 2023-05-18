package tests;

import modelos.Afiliado;
import modelos.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Vector;

class VendedorTest {

    @Test
    void test_empleado_50ventas(){
        // Arrange
        // creo un empleado desde 0
        Empleado empleado01 = new Empleado("Elias", 0,0,0);
        // le asigno 50 nuevas ventas
        empleado01.cerrarVenta(50);
        // creo la variable con lo que esperaría ver
        String expectativa = "VENDEDOR Elias: Maestro (250 puntos)"; // ventas*5 afiliados*10
        // Act
        String realidad = empleado01.mostrarCategoria();
        // Assert
        Assertions.assertEquals(expectativa, realidad);
    }

    @Test
    void test_empleado_agrega_afiliado(){
        // Arrange
            // creo un empleado desde 0
            Empleado empleado02 = new Empleado("Roberto", 0,0,0);
            // le asigno 2 nuevas ventas y 2 afiliados
            empleado02.cerrarVenta(2);
            empleado02.agregarAfiliado(new Afiliado("Pedro", 0,0));
            empleado02.agregarAfiliado(new Afiliado("Martin",0,0));
            // creo la variable con lo que esperaría ver
            String expectativa = "VENDEDOR Roberto: Aprendiz (30 puntos)"; // ventas*5 afiliados*10
        // Act
            String realidad = empleado02.mostrarCategoria();
        // Assert
            Assertions.assertEquals(expectativa, realidad);
    }

    @Test
    void test_afiliado_1ventas(){
        // Arrange
            // creo un empleado desde 0
            Afiliado afiliado01 = new Afiliado("Cacho", 0,0);
            // le asigno 1 nuevas ventas
            afiliado01.cerrarVenta(1);
            // creo la variable con lo que esperaría ver
            String expectativa = "VENDEDOR Cacho: Novato (15 puntos)"; // ventas*15
        // Act
            String realidad = afiliado01.mostrarCategoria();
        // Assert
            Assertions.assertEquals(expectativa, realidad);
    }
}