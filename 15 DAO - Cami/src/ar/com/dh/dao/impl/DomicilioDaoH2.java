package ar.com.dh.dao.impl;

import ar.com.dh.dao.IDAO;
import ar.com.dh.model.Domicilio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DomicilioDaoH2 implements IDAO<Domicilio> {

    public static final String URL = "jdbc:h2:~/testOdontologo;INIT=RUNSCRIPT from 'create.sql'";
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    @Override
    public void guardar(Domicilio domicilio) {
        Connection connection = null;
        try {
            Class.forName(H2DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIOS (CALLE,NUMERO,LOCALIDAD,PROVINCIA) VALUES (?,?,?,?)");
            preparedStatement.setString(1,domicilio.getCalle());
            preparedStatement.setInt(2,domicilio.getNumero());
            preparedStatement.setString(3,domicilio.getLocalidad());
            preparedStatement.setString(4,domicilio.getProvincia());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection = null;
        Domicilio domicilioRes = null;

        try {
            Class.forName(H2DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
