import daos.PacienteDAOH2;
import entidades.Paciente;
import servicios.PacienteService;

public class Main {
    public static void main(String[] args) {

        PacienteService service = new PacienteService(new PacienteDAOH2());


    }
}