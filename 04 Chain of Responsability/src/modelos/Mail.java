package modelos;

public class Mail {

    // ATRIBUTOS
    private String origen;
    private String destino;
    private String asunto;

    // CONSTRUCTOR
    public Mail(String origen, String destino, String asunto) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
    }

    // METODOS

    // Getters & Setters
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
