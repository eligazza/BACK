package models;

public class Kinesiologo {

    // ATRIBUTOS
    private int id;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    private boolean atiendeObraSocial;

    // CONSTRUCTORES
    public Kinesiologo() {}
    public Kinesiologo(String nombre, String apellido, int anioNacimiento, boolean atiendeObraSocial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
        this.atiendeObraSocial = atiendeObraSocial;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getAnioNacimiento() {
        return anioNacimiento;
    }
    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }
    public boolean getAtiendeObraSocial() {
        return atiendeObraSocial;
    }
    public void setAtiendeObraSocial(boolean atiendeObraSocial) {
        this.atiendeObraSocial = atiendeObraSocial;
    }


    //
}
