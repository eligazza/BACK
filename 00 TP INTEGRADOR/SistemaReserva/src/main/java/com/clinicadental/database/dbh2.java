package com.clinicadental.database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbh2 {

    // Logger
    private static final Logger LOG = Logger.getLogger(dbh2.class);

    // H2 Database Info
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String H2URL = "jdbc:h2:~/sistema-reservas";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    // MÉTODOS ÚTILES
    public static Connection conectar() {

        Connection connection;

        try {
            Class.forName(H2DRIVER);
            connection = DriverManager.getConnection(H2URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;

    }
    public static void crearTablaOdontologos() {

        try {
            Connection connection = dbh2.conectar();
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(25), APELLIDO VARCHAR(25), MATRICULA INT)");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public static void crearTablaPacientes() {

        try {
            Connection connection = dbh2.conectar();
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(25), APELLIDO VARCHAR(25), DNI INT, DOMICILIO VARCHAR(50), FECHA_ALTA DATETIME, TURNOS TEXT)"); // a los turnos voy a tener que convertirlos de LIST a JSON string usando alguna librería como Jackson o Gson.
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public static void crearTablaTurnos() {

        try {
            Connection connection = dbh2.conectar();
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS TURNOS (ID INT AUTO_INCREMENT PRIMARY KEY, ODONTOLOGO INT, PACIENTE INT, FECHA DATETIME)");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
