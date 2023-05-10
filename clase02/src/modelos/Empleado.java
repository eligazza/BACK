package modelos;

public abstract class Empleado {

    // ATRIBUTOS
    private double precioBase = 1000.00;
    private double precioFinal;

    // CONSTRUCTOR


    // Getters & Setters
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public double getPrecioFinal() {
        return precioFinal;
    }
    protected void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    // METODOS
    public void prepararMenu() {
        armarMenu();
        calcularPrecio();
    }
    protected abstract void armarMenu();
    protected abstract void calcularPrecio();

}
