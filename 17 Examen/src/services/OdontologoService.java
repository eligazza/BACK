package services;

import dao.DAO;
import dao.implementations.OdontologoDaoH2;
import models.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoService {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(OdontologoService.class);
    private DAO<Odontologo> estrategia;

    // CONSTRUCTOR
    public OdontologoService(DAO<Odontologo> estrategia) {
        this.estrategia = estrategia;
    }

    // METODOS
    public void registrar(Odontologo odontologo) {
        // todo escrbirlo para que contemple nombres/apellidos compuestos
        // Primera letra del nombre en mayúsculas
        String inicialN = odontologo.getNombre().substring(0,1);
        String restoN = odontologo.getNombre().substring(1);
        odontologo.setNombre(inicialN.toUpperCase() + restoN.toLowerCase());
        // Primera letra del apellido en mayúsculas
        String inicialA = odontologo.getApellido().substring(0,1);
        String restoA = odontologo.getApellido().substring(1);
        odontologo.setApellido(inicialA.toUpperCase() + restoA.toLowerCase());

        if (odontologo.getMatricula() >0 && odontologo.getMatricula() <= 10000 ) {
            estrategia.registrar(odontologo);
        } else {
            LOG.error("El número de matrícula debe estar entre 0 y 10000");
        }
    }

    public List<Odontologo> listarTodos() {
        return estrategia.listarTodos();
    }

}
