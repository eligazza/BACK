package ar.com.dh.model;

public class IPCliente {

    // ATRIBUTOS
    private int[] octeto = new int[4];

    // CONSTRUCTOR
    public IPCliente(int nro1, int nro2, int nro3, int nro4) {
        this.octeto[0] = nro1; //este es el que identifica el pais
        this.octeto[1] = nro2;
        this.octeto[2] = nro3;
        this.octeto[3] = nro4;
    }

    // METODOS
    public String getPais() {
        if (octeto[0] <= 49) {
            return "Argentina";
        } else if (octeto[0] <= 99) {
            return "Brazil";
        } else if (octeto[0] <= 149) {
            return "Colombia";
        }
        else return "Pais no encontrado";
    }

    // Getters & Setters

}

