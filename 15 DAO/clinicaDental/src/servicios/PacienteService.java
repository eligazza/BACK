package servicios;

import daos.DAO;
import entidades.Paciente;

public class PacienteService {

    // ATRIBUTOS
    private DAO<Paciente> estrategia;

    // CONSTRUCTOR
    public PacienteService(DAO estrategia) {
        this.estrategia = estrategia;
    }

    // METODOS
    public boolean guardar(Paciente paciente) {
        return estrategia.guardar(paciente);
    };

    // TODO Cambiar de boolean a Paciente en el retorno de guarda()

    public Paciente buscar(int id) {
        return estrategia.buscar(id);
    };

    public void cambiarEstrategia() {};

}
