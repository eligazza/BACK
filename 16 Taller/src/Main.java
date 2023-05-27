import ar.com.dh.dao.impl.DomicilioDaoH2;
import ar.com.dh.dao.impl.PacienteDaoH2;
import ar.com.dh.db.DbManager;
import ar.com.dh.model.Domicilio;
import ar.com.dh.model.Paciente;
import ar.com.dh.services.PacienteService;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Paciente pac01 = new Paciente("Arce","Alberto", "2385409", "hoy", new Domicilio("Wallaby", 1042, "Sydney", "Australia"));
        Paciente pac02 = new Paciente("Washington","Gercito", "23874982", "hoy", new Domicilio("Castrado", 134, "Sydney", "Australia"));

        PacienteService service = new PacienteService(new PacienteDaoH2(), new DomicilioDaoH2());
        try {
            DbManager.createTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Paciente paciente1 = service.guardar(pac01);
        System.out.println(paciente1);
        Paciente paciente2 = service.guardar(pac02);
        System.out.println(paciente2);
        service.borrar(1);
        System.out.println("SACALA DEL ANGULO, BOBO!");
    }
}