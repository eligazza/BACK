package ar.com.dh.service;

import ar.com.dh.model.Persona;

public class RegistroVacuna implements Registro {
    @Override
    public void vacunar(Persona persona) {
        System.out.println("Se ha registrado el paciente " + persona.getNombre() + "," + persona.getApellido());
        System.out.println("con la vacuna " + persona.getVacunaAsignada());

    }
}
