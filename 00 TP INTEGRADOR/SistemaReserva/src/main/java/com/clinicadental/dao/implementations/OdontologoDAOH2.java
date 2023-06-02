package com.clinicadental.dao.implementations;

import com.clinicadental.dao.DAO;
import com.clinicadental.database.dbh2;
import com.clinicadental.models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements DAO<Odontologo> {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public List<Odontologo> listar() {

        // crear tabla si no existe
        dbh2.crearTablaOdontologos();

        // conectar
        Connection connection = dbh2.conectar();
        // insertar
        List<Odontologo> lista = new ArrayList<>();
        try {
            // statement
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ODONTOLOGOS");
            while (rs.next()) {
                Odontologo o = new Odontologo(rs.getString("nombre"), rs.getString("apellido"), rs.getString("matricula"));
                o.setId(rs.getInt("id"));
                lista.add(o);
            }
            stmt.close(); // cerramos statement
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                connection.close(); // cerramos la conexión
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
        System.out.println(lista.toString());
        return lista;
    }

    @Override
    public void agregar(Odontologo odontologo) {

        // crear tabla si no existe
        dbh2.crearTablaOdontologos();

        // conectar
        Connection connection = dbh2.conectar();

        // agregar
        try {
            // statement
            String insertOdontologo = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES(?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(insertOdontologo, PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1, odontologo.getNombre());
            prep.setString(2, odontologo.getApellido());
            prep.setString(3, odontologo.getMatricula());
            // ejecución y log
            int filasAfectadas = prep.executeUpdate();
            ResultSet res = prep.getGeneratedKeys();
            while (res.next()) {
                odontologo.setId(res.getInt("id"));
            }
            LOG.info(filasAfectadas + " fila afectada. <" + odontologo.getApellido() + ", " + odontologo.getNombre() + "> agregado con ID: " + odontologo.getId());
            prep.close(); // cierro statement
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                connection.close(); // cierro conexion
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
    }

    @Override
    public void modificar(int id, String parametro, String nuevoValor) {

        // crear tabla si no existe
        dbh2.crearTablaOdontologos();

        // conectar
        Connection connection = dbh2.conectar();

        // modifico
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE PACIENTES SET ? = '?' WHERE ID = ?");
            prep.setString(1, parametro.toUpperCase());
            prep.setString(2, nuevoValor.toUpperCase());
            prep.setInt(3, id);
            int filasAfectadas = prep.executeUpdate();
            LOG.info(filasAfectadas + " fila afectada. Se cambió <" + parametro + "> a " + nuevoValor);
            prep.close(); // cierro statement
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close(); // cierro conexion
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
    }

    @Override
    public List<Odontologo> consultarId(String nombre, String apellido) {

        // conectar
        Connection connection = dbh2.conectar();

        List<Odontologo> lista = new ArrayList<>();

        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE NOMBRE = ? AND APELLIDO = ?");
            prep.setString(1, nombre);
            prep.setString(2, apellido);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                Odontologo o = new Odontologo(rs.getString("nombre"), rs.getString("apellido"), rs.getString("matricula"));
                o.setId(rs.getInt("id"));
                lista.add(o);
            }
            prep.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void eliminar(int id) {

        // conectar
        Connection connection = dbh2.conectar();

        // eliminar
        try {
            connection.setAutoCommit(false);
            // statement
            PreparedStatement prep = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            prep.setInt(1, id);
            // ejecución y log
            int filasAfectadas = prep.executeUpdate();
            LOG.info(filasAfectadas + " fila afectada. Registro ID:" + id + " eliminado.");
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
}
