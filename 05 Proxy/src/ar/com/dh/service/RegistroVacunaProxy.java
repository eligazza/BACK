package ar.com.dh.service;

import ar.com.dh.model.Persona;

import java.util.Date;

public class RegistroVacunaProxy implements Registro {

    RegistroVacuna centroVacunas;

    public RegistroVacunaProxy() {
        this.centroVacunas = new RegistroVacuna();
    }

    @Override
    public void vacunar(Persona persona) {

        if (persona.getFechaAsignada().before(new Date())) {
            centroVacunas.vacunar(persona);
        }
        else {
            System.out.println("fallo la validacion de fecha");
        }

    }
}
