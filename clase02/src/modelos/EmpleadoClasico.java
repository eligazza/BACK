package modelos;

public class EmpleadoClasico extends Empleado {

    // ATRIBUTOS
    // CONSTRUCTOR
    // Getters & Setters
    // METODOS

    @Override
    protected void armarMenu() {
        System.out.println("PREPARACION MENU CLASICO:");
        System.out.println("Colocar la hamburguesa, las papas y la gaseosa en una bolsa");
    }

    @Override
    protected void calcularPrecio() {
         setPrecioFinal(1000.00);
    }
}
