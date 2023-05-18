package ar.com.dh.services;

import ar.com.dh.models.Producto;
import ar.com.dh.models.Tarjeta;

public interface IDescuento {

    public Integer calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad);
}
