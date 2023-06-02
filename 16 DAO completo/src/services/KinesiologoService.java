package services;

import dao.DAO;
import models.Kinesiologo;

import java.util.List;

public class KinesiologoService {

    // ATRIBUTO
    private DAO<Kinesiologo> estrategia;

    // CONSTRUCTOR
    public KinesiologoService(DAO<Kinesiologo> estrategia) {
        this.estrategia = estrategia;
    }

    // METODOS
    public void agregar(Kinesiologo k) {
        if(estrategia.buscarPorNombreYApellido(k.getNombre(), k.getApellido()) != null) {
            estrategia.agregar(k);
        }
    }
    public void borrar(int id) {
        estrategia.borrar(id);
    }
    public List<Kinesiologo> listarTodos() {
        return estrategia.listarTodos();
    }
    public Kinesiologo buscarPorNombreYApellido(String nombre, String apellido) {
        return estrategia.buscarPorNombreYApellido(nombre, apellido);
    }

}
