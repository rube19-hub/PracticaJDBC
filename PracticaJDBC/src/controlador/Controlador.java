package controlador;

import modelo.ListaPreguntas;
import repositorio.DBConnection;
import repositorio.Fichero;
import servicio.Sql;
import vista.Consola;

import java.sql.SQLException;
import java.util.List;

import static servicio.ServicioFichero.convertirATipoPregunta;

public class Controlador {

    public static void iniciar() {

        Fichero miFichero = new Fichero("src/repositorio/Preguntas.txt");
        List<String> listaPreguntasString = miFichero.leerFichero();

        //le entra un lista de strings y crea y devuelve una lista de preguntas
        ListaPreguntas tipoPreguntas = convertirATipoPregunta(listaPreguntasString);

        //le entra una lista de preguntas y va creando una lista de strings con inserts
        List<String> listaDeInserts = Sql.generarInsert(tipoPreguntas);

        //envia todos los inserts a la BD
        Sql.enviarALaBd(listaDeInserts);

        //pregunta al usuario un numero de preguntas
        int numerin = Consola.pedirNumeroPreguntas();

        //crea una lista con las preguntas que se le van a dar al usuario

        ListaPreguntas listaConRandom = null;
        try {
            listaConRandom = Sql.selectPreguntasAleatorias(numerin);
        } catch (SQLException e) {
            System.err.println("Excepción capturada: ");
            e.printStackTrace();
        }

        //al usuario le van apareciendo las preguntas y las va resolviendo
        Consola.resolverPregunta(listaConRandom);
        
        //cierra la conexion
        DBConnection.closeConnection();
    }
}
