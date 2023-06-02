package com.clinicadental.services;

import com.clinicadental.dao.DAO;
import com.clinicadental.models.Odontologo;

import java.util.List;

public class OdontologoService {

    // ATRIBUTO
    private DAO<Odontologo> estrategia;

    // CONSTRUCTOR
    public OdontologoService(DAO<Odontologo> estrategia) {
        this.estrategia = estrategia;
    }

    // METODOS
    public List<Odontologo> listar() {
        return estrategia.listar();
    }
    public void agregar(Odontologo odontologo) {
        estrategia.agregar(odontologo);
    }
    public void modificar(int id, String parametro, String nuevoValor) {
        estrategia.modificar(id,parametro,nuevoValor);
    }
    public List<Odontologo> consultarId(String nombre, String apellido) {
        return estrategia.consultarId(nombre, apellido);
    }
    public void eliminar(int id) {
        estrategia.eliminar(id);
    }
}
