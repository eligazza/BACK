package servicios;

import modelos.Mail;

public class ManejadorSpam extends Manejador {

    // ATRIBUTOS
    // CONSTRUCTOR
    // METODOS
    public void comprobar(Mail mail) {
        System.out.println("Este email fue clasificado como spam.");
        mail.setDestino("Spam Folder");
    }
    // Getters & Setters

}
