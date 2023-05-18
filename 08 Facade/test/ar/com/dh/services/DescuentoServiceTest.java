package ar.com.dh.services;

import ar.com.dh.models.Producto;
import ar.com.dh.models.Tarjeta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescuentoServiceTest {

    @Test
    void test_calcula_solo_descuento_por_tipo_producto() {
        //ARRANGE
        Tarjeta tarjeta = new Tarjeta(1, "BBVA");
        Producto producto = new Producto("atun", "lata");
        DescuentoService service = new DescuentoService(new ApiProducto(), new ApiTarjeta(), new ApiCantidad());
        //ACT
        Integer descuento = service.calcularDescuento(tarjeta, producto, 1);
        //ASSERT
        Assertions.assertEquals(10, descuento);
    }

    @Test
    void test_calcula_solo_descuento_por_tarjeta() {
        //ARRANGE
        Tarjeta tarjeta = new Tarjeta(1, "Star Bank");
        Producto producto = new Producto("pan", "bolsa");
        DescuentoService service = new DescuentoService(new ApiProducto(), new ApiTarjeta(), new ApiCantidad());
        //ACT
        Integer descuento = service.calcularDescuento(tarjeta, producto, 1);
        //ASSERT
        Assertions.assertEquals(20, descuento);
    }


    @Test
    void test_calcula_solo_descuento_por_cantidad() {
        //ARRANGE
        Tarjeta tarjeta = new Tarjeta(1, "BBVA");
        Producto producto = new Producto("pan", "bolsa");
        DescuentoService service = new DescuentoService(new ApiProducto(), new ApiTarjeta(), new ApiCantidad());
        //ACT
        Integer descuento = service.calcularDescuento(tarjeta, producto, 13);
        //ASSERT
        Assertions.assertEquals(15, descuento);
    }
}