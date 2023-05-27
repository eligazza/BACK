package dao;

import modelos.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDAOH2 implements DAO {

    // ATRIBUTOS
    public static final String URL = "jdbc:h2:~/farmacia;INIT=RUNSCRIPT from './Farmacia/create_table.sql'";
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";
    private static final Logger LOG = Logger.getLogger(MedicamentoDAOH2.class);
    // MÉTODO UTIL
    public Connection levantarConexion(){
        Connection connection = null;
        try {
            Class.forName(H2DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(e.getMessage());
        }
        return connection;
    }

    // MÉTODOS DE LA INTERFAZ
    @Override
    public int registrar(Medicamento medicamento) {

        int id = 0;
        Connection connection = levantarConexion();

        // Preparo un statement y le cargo los atributos que vienen por parámetro
        try {
            String SQLInsert = "INSERT INTO MEDICAMENTOS (CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES(?,?,?,?,?)";
            PreparedStatement prepstmt = connection.prepareStatement(SQLInsert,Statement.RETURN_GENERATED_KEYS);

            //Le cargo los valores al modelito con un registro particular
            prepstmt.setInt(1, medicamento.getCodigo());
            prepstmt.setString(2, medicamento.getNombre());
            prepstmt.setString(3, medicamento.getLaboratorio());
            prepstmt.setInt(4, medicamento.getCantidad());
            prepstmt.setDouble(5, medicamento.getPrecio());
            int filasObtenidas = prepstmt.executeUpdate(); // ejecuta el sql
            if (filasObtenidas>0) {
                ResultSet rs = prepstmt.getGeneratedKeys();
                while(rs.next()) {
                    id = rs.getInt(1);
                }
            }
            // Loggeo y cierro la conexión
            LOG.info("Se registró " + medicamento.getNombre() + " correctamente");
            prepstmt.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return id;

    }

    @Override
    public Medicamento buscar(int idBuscado) {

        //PREPARO EL RETORNO
        Medicamento medicamentoResponse = null;
        Connection connection = levantarConexion();

        // HAGO LA BUSQUEDA Y LA GUARDO COMO UN OBJETO NUEVO
        try {
            //  Preparo el statement, lo ejecuto y guardo el resultado
            PreparedStatement prepstmt = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
            prepstmt.setInt(1, idBuscado);
            ResultSet rs = prepstmt.executeQuery();
            // Itero el resulset y le obtengo la información columna a columna, metiendola en un objeto nuevo
            while (rs.next()) {
                int id = rs.getInt(1); // Ahora la columna 1 es del ID que pone la bbdd
                int codigo = rs.getInt(2);
                String name = rs.getString(3);
                String laboratorio = rs.getString(4);
                int cantidad = rs.getInt(5);
                double precio = rs.getDouble(6);
                LOG.info("Se ha buscado " + idBuscado + " en la base de datos");
                medicamentoResponse = new Medicamento(codigo, name, laboratorio, cantidad, precio);
                medicamentoResponse.setId(id);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return medicamentoResponse;
    }
}
