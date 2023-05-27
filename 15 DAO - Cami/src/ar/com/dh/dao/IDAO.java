package ar.com.dh.dao;

public interface IDAO<T>{
    public void  guardar(T t);
    public T buscar(int id);
}
