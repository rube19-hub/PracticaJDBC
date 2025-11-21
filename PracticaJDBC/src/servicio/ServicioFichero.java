package servicio;

import modelo.ListaPreguntas;
import modelo.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class ServicioFichero {

    public static ListaPreguntas convertirATipoPregunta(List<String> listaPreguntasString) {

        int id = 0;
        String enunciado = "";
        String correcta = "";
        String espacioBlanco = "";

        ArrayList<Pregunta> preguntasI = new ArrayList<>();
        ListaPreguntas listaLlenaPreguntas = new ListaPreguntas(preguntasI);
        String[] opciones;

        for (int i = 0; i + 6 < listaPreguntasString.size(); i+=7) {

            opciones = new String[4];

            enunciado = listaPreguntasString.get(i);
            opciones[0] = listaPreguntasString.get(i+1);
            opciones[1] = listaPreguntasString.get(i+2);
            opciones[2] = listaPreguntasString.get(i+3);
            opciones[3] = listaPreguntasString.get(i+4);
            correcta = String.valueOf(listaPreguntasString.get(i + 5).charAt(8));
            espacioBlanco = listaPreguntasString.get(i+6);

            preguntasI.add(new Pregunta(id, enunciado,opciones, correcta));

        }
        return listaLlenaPreguntas;
    }
}
