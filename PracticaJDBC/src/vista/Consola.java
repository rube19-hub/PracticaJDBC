package vista;

public class Consola {

    static int numeroPreguntas = 0;

    public static void pedirNumeroPreguntas(){
        numeroPreguntas = Escaner.leerEntero("Elige el número de preguntas que quieres: ");
    }

}
