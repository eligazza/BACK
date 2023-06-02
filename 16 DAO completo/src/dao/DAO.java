package dao;

import java.util.List;

public interface DAO<T> {

    // MÉTODOS DE LA INTERFACE
    public void agregar(T t);
    public void borrar(int id);
    public List<T> listarTodos();
    public T buscarPorNombreYApellido(String nombre, String apellido);


}
