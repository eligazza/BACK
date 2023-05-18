package ar.com.dh.services;

import ar.com.dh.models.Ropa;

import java.util.HashMap;
import java.util.Map;

public class TallerDeCostura {
    private Map<String, Ropa> deposito = new HashMap<>();

    public Map<String, Ropa> getDeposito() {
        return deposito;
    }

    public Ropa getPrenda(String talle, String tipo, Boolean esNuevo, Boolean esImportada){
        String key = talle+tipo;

        if(deposito.get(key) == null){
            Ropa prenda = new Ropa(talle,tipo,esNuevo,esImportada);
            deposito.put(key,prenda);
        }
        return deposito.get(key);
    }
}
