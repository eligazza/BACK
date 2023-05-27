package ar.com.dh.dao.impl;

import ar.com.dh.dao.IDao;
import ar.com.dh.db.DbManager;
import ar.com.dh.model.Domicilio;
import ar.com.dh.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    public static final Logger LOG = Logger.getLogger(PacienteDaoH2.class);

    public static final String INSERTPAC = "INSERT INTO PACIENTES " +
            "(APELLIDO,NOMBRE,DNI,FECHA,DOMICILIO_ID) " +
            "VALUES (?,?,?,?,?);";
    public static final String DELETEPAC = "DELETE FROM PACIENTES WHERE ID=?";
    public static final String SELECTPAC = "SELECT * FROM PACIENTES WHERE ID = ?";

    @Override
    public Paciente buscar(Integer id) {
        return null;
    }

    @Override
    public Paciente guardar(Paciente paciente) {

        Connection connection = null;

        try {
            connection = DbManager.getConnection();
            PreparedStatement prep = connection.prepareStatement(INSERTPAC, Statement.RETURN_GENERATED_KEYS);
            prep.setString(1, paciente.getApellido());
            prep.setString(2, paciente.getNombre());
            prep.setString(3, paciente.getDni());
            prep.setString(4, paciente.getFecha());
            prep.setInt(5, paciente.getDomicilio().getId());
            // inserto
            int filasAfectadas = prep.executeUpdate();
            // setear el id
            ResultSet rs = prep.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1));
            }
            LOG.info("Se afectaron: " + filasAfectadas + " filas");
            prep.close();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return paciente;

    }

    @Override
    public Paciente borrar(Integer id) {

        Connection connection = null;
        Paciente pacienteQuery = new Paciente();
        try {
            connection = DbManager.getConnection();

            // ME TRAIGO EL PACIENTE
            PreparedStatement prep1 = connection.prepareStatement(SELECTPAC);
            prep1.setInt(1, id);
            ResultSet rs = prep1.executeQuery();
            while (rs.next()) {
                pacienteQuery.setId(rs.getInt("id"));
                pacienteQuery.setApellido(rs.getString("apellido"));
                pacienteQuery.setNombre(rs.getString("nombre"));
                pacienteQuery.setDni(rs.getString("dni"));
                pacienteQuery.setFecha(rs.getString("fecha"));
                pacienteQuery.setDomicilio(rs.getInt("domicilio_id"));
            }

            PreparedStatement prep2 = connection.prepareStatement(DELETEPAC);
            prep2.setInt(1, id);
            prep2.executeUpdate();
            LOG.warn("Se ha eliminado el paciente con ID: " + id);
            prep2.close();

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return pacienteQuery;
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }
}
