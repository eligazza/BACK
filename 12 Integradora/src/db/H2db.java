package db;

import modelos.Usuario;

import java.sql.*;

public class H2db {

    public Connection creoConexion(){

        // Importo la clase de h2
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Establezco la conexion
        try {
            return DriverManager.getConnection("jdbc:h2:~/usuarios;PASSWORD=sa;USER=sa"); // retorno la conexión
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión");
            throw new RuntimeException(e);
        }

    }

    public void crearTablaUsuarios(Connection connection){

        // Creo la tabla y elimino si había otra con el mismo nombre
        try {
            String queryDrop = "DROP TABLE IF EXISTS USUARIOS";
            Statement statementDrop = connection.createStatement();
            statementDrop.execute(queryDrop);

            String queryCreate = "CREATE TABLE USUARIOS (" +
                    "ID INT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(25) NOT NULL, " +
                    "APELLIDO VARCHAR(25) NOT NULL, " +
                    "EDAD INT NOT NULL)";

            Statement statementCreate = connection.createStatement();
            statementCreate.execute(queryCreate);

        } catch (SQLException e) {
            System.out.println("No se pudo crear la tabla");
            throw new RuntimeException(e);
        }

    }

    public void insertarUsuario(Connection connection, Usuario usuario) {

        // Inserto el usuario
        try {
            String queryInsert = "INSERT INTO USUARIOS VALUES( '" +
                    usuario.getId() +
                    "', '" + usuario.getNombre() +
                    "','" + usuario.getApellido() +
                    "'," + usuario.getEdad() + ")";
            Statement statementInsert = connection.createStatement();
            statementInsert.execute(queryInsert);

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario");
            throw new RuntimeException(e);
        }
    }

    public void eliminarUsuario(Connection connection, int id) {

        // Elimino un usuario según el id
        try{
            String queryDelete = "DELETE FROM USUARIOS where ID = '" + id + "'";
            Statement statementDelete = connection.createStatement();
            statementDelete.execute(queryDelete);

        } catch (SQLException e) {
            System.out.println("Error al borrar registro");
            throw new RuntimeException(e);
        }
    }

    public void imprimirResultados(Connection connection) {

        // Selecciono toda la tabla y la guardo como resultado
        try{
            Statement statementSelect = connection.createStatement();
            String selectAll = "SELECT * FROM USUARIOS";
            ResultSet resultado = statementSelect.executeQuery(selectAll); // Acá se pone executeQuery porque no espera booleano, sino un dataset
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt(1) +
                        ", Nombre:" + resultado.getString(2) +
                        ", Apellido: " + resultado.getString(3) +
                        ", Edad: " + resultado.getInt(4));
            }

        } catch (SQLException e) {
            System.out.println("Error al imprimir tabla");
            throw new RuntimeException(e);
        }
    }
}
