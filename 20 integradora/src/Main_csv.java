import ar.com.dh.model.Empleado;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main_csv {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Pablo", "Vidal", "1", 1000);
        Empleado empleado2 = new Empleado("Vanina", "Simon", "2", 2000);
        Empleado empleado3 = new Empleado("Franco", "Gonzalo", "3", 3000);
        Empleado empleado4 = new Empleado("Elias", "nnn", "4", 4000);

        try {

            FileWriter fileWriter = new FileWriter("empleados.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Empleado e : Arrays.asList(empleado1, empleado2, empleado3, empleado4)) {
                printWriter.println(e.getCSV());
            }

            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}