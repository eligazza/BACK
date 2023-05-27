package daos;

import entidades.Paciente;
import org.apache.log4j.Logger;
import servicios.PacienteService;

import java.sql.*;

public class PacienteDAOH2 implements DAO<Paciente>{

    // ATRIBUTOS
    public static final String URL = "jdbc:h2:~/clinica;INIT=RUNSCRIPT from 'create_table.sql'";
    public static final String H2DRIVER = "org.h2.Driver";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";
    private static final Logger LOG = Logger.getLogger(PacienteDAOH2.class);

    // METODOS UTILES
    public Connection levantarConexion() {

        Connection connection = null;
        try {
            Class.forName(H2DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return connection;
    }

    public void imprimirTodosPacientes() {
        Connection connection = levantarConexion();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PACIENTES");
            while (rs.next()) {
                Paciente pacienteResponse = new Paciente();
                pacienteResponse.setId(rs.getInt(1));
                pacienteResponse.setApellido(rs.getString(2));
                pacienteResponse.setNombre(rs.getString(3));
                pacienteResponse.setDni(rs.getString(4));
                pacienteResponse.setFechaIngreso(rs.getString(5));
                System.out.println(pacienteResponse.toString());
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("NO ANDUVO EL METODO IMPRIMIR TODO");;
        }

    }

    @Override
    public boolean guardar(Paciente paciente) {

        boolean resultado = false;
        // CREAR LA TABLA Y CONECTARSE
        Connection connection = levantarConexion();

        // HACER LA SQL Y EJECUTAR
        try {
            // preparo
            String SQLInsert = "INSERT INTO PACIENTES (APELLIDO, NOMBRE, DNI, FECHAINGRESO) VALUES(?,?,?,?)";
            PreparedStatement prepstmt = connection.prepareStatement(SQLInsert);
            // relleno las incógnitas
            prepstmt.setString(1, paciente.getApellido());
            prepstmt.setString(2, paciente.getNombre());
            prepstmt.setString(3, paciente.getDni());
            prepstmt.setString(4, paciente.getFechaIngreso());
            // ejecuto y me desconecto
            int cantidadDeInserciones = prepstmt.executeUpdate();
            LOG.info("Se insertó/insertaron " + cantidadDeInserciones + " registros");
            prepstmt.close();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    @Override
    public Paciente buscar(int id) {

        // CONECTARNOS Y CREO EL PACIENTE QUE LUEGO RETORNARÉ
        Connection connection = levantarConexion();
        Paciente pacienteResponse = new Paciente();

        // EJECUTAR EL SELECT
        try {
            // preparo el statement
            String SQLSelect = "SELECT * FROM PACIENTES WHERE ID = ?";
            PreparedStatement prpstmt = connection.prepareStatement(SQLSelect);
            // seteo lo que busco
            prpstmt.setInt(1, id);
            // me traigo el resultado y lo pongo en un paciente
            ResultSet rs = prpstmt.executeQuery();
            while (rs.next()) {
                pacienteResponse.setId(rs.getInt(1));
                pacienteResponse.setApellido(rs.getString(2));
                pacienteResponse.setNombre(rs.getString(3));
                pacienteResponse.setDni(rs.getString(4));
                pacienteResponse.setFechaIngreso(rs.getString(5));
            }
            // cierro la conexión
            prpstmt.close();
            LOG.info("Se consultó por el paciente " + pacienteResponse.getApellido());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // RETORNAR EL PACIENTE
        return pacienteResponse;
    }
}
