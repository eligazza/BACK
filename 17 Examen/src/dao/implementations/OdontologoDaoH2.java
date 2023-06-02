package dao.implementations;

import dao.DAO;
import database.db;
import models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements DAO<Odontologo> {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(OdontologoDaoH2.class);

    // CONSTRUCTOR
    public OdontologoDaoH2() {}

    // MÉTODOS
    @Override
    public void registrar(Odontologo odontologo) {
        // conectar
        Connection connection = db.conectarH2();
        // insertar
        try {
            // statement
            String insertOdontologo = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(insertOdontologo, PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setInt(1, odontologo.getMatricula());
            prep.setString(2, odontologo.getNombre());
            prep.setString(3, odontologo.getApellido());
            // ejecución y log
            int filasAfectadas = prep.executeUpdate();
            ResultSet res = prep.getGeneratedKeys();
            while (res.next()) {
                odontologo.setId(res.getInt("id"));
            }
            LOG.info("Se modificó " + filasAfectadas + " fila/s. <" + odontologo.getApellido() + ", " + odontologo.getNombre() + "> agregado al registro. Se le asignó el ID: " + odontologo.getId() );
            // cierro statement
            prep.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error("No se pudo desconectar de la base de datos.");
            }
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        // conectar
        Connection connection = db.conectarH2();
        // insertar
        List<Odontologo> lista = new ArrayList<>();
        try {
            // statement
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ODONTOLOGOS");
            while (rs.next()) {
                Odontologo o = new Odontologo();
                o.setId(rs.getInt("id"));
                o.setMatricula(rs.getInt("matricula"));
                o.setNombre(rs.getString("nombre"));
                o.setApellido(rs.getString("apellido"));
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
}
