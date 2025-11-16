package controlador;

import modelo.ListaPreguntas;
import repositorio.DBConnection;
import repositorio.Fichero;
import servicio.Sql;

import java.sql.SQLException;
import java.util.List;

import static servicio.ServicioFichero.convertirATipoPregunta;

public class Controlador {

    public static void iniciar(){

        Fichero miFichero = new Fichero("src/repositorio/Preguntas.txt");

        List<String> listaPreguntasString = miFichero.leerFichero();


        /*Parte del SQL - conecta a la bd*/
        try {
            DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ListaPreguntas tipoPreguntas = convertirATipoPregunta(listaPreguntasString);

        List<String> listaDeInserts = Sql.generarInsert(tipoPreguntas);

        Sql.enviarALaBd(listaDeInserts);

//        try {
//            Sql sql = new Sql();
//
//            for (i = 0; i < li)
//            String sentenciaInsert = sql.generarInsert(convertirATipoPregunta(listaPreguntasString));
//
//            sql.ejecutar(sentenciaInsert);
//
//        }catch (SQLException e){
//            System.err.println("Error al insertar: " + e.getMessage());
//            e.printStackTrace();
//        }


        //cierra la conexion
        DBConnection.closeConnection();
    }

//    Sql sql = new Sql();

//    public void enviarALaBd(List<String> listaPreguntasString){
//        try {
//            String sentenciaInsert;
//            for (int i = 0; i < )
//
//                sentenciaInsert = sql.generarInsert(convertirATipoPregunta(listaPreguntasString));
//
//            sql.ejecutar(sentenciaInsert);
//
//        }catch (SQLException e){
//            System.err.println("Error al insertar: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

}
