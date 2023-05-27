package tests;

import dao.MedicamentoDAOH2;
import modelos.Medicamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicios.MedicamentoService;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {

    @Test
    void registrar_medicamento() {
        // ARRANGE
        Medicamento med01 = new Medicamento(123, "Ibuprofeno", "Bagó", 10, 100.00);
        MedicamentoService service = new MedicamentoService(new MedicamentoDAOH2()); // este servicio usa H2
        // ACT
        int expectativa = 1;
        int realidad = service.registrar(med01);
        // ASSERT
        Assertions.assertEquals(expectativa, realidad);
    }

    @Test
    void buscar_medicamento_ya_registrado() {
        // ARRANGE
        // Medicamento med01 = new Medicamento(123, "Ibuprofeno", "Bagó", 10, 100.00); // ya fue registrado
        MedicamentoService service = new MedicamentoService(new MedicamentoDAOH2());
        // ACT
        Medicamento medicamentoEncontrado = service.buscar(1);
        String expectativa = "Ibuprofeno";
        String realidad = medicamentoEncontrado.getNombre();
        // ASSERT
        Assertions.assertEquals(expectativa, realidad);
    }
}