package ar.com.dh.services;

import ar.com.dh.models.Tarjeta;

public class ApiTarjeta {
    public Integer descuento(Tarjeta tarjeta) {
        if (tarjeta.getBanco().equals("Star Bank")) {
            return 20;
        }
        return 0;
    }
}
