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
        //String[] opciones = new String[4];        //TODO= porque se me guarda solo las opciones de la ultima pregunta
        String espacioBlanco = "";

        ArrayList<Pregunta> preguntasI = new ArrayList<>();
        ListaPreguntas listaLlenaPreguntas = new ListaPreguntas(preguntasI);

        for (int i = 0; i + 6 < listaPreguntasString.size(); i+=7) {

            String[] opciones = new String[4];

            enunciado = listaPreguntasString.get(i);
            //System.out.println(enunciado);

            opciones[0] = listaPreguntasString.get(i+1);
            //System.out.println(opciones[0]);

            opciones[1] = listaPreguntasString.get(i+2);
            //System.out.println(opciones[1]);

            opciones[2] = listaPreguntasString.get(i+3);
            //System.out.println(opciones[2]);

            opciones[3] = listaPreguntasString.get(i+4);
            //System.out.println(opciones[3]);

            correcta = String.valueOf(listaPreguntasString.get(i + 5).charAt(8));
            //System.out.println(correcta);

            espacioBlanco = listaPreguntasString.get(i+6);
            //System.out.println(espacioBlanco);

            Pregunta pregunta = new Pregunta(id, enunciado,opciones, correcta) ;

            preguntasI.add(pregunta);

        }

        //System.out.println(listaLlenaPreguntas);
        return listaLlenaPreguntas;
    }


}
