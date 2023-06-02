package dao.implementations;

import dao.DAO;
import database.db;
import models.Kinesiologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KinesiologoDaoH2 implements DAO<Kinesiologo> {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(KinesiologoDaoH2.class);

    // CONSTRUCTOR
    public KinesiologoDaoH2() {
    }

    // METODOS
    @Override
    public void agregar(Kinesiologo kinesiologo) {

        // conectar
        Connection connection = db.conectarH2();
        // insertar
        try {
            connection.setAutoCommit(false);
            // statement
            String insertKinesio = "INSERT INTO KINESIOLOGOS (NOMBRE, APELLIDO, ANIO_NACIMIENTO, ATIENDE_OBRASOCIAL) VALUES(?, ?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(insertKinesio, PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1, kinesiologo.getNombre());
            prep.setString(2, kinesiologo.getApellido());
            prep.setInt(3, kinesiologo.getAnioNacimiento());
            prep.setBoolean(4, kinesiologo.getAtiendeObraSocial());
            // ejecución y log
            int filasAfectadas = prep.executeUpdate();
            ResultSet rsId = prep.getGeneratedKeys();
            while (rsId.next()) {
                kinesiologo.setId(rsId.getInt("id"));
            }
            LOG.info("Se modificó " + filasAfectadas + " fila/s. <" + kinesiologo.getApellido() + ", " + kinesiologo.getNombre() + "> agregado al registro. Se le asignó el ID: " + kinesiologo.getId() );
            // cierro statement
            prep.close();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                connection.rollback();
                LOG.error(e.getMessage());
            } catch (SQLException ex) {
                LOG.error("No se pudo dar marcha atrás a los cambios en la base de datos.");
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
    }

    @Override
    public void borrar(int id) {
        // conectar
        Connection connection = db.conectarH2();
        // borrar
        try {
            connection.setAutoCommit(false);
            // statement
            String deleteKinesio = "DELETE FROM KINESIOLOGOS WHERE ID=?";
            PreparedStatement prep = connection.prepareStatement(deleteKinesio);
            prep.setInt(1, id);
            // ejecución y log
            int filasAfectadas = prep.executeUpdate();
            LOG.info("Se modificó " + filasAfectadas + "fila/s. El registro <ID:" + id + "> ha sido eliminado.");
            // cierro statement
            prep.close();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
                LOG.error(e.getMessage());
            } catch (SQLException ex) {
                LOG.error("No se pudo dar marcha atrás a los cambios en la base de datos.");
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
    }

    @Override
    public List<Kinesiologo> listarTodos() {
        // conectar
        Connection connection = db.conectarH2();
        // insertar
        List<Kinesiologo> lista = new ArrayList<>();
        try {
            // statement
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM KINESIOLOGOS");
            while (rs.next()) {
                Kinesiologo k = new Kinesiologo();
                k.setId(rs.getInt("id"));
                k.setNombre(rs.getString("nombre"));
                k.setApellido(rs.getString("apellido"));
                k.setApellido(rs.getString("anio_nacimiento"));
                k.setAtiendeObraSocial(rs.getBoolean("atiende_obrasocial"));
                lista.add(k);
            }
            // cierro statement
            stmt.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
        return lista;
    }

    @Override
    public Kinesiologo buscarPorNombreYApellido(String nombre, String apellido) {
        Connection connection = db.conectarH2(); // me conecto

        // retorno
        Kinesiologo k = new Kinesiologo();
        try {
            // statement
            String searchKinesio = "SELECT * FROM KINESIOLOGOS WHERE NOMBRE = ? AND APELLIDO = ?";
            PreparedStatement prep = connection.prepareStatement(searchKinesio);
            prep.setString(1, nombre);
            prep.setString(2, apellido);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                //todo ¿qué pasa si se trae 2 resultados?
                k.setId(rs.getInt("id"));
                k.setNombre(rs.getString("nombre"));
                k.setApellido(rs.getString("apellido"));
                k.setAnioNacimiento(rs.getInt("anio_nacimiento"));
                k.setAtiendeObraSocial(rs.getBoolean("atiende_obrasocial"));
            }
            prep.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                connection.close(); // me desconecto
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
        return k;
    }
}
