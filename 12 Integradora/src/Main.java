import db.H2db;
import modelos.Usuario;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        // Creo una instancia de la base de datos H2
        H2db db = new H2db();

        // Genero la conexión
        Connection connection = db.creoConexion();

        // Creo la tabla "Usuarios" dentro de la bbdd usando la conexión creada
        db.crearTablaUsuarios(connection);

        // Creo 3 usuarios para insertar en la tabla
        Usuario user01 = new Usuario(1, "Elias", "Gazza", 32);
        Usuario user02 = new Usuario(2, "Maximiliano", "Fernandez", 38);
        Usuario user03 = new Usuario(3, "Ruben", "Bello", 32);

        // Inserto los 3 usuarios usando la conexión creada
        db.insertarUsuario(connection, user01);
        db.insertarUsuario(connection, user02);
        db.insertarUsuario(connection, user03);

        // Imprimo resultados
        db.imprimirResultados(connection);

        // Elimino 1 usuario usando la conexión creada
        db.eliminarUsuario(connection, 3);
        db.imprimirResultados(connection);

    }
}