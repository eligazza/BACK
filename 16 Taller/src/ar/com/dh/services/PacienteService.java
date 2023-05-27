package ar.com.dh.services;

import ar.com.dh.dao.IDao;
import ar.com.dh.model.Domicilio;
import ar.com.dh.model.Paciente;

public class PacienteService {

    // ATRIBUTOS
    private IDao<Paciente> pacienteIDao;
    private IDao<Domicilio> domicilioIDao;

    // CONSTRUCTOR
    public PacienteService(IDao<Paciente> pacienteIDao, IDao<Domicilio> domicilioIDao) {
        this.pacienteIDao = pacienteIDao;
        this.domicilioIDao = domicilioIDao;
    }

    public Paciente guardar(Paciente paciente) {
        domicilioIDao.guardar(paciente.getDomicilio());
        return pacienteIDao.guardar(paciente);
    }

    public Paciente borrar(Integer id) {
        domicilioIDao.borrar(id);
        return pacienteIDao.borrar(id);
    }

}
