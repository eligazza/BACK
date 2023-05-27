package database;

import model.Odontologo;

import java.sql.*;

public class operaciones {

    public static void main(String[] args) {
        // Importar el Driver
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            // Crear la conexión
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            // Crear la tabla odontologos
            String SQLCREATETABLE = "DROP TABLE ODONTOLOGOS IF EXISTS; " +
                    "CREATE TABLE ODONTOLOGOS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY , " +
                    "apellido VARCHAR(25), " +
                    "nombre VARCHAR(25), " +
                    "matricula VARCHAR(25));";
            Statement stmt = connection.createStatement();
            stmt.execute(SQLCREATETABLE);

            // Insertar un odontologo
            Odontologo odo01 = new Odontologo("Santi", "Kesseler", "123KG");
            String SQLINSERT = "INSERT INTO ODONTOLOGOS (apellido, nombre, matricula) VALUES (?,?,?)";
            PreparedStatement prepInsert = connection.prepareStatement(SQLINSERT);
            prepInsert.setString(1, odo01.getApellido());
            prepInsert.setString(2, odo01.getNombre());
            prepInsert.setString(3, odo01.getMatricula());
            prepInsert.executeUpdate();

            // Modificar la matricula
            String SQLUPDATE = "UPDATE ODONTOLOGOS " +
                    "SET matricula = 'KG123' " +
                    "WHERE ID= (SELECT ID FROM ODONTOLOGOS WHERE nombre='Santi' AND apellido='Kesseler')";
            stmt.executeUpdate(SQLUPDATE);

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

}