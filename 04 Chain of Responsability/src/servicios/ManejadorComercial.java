package servicios;

import modelos.Mail;

public class ManejadorComercial extends Manejador {

    // ATRIBUTOS
    // CONSTRUCTOR
    // METODOS
    public void comprobar(Mail mail) {
        if(mail.getAsunto().contains("comercial")){
            System.out.println("Este es un email para área comercial. Reenviando...");
            mail.setDestino("comercial@colmena.com");
        }
        else {
            System.out.println("Este email no pertenece a comercial, reenviando al área siguiente...");
            this.getSiguienteManejador().comprobar(mail); // si no lo puedo atender, llamo al siguiente nodo y le digo que lo atienda él
        }
    }

}
