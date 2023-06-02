import ar.com.dh.model.Empleado;
import ar.com.dh.model.Empresa;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ARMAMOS UNA EMPRESA
        Empresa empresa = new Empresa();
        empresa.setRazonSocial("C2 S.A");
        empresa.setCuit("11");

        // CREAMOS 4 EMPLEADOS
        Empleado empleado1 = new Empleado("Pablo", "Vidal", "1", 1000);
        Empleado empleado2 = new Empleado("Vanina", "Simon", "2", 2000);
        Empleado empleado3 = new Empleado("Franco", "Gonzalo", "3", 3000);
        Empleado empleado4 = new Empleado("Elias", "nnn", "4", 4000);

        // CREAMOS UNA LISTA CON LOS 4 EMPLEADOS Y LA SETEAMOS EN LA EMPRESA
        empresa.getListaEmpleados().add(empleado1);
        empresa.getListaEmpleados().add(empleado2);
        empresa.getListaEmpleados().add(empleado3);
        empresa.getListaEmpleados().add(empleado4);

        // PREPARO LA SALIDA Empresa -> File
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("empresa.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOutputStream);
            objectOut.writeObject(empresa);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // VOY A RECUPERAR EL ARCHIVO
        Empresa empresaRecuperada = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("empresa.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            empresaRecuperada = (Empresa)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Se supone que ya tengo al objeto de tipo Empresa adentro de la variable "empresaRecuperada"
        // Por eso debería poder acceder a sus atributos y métodos.
        for (Empleado empleado : empresaRecuperada.getListaEmpleados()) {
            System.out.println(empleado.toString());
        }
    }
}