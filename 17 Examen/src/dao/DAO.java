package dao;

import java.util.List;

public interface DAO<T> {

    // MÉTODOS A IMPLEMENTAR
    public void registrar(T t);
    public List<T> listarTodos();
}
