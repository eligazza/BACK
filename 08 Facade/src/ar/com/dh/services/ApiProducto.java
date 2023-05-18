package ar.com.dh.services;

import ar.com.dh.models.Producto;

public class ApiProducto {
    public Integer descuento(Producto producto) {

        if (producto.getTipo().equals("lata")) {
            return 10;
        }

        return 0;
    }
}
