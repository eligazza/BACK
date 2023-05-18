package ar.com.dh.services;

public class ApiCantidad {
    public Integer descuento(int cantidad) {
        if (cantidad > 12) {
            return 15;
        }
        return 0;
    }
}
