package dao;

import modelos.Medicamento;

import java.sql.*;

public class previous {

    // CONSTANTES
    public static final String URL = "jdbc:h2:~/test;INIT=RUNSCRIPT from 'create_table.sql'";
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    // METODOS

    public Connection conectar() {
        try {
            Class.forName(H2DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void registrar(Connection connection, Medicamento medicamento) {

        // Importar el Driver y conectarme
        try {
            // Insertar el medicamento
            String SQLInsert = "INSERT INTO MEDICAMENTOS (codigo, nombre, laboratorio, cantidad, precio) VALUES (?,?,?,?,?)";
            PreparedStatement prepInsert = connection.prepareStatement(SQLInsert);
            prepInsert.setInt(1, medicamento.getCodigo());
            prepInsert.setString(2, medicamento.getNombre());
            prepInsert.setString(3, medicamento.getLaboratorio());
            prepInsert.setInt(4, medicamento.getCantidad());
            prepInsert.setDouble(5, medicamento.getPrecio());
            prepInsert.executeUpdate(); // ejecuta la sentencia

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String buscar(Connection connection, String parametro, String query) {

        try {
            // Buscar con Select adentro de la tabla
            String SQLSelect = "SELECT * FROM MEDICAMENTOS WHERE ? = ?";
            PreparedStatement prepSelect = connection.prepareStatement(SQLSelect);
            prepSelect.setString(1, parametro);
            prepSelect.setString(2, query);
            ResultSet rs = prepSelect.executeQuery(); // ejecuta la sentencia
            String res = null;
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String laboratorio = rs.getString("laboratorio");
                int cantidad = rs.getInt("cantidad");
                Double precio = rs.getDouble("precio");
                res = nombre + "-" + laboratorio + "-" + cantidad + "-" + precio;
            }
        String resultado = res;
            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        public boolean existe(Connection connection, String nombreMedicamento) {

        try {
            // Buscar el medicamento en la tabla y devolvemos booleano
            String SQLSelect = "SELECT * FROM MEDICAMENTOS WHERE nombre = ?";
            PreparedStatement prepSelect = connection.prepareStatement(SQLSelect);
            prepSelect.setString(1, nombreMedicamento);
            ResultSet rs = prepSelect.executeQuery(); // ejecuta la sentencia
            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
