package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

    // Logger
    private static final Logger LOG = Logger.getLogger(db.class);

    // H2 Database Info
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String H2URL = "jdbc:h2:~/examen";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    // MÉTODOS

    // este método crea una conexión a la base de datos "examen" listo para llamarlo adentro de cualquier EntityDaoH2;
    public static Connection conectarH2() {

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

    // Este método lo vamos a usar para crear las tablas. La idea es llamarlo solamente cuando lo necesitemos. Crear las tablas en el main o en test, pero una sola vez.
    public static void crearTabla(String sql) {

        try {
            Connection connection = db.conectarH2();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
