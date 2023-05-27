package ar.com.dh.dao;

import java.util.List;

public interface IDao<T> {

    public T buscar(Integer id);

    public T guardar(T t);

    public T borrar(Integer id);

    public List<T> listarTodos();
}
