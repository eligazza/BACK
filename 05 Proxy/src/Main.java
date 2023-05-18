import ar.com.dh.model.Persona;
import ar.com.dh.service.Registro;
import ar.com.dh.service.RegistroVacunaProxy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona(1111, "vidal", "Pablo",
                new Date(2023, 05, 13, 0, 0), "gripal");
        Registro registro = new RegistroVacunaProxy();
        registro.vacunar(persona);


    }
}