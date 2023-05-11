package servicios;

import modelos.Mail;

public abstract class Manejador {

    // ATRIBUTOS
    private Manejador siguienteManejador;

    // CONSTRUCTOR

    // METODOS
    public abstract void comprobar(Mail mail);

    // Getters & Setters
    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }
    public void setSiguienteManejador(Manejador siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }
}
