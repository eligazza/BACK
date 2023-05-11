package tests;

import modelos.EmpleadoClasico;
import modelos.EmpleadoInfantil;
import modelos.EmpleadoVeggie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestEmpleado {

    @Test
    public void calcular_precio_menu_clasico() {
        // Arrange
        EmpleadoClasico empleadoClasico01 = new EmpleadoClasico();
        double resultadoEsperado = 1000.00;
        // Act
        empleadoClasico01.prepararMenu();
        double resultadoObtenido = empleadoClasico01.getPrecioFinal();
        // Assert
        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }
    @Test
    public void calcular_precio_menu_infantil() {
        // Arrange
        EmpleadoInfantil empleadoInfantil01 = new EmpleadoInfantil(3);
        double resultadoEsperado = 1009.00; // serían $1000 + ($3 * 3juguetes)
        // Act
        empleadoInfantil01.prepararMenu();
        double resultadoObtenido = empleadoInfantil01.getPrecioFinal();
        // Assert
        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void calcular_precio_menu_veggie_salsas() {
        // Arrange
        EmpleadoVeggie empleadoVeggie01 = new EmpleadoVeggie(false,3);
        double resultadoEsperado = 1006.00; // serían $1000 + ($2 * 3salsas)
        // Act
        empleadoVeggie01.prepararMenu();
        double resultadoObtenido = empleadoVeggie01.getPrecioFinal();
        // Assert
        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void calcular_precio_menu_veggie_especias() {
        // Arrange
        EmpleadoVeggie empleadoVeggie02 = new EmpleadoVeggie(true,0);
        double resultadoEsperado = 1010.00; // serían $1000 * 1.01
        // Act
        empleadoVeggie02.prepararMenu();
        double resultadoObtenido = empleadoVeggie02.getPrecioFinal();
        // Assert
        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void calcular_precio_menu_veggie_salsas_especias() {
        // Arrange
        EmpleadoVeggie empleadoVeggie03 = new EmpleadoVeggie(true,2);
        double resultadoEsperado = 1014.04; // serían [ $1000 + ($2 * 2salsas) ] * 1.01
        // Act
        empleadoVeggie03.prepararMenu();
        double resultadoObtenido = empleadoVeggie03.getPrecioFinal();
        // Assert
        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }

}
