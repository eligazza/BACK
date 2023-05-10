package modelos;

public class EmpleadoVeggie extends Empleado {

    // ATRIBUTOS
    private boolean tieneEspecias;
    private int cantidadSalsas;

    // CONSTRUCTOR
    public EmpleadoVeggie(boolean tieneEspecias, int cantidadSalsas) {
        this.tieneEspecias = tieneEspecias;
        this.cantidadSalsas = cantidadSalsas;
    }

    // Getters & Setters
    public boolean isTieneEspecias() {
        return tieneEspecias;
    }
    public void setTieneEspecias(boolean tieneEspecias) {
        this.tieneEspecias = tieneEspecias;
    }
    public int getCantidadSalsas() {
        return cantidadSalsas;
    }
    public void setCantidadSalsas(int cantidadSalsas) {
        this.cantidadSalsas = cantidadSalsas;
    }

    // METODOS

    @Override
    protected void armarMenu() {
        System.out.println("PREPARACION MENU VEGGIE:");
        System.out.println("Colocar la hamburguesa, las papas y la gaseosa");
        if (tieneEspecias) {
            System.out.println("Agregar especias");
        }
        if (cantidadSalsas > 0) {
            System.out.println("Agregar " + cantidadSalsas + " salsas");
        }
    }

    @Override
    protected void calcularPrecio() {
        double precioCalculado = getPrecioBase();
        if (cantidadSalsas > 0) {
            precioCalculado += 2*cantidadSalsas;
        }
        if (tieneEspecias) {
            precioCalculado += 0.01 * precioCalculado;
        }
        setPrecioFinal(precioCalculado);
    }
}
