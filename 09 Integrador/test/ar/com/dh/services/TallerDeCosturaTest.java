package ar.com.dh.services;

import ar.com.dh.models.Ropa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TallerDeCosturaTest {

    @Test
    void testFabricaTipoCorrecto(){
        TallerDeCostura tallerDeCostura = new TallerDeCostura();
        Ropa pantalon = tallerDeCostura.getPrenda("L","Jogging",false,false);
        Ropa remera = tallerDeCostura.getPrenda("XL","Remera",true,true);

        Assertions.assertEquals("Jogging",pantalon.getTipo());
        Assertions.assertEquals("Remera",remera.getTipo());

    }

    @Test
    void testFabricaTamanio(){
        //ARRANGE
        TallerDeCostura tallerDeCostura = new TallerDeCostura();
        ArrayList<Ropa> compra = new ArrayList<>();

        //ACT (Un jogging para Jorgito)
        Ropa pantalon = tallerDeCostura.getPrenda("L","Jogging",false,false);
        Ropa pantalon2 = tallerDeCostura.getPrenda("L","Jogging",true,false);
        Ropa pantalon3 = tallerDeCostura.getPrenda("L","Jogging",false,true);
        Ropa pantalon4 = tallerDeCostura.getPrenda("L","Jogging",true,true);
        Ropa pantalon5 = tallerDeCostura.getPrenda("L","Jogging",false,false);
        Ropa remera = tallerDeCostura.getPrenda("XL","Remera",true,true);
        Ropa remera2 = tallerDeCostura.getPrenda("XL","Remera",false,false);
        compra.add(pantalon);
        compra.add(pantalon2);
        compra.add(pantalon3);
        compra.add(pantalon4);
        compra.add(pantalon5);
        compra.add(remera);
        compra.add(remera2);

        //ASSERT (Gracias Dani ♥)
        int tamanioFabrica = tallerDeCostura.getDeposito().size();
        int cantidadPedidos = compra.size();
        Assertions.assertTrue(cantidadPedidos>tamanioFabrica);
    }
}