package db;

import modelos.Usuario;
import org.apache.log4j.Logger;

import java.sql.*;

public class H2db {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(H2db.class);

    // METODOS
    public Connection creoConexion(){

        // Importo la clase de h2
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Establezco la conexion
        try {
            LOG.info("Conexión con la base de datos establecida.");
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
            LOG.info("Tabla de datos 'Usuarios' creada con éxito.");

        } catch (SQLException e) {
            LOG.error("No se pudo crear la tabla (SQLException)");
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
            LOG.info("El usuario <" + usuario.getApellido() + ", " + usuario.getNombre() + "> ha sido registrado");

        } catch (SQLException e) {
            LOG.error("Error al insertar usuario, intente de nuevo (SQLException)");
            throw new RuntimeException(e);
        }
    }

    public void eliminarUsuario(Connection connection, int id) {

        // Elimino un usuario según el id
        try{
            String userInfo = "SELECT APELLIDO, NOMBRE from USUARIOS where ID = "+ id;
            Statement statementInfo = connection.createStatement();
            ResultSet usuario = statementInfo.executeQuery(userInfo);
            while (usuario.next()) {
                LOG.warn("El usuario <" +
                        usuario.getString(1) + ", " +
                        usuario.getString(2)+ "> ha sido eliminado");
            }

            String queryDelete = "DELETE from USUARIOS where ID = '" + id + "'";
            Statement statementDelete = connection.createStatement();
            statementDelete.execute(queryDelete);

        } catch (SQLException e) {
            LOG.error("Error al borrar registro (SQLException)");
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
                        ", Nombre: " + resultado.getString(2) +
                        ", Apellido: " + resultado.getString(3) +
                        ", Edad: " + resultado.getInt(4));
            }

        } catch (SQLException e) {
            LOG.error("Error al imprimir tabla (SQLException)");
            throw new RuntimeException(e);
        }
    }
}
