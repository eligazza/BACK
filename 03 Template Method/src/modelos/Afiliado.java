package modelos;

public class Afiliado extends Vendedor {

    // CONSTRUCTOR
    public Afiliado(String nombre, int cantidadDeVentas, int puntaje) {
        super(nombre, cantidadDeVentas, puntaje);
    }

    // METODOS
    @Override
    public int calcularPuntos() {
        return this.getCantidadDeVentas() * 15;
    }

}
