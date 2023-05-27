package ar.com.dh.dao.impl;

import ar.com.dh.dao.IDao;
import ar.com.dh.db.DbManager;
import ar.com.dh.model.Domicilio;
import ar.com.dh.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    public static final Logger LOG = Logger.getLogger(DomicilioDaoH2.class);
    public static final String CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIOS;" +
            "CREATE TABLE DOMICILIOS " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(50)," +
            "NUMERO INT," +
            "LOCALIDAD VARCHAR (50)," +
            "PROVINCIA VARCHAR(50)); ";
    public static final String INSERTDOM = "INSERT INTO DOMICILIOS " +
            "(CALLE,NUMERO,LOCALIDAD,PROVINCIA) " +
            "VALUES (?,?,?,?);";
    public static final String DELETEDOM = "DELETE FROM DOMICILIOS WHERE ID=?";
    public static final String SELECTDOM = "SELECT * FROM DOMICILIOS WHERE ID=?";

    @Override
    public Domicilio buscar(Integer id) {
        return null;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection = null;

        try {
            connection = DbManager.getConnection();
            PreparedStatement prep = connection.prepareStatement(INSERTDOM, Statement.RETURN_GENERATED_KEYS);
            prep.setString(1, domicilio.getCalle());
            prep.setInt(2, domicilio.getNumero());
            prep.setString(3, domicilio.getLocalidad());
            prep.setString(4, domicilio.getProvincia());
            // inserto
            int filasAfectadas = prep.executeUpdate();
            // setear el id
            ResultSet rs = prep.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
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
        return domicilio;


    }

    @Override
    public Domicilio borrar(Integer id) {

        Connection connection = null;
        Domicilio domicilioQuery = new Domicilio();
        try {
            connection = DbManager.getConnection();

            // ME TRAIGO EL DOMICILIO
            PreparedStatement prep1 = connection.prepareStatement(SELECTDOM);
            prep1.setInt(1, id);
            ResultSet rs = prep1.executeQuery();
            while (rs.next()) {
                domicilioQuery.setId(rs.getInt("id"));
                domicilioQuery.setCalle(rs.getString("calle"));
                domicilioQuery.setNumero(rs.getInt("numero"));
                domicilioQuery.setLocalidad(rs.getString("localidad"));
                domicilioQuery.setProvincia(rs.getString("provincia"));
            }

            PreparedStatement prep2 = connection.prepareStatement(DELETEDOM);
            prep2.setInt(1, id);
            prep2.executeUpdate();
            LOG.warn("Se ha eliminado el domicilio con ID: " + id);
            prep2.close();

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return domicilioQuery;
    }

    @Override
    public List<Domicilio> listarTodos() {
        return null;
    }
}
