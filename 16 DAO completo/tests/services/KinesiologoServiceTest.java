package services;

import dao.implementations.KinesiologoDaoH2;
import database.db;
import models.Kinesiologo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KinesiologoServiceTest {

    @BeforeEach
    void setUp() {
        db.tablaH2("CREATE TABLE IF NOT EXISTS KINESIOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(25), APELLIDO VARCHAR(25), ANIO_NACIMIENTO INT, ATIENDE_OBRASOCIAL BOOLEAN)");
    }

    @AfterEach
    void tearDown() {
        db.tablaH2("DROP TABLE KINESIOLOGOS");
    }

    @Test
    void agregar_kinesiologos() throws SQLException {

        // Arrange
        Kinesiologo kinesio1 = new Kinesiologo("Sylvan", "Crucifijo", 1988, true);
        Kinesiologo kinesio2 = new Kinesiologo("Elias", "Gazza", 1990, true);
        Kinesiologo kinesio3 = new Kinesiologo("Marcos", "Amado", 1990, false);
        KinesiologoService serviceH2 = new KinesiologoService(new KinesiologoDaoH2());
        // Act
        serviceH2.agregar(kinesio1);
        serviceH2.agregar(kinesio2);
        serviceH2.agregar(kinesio3);
        // Assert
        Connection cn = db.conectarH2();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM KINESIOLOGOS");
        List<String> res = new ArrayList<>();
        while (rs.next()) {
            res.add(rs.getString("nombre"));
        }
        Assertions.assertEquals(3, res.size());
    }

    @Test
    void listar_todos_los_registros() {
        // Arrange
        Kinesiologo kinesio1 = new Kinesiologo("Sylvan", "Crucifijo", 1988, true);
        Kinesiologo kinesio2 = new Kinesiologo("Elias", "Gazza", 1990, true);
        Kinesiologo kinesio3 = new Kinesiologo("Marcos", "Amado", 1990, false);
        KinesiologoService serviceH2 = new KinesiologoService(new KinesiologoDaoH2());
        serviceH2.agregar(kinesio1);
        serviceH2.agregar(kinesio2);
        serviceH2.agregar(kinesio3);
        // Act
        List<Kinesiologo> registro = serviceH2.listarTodos();
        // Assert
        Assertions.assertEquals(3, registro.size());
    }

    @Test
    void borrar() throws SQLException {
        // Arrange
        Kinesiologo kinesio1 = new Kinesiologo("Sylvan", "Crucifijo", 1988, true);
        Kinesiologo kinesio2 = new Kinesiologo("Elias", "Gazza", 1990, true);
        Kinesiologo kinesio3 = new Kinesiologo("Marcos", "Amado", 1990, false);
        KinesiologoService serviceH2 = new KinesiologoService(new KinesiologoDaoH2());
        serviceH2.agregar(kinesio1);
        serviceH2.agregar(kinesio2);
        serviceH2.agregar(kinesio3);
        // Act
        serviceH2.borrar(1);
        // Assert
        Connection cn = db.conectarH2();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM KINESIOLOGOS");
        List<String> res = new ArrayList<>();
        while (rs.next()) {
            res.add(rs.getString("nombre"));
        }
        Assertions.assertEquals(2, res.size());
    }


    @Test
    void buscar_kinesiologo_Marcos() {
        // Arrange
        Kinesiologo kinesio1 = new Kinesiologo("Sylvan", "Crucifijo", 1988, true);
        Kinesiologo kinesio2 = new Kinesiologo("Elias", "Gazza", 1990, true);
        Kinesiologo kinesio3 = new Kinesiologo("Marcos", "Amado", 1990, false);
        KinesiologoService serviceH2 = new KinesiologoService(new KinesiologoDaoH2());
        serviceH2.agregar(kinesio1);
        serviceH2.agregar(kinesio2);
        serviceH2.agregar(kinesio3);
        // Act
        Kinesiologo query = serviceH2.buscarPorNombreYApellido("Marcos", "Amado");
        // Assert
        Assertions.assertFalse(query.getAtiendeObraSocial());
    }
}