package vista;

import modelo.ListaPreguntas;
import modelo.Pregunta;

public class Consola {

    public static int pedirNumeroPreguntas(){

        int numeroPreguntas = Escaner.leerEntero("Elige el número de preguntas que quieres: ");
        return numeroPreguntas;
    }

    public static void resolverPregunta(ListaPreguntas preguntasAleatorias){

        String respuestaUsuario;
        int contadorPreguntas = 0;
        int contadorCorrectas = 0;

        for (Pregunta pregunta : preguntasAleatorias.getLista()){
            contadorPreguntas ++;

            System.out.println("Escribe la letra de la respuesta coreccta. No importa si es mayúscula o minúscula.");
            System.out.println(pregunta.getEnunciado());
            System.out.println(pregunta.getOpciones()[0]);
            System.out.println(pregunta.getOpciones()[1]);
            System.out.println(pregunta.getOpciones()[2]);
            System.out.println(pregunta.getOpciones()[3]);

            respuestaUsuario = Escaner.leerTexto("¿Cual crees que es la respuesta correcta?");

            if (pregunta.getCorrecta().equalsIgnoreCase(respuestaUsuario)){
                System.out.println("Respuesta correcta.");
                contadorCorrectas++;
            }else {
                System.out.println("Respuesta incorrecta. La respuesta correcta es la "+ pregunta.getCorrecta());
            }
        }
        System.out.println("");
        System.out.println("Has acertado "+contadorCorrectas+" de "+contadorPreguntas+ " preguntas.");
    }
}
