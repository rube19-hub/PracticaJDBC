package modelo;

import java.util.ArrayList;

public class ListaPreguntas {

    private ArrayList<Pregunta> lista;

    public ListaPreguntas(ArrayList<Pregunta> lista) {
        this.lista = lista;
    }

    //(ArrayList<Pregunta> lista)
                                     //TODO="igual se puede quitar el parametro en el constructor"


    public ArrayList<Pregunta> getLista() {
        return lista;
    }

    public void setLista() {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaPreguntas{" +
                "lista=" + lista +
                '}';
    }
    //ListaPreguntas miLista = new ListaPreguntas();

}
