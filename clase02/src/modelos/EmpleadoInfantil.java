package modelos;

public class EmpleadoInfantil extends Empleado {

    // ATRIBUTOS
    private int cantidadJuguetes;

    // CONSTRUCTOR
    public EmpleadoInfantil(int cantidadJuguetes) {
        this.cantidadJuguetes = cantidadJuguetes;
    }

    // Getters & Setters
    public int getCantidadJuguetes() {
        return cantidadJuguetes;
    }
    public void setCantidadJuguetes(int cantidadJuguetes) {
        this.cantidadJuguetes = cantidadJuguetes;
    }

    // METODOS

    @Override
    protected void armarMenu() {
        System.out.println("PREPARACION MENU INFANTIL:");
        System.out.println("Colocar la hamburguesa, las papas y la gaseosa");
        System.out.println("Agregar " + cantidadJuguetes + " jueguete/s");
    }

    @Override
    protected void calcularPrecio() {
        setPrecioFinal(getPrecioBase() + 3*cantidadJuguetes);
    }

}
