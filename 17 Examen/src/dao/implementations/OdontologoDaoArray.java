package dao.implementations;

import dao.DAO;
import models.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoArray implements DAO<Odontologo> {

    // ATRIBUTOS
    private static final Logger LOG = Logger.getLogger(OdontologoDaoArray.class);
    private List<Odontologo> baseDeDatosArray;

    // CONSTRUCTOR
    public OdontologoDaoArray() {
        this.baseDeDatosArray = new ArrayList<>();
    }

    // Getter
    public List<Odontologo> getBaseDeDatosArray() {
        return baseDeDatosArray;
    }

    // MÉTODOS
    @Override
    public void registrar(Odontologo odontologo) {
        this.baseDeDatosArray.add(odontologo);
        odontologo.setId(baseDeDatosArray.indexOf(odontologo) + 1);
        LOG.info("Se agregó <" + odontologo.getApellido() + ", " + odontologo.getNombre() + "> al registro. Se le asignó el ID: " + odontologo.getId() );
    }

    @Override
    public List<Odontologo> listarTodos() {
        System.out.println(baseDeDatosArray.toString());
        return baseDeDatosArray;
    }
}
