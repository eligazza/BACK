import daos.PacienteDAORegistro;
import entidades.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicios.PacienteService;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteDAORegistroTest {

    @Test
    void guardar_paciente_enArray() {
        // Arrange
        Paciente paciente01 = new Paciente("Cormick", "Aylen", "124546575", "hoy");
        PacienteDAORegistro registro = new PacienteDAORegistro();
        PacienteService serviceArray = new PacienteService(registro);
        // Act
        serviceArray.guardar(paciente01);
        String expectativa = "Aylen";
        String realidad = registro.getListaDeRegistros().get(0).getNombre();
        // Assert
        Assertions.assertEquals(expectativa,realidad);
    }

    @Test
    void buscar_paciente_enArray() {
        // Arrange
        Paciente paciente02 = new Paciente("Edward", "Juan", "134879655", "ayer");
        PacienteService serviceArray = new PacienteService(new PacienteDAORegistro());
        serviceArray.guardar(paciente02);
        // Act
        Paciente pacienteEncontrado = serviceArray.buscar(1);
        String expectativa = pacienteEncontrado.getNombre();
        String realidad = "Juan";
        // Assert
        Assertions.assertEquals(expectativa,realidad);
    }
}