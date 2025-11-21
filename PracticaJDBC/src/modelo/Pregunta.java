package modelo;

import java.util.Arrays;

public class Pregunta {

    private int id;
    private String enunciado ;
    private String[] opciones;
    private String correcta;

    public Pregunta(int id, String enunciado, String[] opciones, String correcta) {
        this.id = id;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id='" + id + '\'' +
                ", enunciado=" + enunciado +
                ", opciones='" + Arrays.toString(opciones) + '\'' +
                ", correcta=" + correcta +
                '}';
    }
}
