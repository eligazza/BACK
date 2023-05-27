package ar.com.dh.model;

public class Paciente {

    // ATRIBUTOS
    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private String fecha;
    private Domicilio domicilio;

    // CONSTRUCTOR
    public Paciente(String apellido, String nombre, String dni, String fecha, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fecha = fecha;
        this.domicilio = domicilio;
    }

    public Paciente() {

    }

    // METODOS UTILES
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha='" + fecha + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


}
