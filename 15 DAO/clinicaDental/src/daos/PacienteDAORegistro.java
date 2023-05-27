package daos;
import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAORegistro implements DAO<Paciente> {

    // ATRIBUTOS
    private List<Paciente> listaDeRegistros = new ArrayList<>();
    // Getter
    public List<Paciente> getListaDeRegistros() {
        return listaDeRegistros;
    }

    @Override
    public boolean guardar(Paciente paciente) {
        paciente.setId(listaDeRegistros.size() + 1);
        return listaDeRegistros.add(paciente);
    }

    @Override
    public Paciente buscar(int id) {

        Paciente pacienteEncontrado = null;

        for (Paciente paciente : listaDeRegistros) {
            if (paciente.getId() == id) {
                pacienteEncontrado = paciente;
            }
        }
        return pacienteEncontrado;
    }

}
