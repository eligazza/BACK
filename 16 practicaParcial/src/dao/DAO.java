package dao;

import models.Odontologo;

import java.util.List;

public interface DAO<T> {

    public void guardar(T t);

    public List<T> listar();
}
