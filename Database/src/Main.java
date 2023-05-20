import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        // Una vez que añadimos las dependencias h2.jar al proyecto
        // empezamos a usar las clases y encerramos con try/catch
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {

            // Creo la conexión
            connection = DriverManager.getConnection("jdbc:h2:~/test01;PASSWORD=sa;USER=sa");
            // BORRAMOS LA TABLA SI EXISTE
            Statement statementDrop = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS ANIMALES";
            statementDrop.execute(dropTable);

            // CREAMOS UNA TABLA
            Statement statementTabla = connection.createStatement();
            String crearTabla = "CREATE TABLE ANIMALES ( " +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(50) NOT NULL, " +
                    "TIPO VARCHAR(50) NOT NULL)";
            statementTabla.execute(crearTabla);

            // INSERTO FILA EN LA TABLA
            Statement statementInsert = connection.createStatement();
            String insertValor01 = "INSERT INTO ANIMALES VALUES ( DEFAULT, 'GERCITO', 'PERRO')";
            statementInsert.execute(insertValor01);

            // VISUALIZO LA TABLA
            Statement statementResult = connection.createStatement();
            String selectAll01 = "SELECT * FROM ANIMALES";
            ResultSet result01 = statementResult.executeQuery(selectAll01);
            while(result01.next()){
                System.out.println(result01.getInt(1) +
                                " - "+ result01.getString(2) +
                                " - " + result01.getString(3) );
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }






    }
}