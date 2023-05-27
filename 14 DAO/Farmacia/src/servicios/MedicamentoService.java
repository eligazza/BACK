package servicios;

import dao.DAO;
import dao.MedicamentoDAOH2;
import modelos.Medicamento;
import org.apache.log4j.Logger;

public class MedicamentoService {

    // ATRIBUTOS
    private DAO estrategia; // referencia al dao


    // CONSTRUCTOR
    public MedicamentoService(DAO estrategia) {
        this.estrategia = estrategia;
    }

    // METODOS
    public int registrar(Medicamento medicamento) {
        return estrategia.registrar(medicamento);
    }
    public Medicamento buscar(int id) {
        return estrategia.buscar(id);
    }

    // Setters
    public void setEstrategia(DAO estrategia) {
        this.estrategia = estrategia;
    }
}
