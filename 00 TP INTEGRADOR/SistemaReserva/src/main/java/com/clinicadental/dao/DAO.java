package com.clinicadental.dao;

import java.util.List;

public interface DAO<T> {

    // METODOS DE LA INTERFACE
    List<T> listar();
    void agregar(T t);
    void modificar(int id, String parametro, String nuevoValor);
    List<T> consultarId(String nombre, String apellido);
    void eliminar(int id);

}
