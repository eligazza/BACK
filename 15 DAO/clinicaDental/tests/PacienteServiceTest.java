import daos.PacienteDAOH2;
import entidades.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicios.PacienteService;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteServiceTest {

    @Test
    void guardar_paciente_nuevo() {

        // Arrange (prepara lo que necesites tener de antemano)
        Paciente paciente01 = new Paciente("Aciar", "Sergio", "43578423", "hoy");
        PacienteService service = new PacienteService(new PacienteDAOH2()); // cree un servicio para pacientes que usa H2
        // Act (ejecuta la funcion que queres probar)
        boolean realidad = service.guardar(paciente01);
        // Assert (fijate si da bien)
        Assertions.assertTrue(realidad);
    }

    @Test
    void buscar_paciente_ingresado() {
        // Arrange
        // usamos el paciente ingresado en el punto anterior
        PacienteService service = new PacienteService(new PacienteDAOH2());
        // Act
        Paciente pacienteResultado = service.buscar(1);
        String nombreEncontrado = pacienteResultado.getNombre();
        String nombreEsperado = "Sergio";
        // Assert
        Assertions.assertEquals(nombreEsperado, nombreEncontrado);
    }
}