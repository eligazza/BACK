package ar.com.dh.services;

import ar.com.dh.models.Producto;
import ar.com.dh.models.Tarjeta;

public class DescuentoService implements IDescuento {

    ApiProducto apiProducto;
    ApiTarjeta apiTarjeta;
    ApiCantidad apiCantidad;

    public DescuentoService(ApiProducto apiProducto, ApiTarjeta apiTarjeta, ApiCantidad apiCantidad) {
        this.apiProducto = apiProducto;
        this.apiTarjeta = apiTarjeta;
        this.apiCantidad = apiCantidad;
    }

    public Integer calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {

        Integer descuentoPorElProducto = apiProducto.descuento(producto);

        Integer descuentoPorLaTarjeta = apiTarjeta.descuento(tarjeta);

        Integer descuentoPorCantidad = apiCantidad.descuento(cantidad);

        return descuentoPorElProducto + descuentoPorLaTarjeta + descuentoPorCantidad;
    }
}
