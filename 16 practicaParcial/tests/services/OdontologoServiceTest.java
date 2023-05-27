package services;

import dao.OdonotologoDAOH2;
import models.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    @Test
    void guardar_odontologo() {

        // Arrange
        Odontologo checho = new Odontologo(123, "Sergio", "Aciar");
        OdontologoService service = new OdontologoService(new OdonotologoDAOH2());
        // Act
        service.guardar(checho); // sigue la logica H2
        // Assert


    }

    @Test
    void listar_5_odontologos() {

        // Arrange

        // Act

        // Assert

    }
}