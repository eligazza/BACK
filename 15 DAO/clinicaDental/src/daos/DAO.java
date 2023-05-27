package daos;

public interface DAO<T> {

    // METODOS

    public boolean guardar(T t);

    public T buscar(int id);

}
