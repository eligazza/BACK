package services;

import dao.DAO;
import models.Odontologo;

import java.util.List;

public class OdontologoService {

    // ATRIBUTO
    private DAO<Odontologo> manejador;

    // CONSTRUCTOR
    public OdontologoService(DAO<Odontologo> manejador) {
        this.manejador = manejador;
    }

    // METODOS
    public void guardar(Odontologo odontologo) {
        manejador.guardar(odontologo);
    };
    public List<Odontologo> listar() {
        return manejador.listar();
    };
}
