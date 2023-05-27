package ar.com.dh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbManager {

    public static final String CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIOS;" +
            "CREATE TABLE DOMICILIOS " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(50)," +
            "NUMERO INT," +
            "LOCALIDAD VARCHAR (50)," +
            "PROVINCIA VARCHAR(50)); ";
    public static final String CREATE_PACIENTE = "DROP TABLE IF EXISTS PACIENTES;" +
            "CREATE TABLE PACIENTES " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            "APELLIDO VARCHAR(50)," +
            "NOMBRE VARCHAR(50)," +
            "DNI VARCHAR(50)," +
            "FECHA VARCHAR(50)," +
            "DOMICILIO_ID INT NOT NULL);";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinicaC2");
    }

    public static void createTable() throws Exception {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_DOMICILIO);
        statement.execute(CREATE_PACIENTE);
    }

}
