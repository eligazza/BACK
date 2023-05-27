package entidades;

public class Domicilio {

    // ATRIBUTOS
    private int id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    // CONSTRUCTOR
    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
