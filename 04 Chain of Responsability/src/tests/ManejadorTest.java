package tests;

import modelos.Mail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicios.ServicioComprobacion;

class ManejadorTest {

    @Test
    void test_mail_para_gerencia() {

        //Arrange
        ServicioComprobacion servicio = new ServicioComprobacion();
        Mail correo01 = new Mail("persona01@gmail.com","info@gmail.com", "Necesito hablar con gerencia");
        String expectativa = "gerencia@colmena.com";

        //Act
        servicio.recibir(correo01);
        String realidad = correo01.getDestino();

        //Assert
        Assertions.assertEquals(expectativa, realidad);

    }

    @Test
    void test_mail_para_comercial() {

        //Arrange
        ServicioComprobacion servicio = new ServicioComprobacion();
        Mail correo02 = new Mail("persona02@gmail.com","info@gmail.com", "Necesito hablar con el area comercial");
        String expectativa = "comercial@colmena.com";

        //Act
        servicio.recibir(correo02);
        String realidad = correo02.getDestino();

        //Assert
        Assertions.assertEquals(expectativa, realidad);

    }

    @Test
    void test_mail_para_tecnica() {

        //Arrange
        ServicioComprobacion servicio = new ServicioComprobacion();
        Mail correo03 = new Mail("persona03@gmail.com","info@gmail.com", "Necesito hablar con alguien del área tecnica");
        String expectativa = "tecnica@colmena.com";

        //Act
        servicio.recibir(correo03);
        String realidad = correo03.getDestino();

        //Assert
        Assertions.assertEquals(expectativa, realidad);

    }

    @Test
    void test_mail_spam() {

        //Arrange
        ServicioComprobacion servicio = new ServicioComprobacion();
        Mail correo04 = new Mail("persona04@gmail.com","info@gmail.com", "Tienes una herencia esperando");
        String expectativa = "Spam Folder";

        //Act
        servicio.recibir(correo04);
        String realidad = correo04.getDestino();

        //Assert
        Assertions.assertEquals(expectativa, realidad);

    }
}