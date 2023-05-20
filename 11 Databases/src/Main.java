import ar.com.dh.model.Animal;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/testc5;PASSWORD=sa;USER=sa");

            String SQLCREATE = "CREATE TABLE ANIMALES ( ID INT PRIMARY KEY , NOMBRE VARCHAR (50) NOT NULL , TIPO VARCHAR(50) NOT NULL);";

            Statement statement = connection.createStatement();
            statement.execute(SQLCREATE);

            Animal thor = new Animal(2, "malala", "perro");

            String SQLINSERT = "INSERT INTO ANIMALES  VALUES ('" + thor.getId() + "','"
                    + thor.getNombre() + "','" + thor.getTipo() + "')";

            Statement statementInsert = connection.createStatement();
            statementInsert.execute(SQLINSERT);

            String SQLSELECT = "SELECT * FROM ANIMALES";
            Statement statementSelect = connection.createStatement();
            ResultSet resultado = statementSelect.executeQuery(SQLSELECT);
            while (resultado.next()) {
                System.out.println(resultado.getInt(1) + "-" + resultado.getString(2)
                        + "-" + resultado.getString(3));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}