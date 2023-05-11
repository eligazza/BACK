package servicios;

import modelos.Mail;

public class ManejadorGerencia extends Manejador {

    // ATRIBUTOS
    // CONSTRUCTOR
    // METODOS
    public void comprobar(Mail mail) {
        if(mail.getAsunto().contains("gerencia")){
            System.out.println("Este es un email para gerencia. Reenviando...");
            mail.setDestino("gerencia@colmena.com");
        }
        else {
            System.out.println("Este email no pertenece a gerencia, reenviando al área siguiente...");
            this.getSiguienteManejador().comprobar(mail); // si no lo puedo atender, llamo al siguiente nodo y le digo que lo atienda él
        }
    }

    // Getters & Setters
}
