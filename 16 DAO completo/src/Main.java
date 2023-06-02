import dao.implementations.KinesiologoDaoH2;
import models.Kinesiologo;
import services.KinesiologoService;

public class Main {
    public static void main(String[] args) {

        // ESTOS ERAN LOS REQUERIMIENTOS
        // Usar constructor con parámetros
            //Kinesiologo kinesio1 = new Kinesiologo("Sylvan", "Crucifijo", 1988, true);
        // Usar constructor y setear atributos
            //Kinesiologo kinesio2 = new Kinesiologo();
            //kinesio2.setNombre("Elias");
            //kinesio2.setApellido("Gazza");
            //kinesio2.setAnioNacimiento(1991);
            //kinesio2.setAtiendeObraSocial(true);

        // tener un servicio que me permita agregar/listarTodos/buscarPorNombreYApellido/borrar kinesiolgos
            //KinesiologoService service = new KinesiologoService(new KinesiologoDaoH2());

        // TODO hacer el DaoArray
            // KinesiologoDaoArray arraydb = new KinesiologoDaoArray();
            // KinesiologoService service2 = new KinesiologoService(arraydb);

        //serviceH2.agregar(kinesio1);
        //serviceH2.agregar(kinesio2);
        //serviceH2.listarTodos();
        //serviceH2.buscarPorNombreYApellido("Elias", "Gazza");
        //serviceH2.borrar(1);
        //serviceH2.listarTodos();


    }
}