package servicios;

import modelos.Mail;

public class ManejadorTecnica extends Manejador {

    // ATRIBUTOS
    // CONSTRUCTOR
    // METODOS
    public void comprobar(Mail mail) {
        if(mail.getAsunto().contains("tecnica")){
            System.out.println("Este es un email para área técnica. Reenviando...");
            mail.setDestino("tecnica@colmena.com");
        }
        else {
            System.out.println("Este email no pertenece al área técnica, reenviando al área siguiente...");
            this.getSiguienteManejador().comprobar(mail); // si no lo puedo atender, llamo al siguiente nodo y le digo que lo atienda él
        }
    }

}
