package servicios;

import modelos.Mail;

public class ServicioComprobacion {

    // ATRIBUTO
    private final Manejador eslabonInicial;

    // CONSTRUCTOR
    public ServicioComprobacion() {

        // instancio los eslabones
        Manejador gerencia = new ManejadorGerencia();
        Manejador comercial = new ManejadorComercial();
        Manejador tecnica = new ManejadorTecnica();
        Manejador spam = new ManejadorSpam();

        // Setear el inicio
        this.eslabonInicial = gerencia;

        // Asignar la secuencia
        gerencia.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnica);
        tecnica.setSiguienteManejador(spam);
    }

    // METODOS
    public void recibir(Mail mail){
        eslabonInicial.comprobar(mail);
    }

}
