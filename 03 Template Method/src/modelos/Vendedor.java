package modelos;

public abstract class Vendedor {

    // ATRIBUTOS
    private String nombre;
    private int cantidadDeVentas;
    private int puntaje;

    // CONSTRUCTOR
    public Vendedor(String nombre, int cantidadDeVentas, int puntaje) {
        this.nombre = nombre;
        this.cantidadDeVentas = cantidadDeVentas;
        this.puntaje = puntaje;
    }

    // METODOS
    public void cerrarVenta() {
        this.cantidadDeVentas++;
    }

    public String mostrarCategoria() {
        String nombre = this.getNombre();
        String categoria = this.getCategoria();
        int puntos = this.calcularPuntos();
        return ("VENDEDOR " + nombre + ": " + categoria + "(" + puntos + " puntos)");
    }
    private String getCategoria(){
        int puntos = calcularPuntos();
        if(puntos < 20) {return "Novato";}
        else if (puntos >= 20 && puntos <= 30) {return "Aprendiz";}
        else if (puntos > 30 && puntos <= 40) {return "Bueno";}
        else if (puntos > 40) {return "Maestro";}
        return "Sin categoria";
    }

    public abstract int calcularPuntos();

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadDeVentas() {
        return cantidadDeVentas;
    }
    public void setCantidadDeVentas(int cantidadDeVentas) {
        this.cantidadDeVentas = cantidadDeVentas;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
