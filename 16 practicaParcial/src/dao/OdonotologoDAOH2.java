package dao;

import models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdonotologoDAOH2 implements DAO<Odontologo> {

    private static final Logger LOG = Logger.getLogger(OdonotologoDAOH2.class);

    @Override
    public void guardar(Odontologo odontologo) {
        // crear la bbdd
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/practica;INIT=RUNSCRIPT from 'create_table.sql'", "sa", "sa");
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(e.getMessage());
        }

        // hacer la sentencia sql y ejecutarla
        try {
            PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)");
            prepStmt.setInt(1, odontologo.getMatricula());
            prepStmt.setString(2, odontologo.getNombre());
            prepStmt.setString(3, odontologo.getApellido());
            int rows = prepStmt.executeUpdate();

            LOG.info("Se han añadido a " + odontologo.getApellido() + ", " + odontologo.getNombre() + " - " + rows + " fila");

            prepStmt.close(); // cierro la conexión
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Odontologo> listar() {

        Connection connection = null;
        List<Odontologo> lista = new ArrayList<>();

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/practica;INIT=RUNSCRIPT from 'create_table.sql'", "sa", "sa");
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(e.getMessage());
        }

        try {
            String SQLSelect = "SELECT * FROM ODONTOLOGOS";
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(SQLSelect);

            while (resultado.next()) {
                Odontologo o = new Odontologo();
                o.setId(resultado.getInt(1)); // columna 1 id
                o.setMatricula(resultado.getInt(2)); // columna 2 matricula
                o.setNombre(resultado.getString(3)); // columna 3 nombre
                o.setApellido(resultado.getString(4)); // columna 4 apellido
                lista.add(o); // pujá
            }
            connection.close(); // cierro la conexión

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
