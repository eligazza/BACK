package dao;

import modelos.Medicamento;

public interface DAO {

    public int registrar(Medicamento paciente);

    public Medicamento buscar(int id);

}
