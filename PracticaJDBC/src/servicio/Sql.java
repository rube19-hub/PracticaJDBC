package servicio;

import modelo.ListaPreguntas;
import modelo.Pregunta;
import repositorio.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static servicio.ServicioFichero.convertirATipoPregunta;

public class Sql {

    public static int ejecutar(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int datos = 0;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            datos = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return datos;
    }

    //Pregunta pregunta = new Pregunta("Enunciado1", new String[]{"opcion1 opcion2 opcion3 opcion4"}, "respuestacorrecta");

//    public String generarInsert (ListaPreguntas listaLlenaPreguntas){


//    public String generarInsert (Pregunta item){
//
//            String sql = String.format("INSERT INTO PREGUNTAS (ID, ENUNCIADO, CORRECTA) VALUES (NULL, '%s', '%s')",
//                    item.getEnunciado(),item.getCorrecta());
//
//        return sql;
//    }
//
//    public int insertarPregunta(Pregunta pregunta) throws SQLException {
//        String sql = generarInsert(pregunta);
//        return ejecutar(sql);
//    }

    public static List<String> generarInsert(ListaPreguntas listaLLPreguntas) {
        ArrayList<String> listaInsert = new ArrayList<>();
        String sql = "";
        for (Pregunta item : listaLLPreguntas.getLista()) {

            sql = String.format("INSERT INTO PREGUNTAS (ID, ENUNCIADO, CORRECTA) VALUES (NULL, '%s', '%s')",
                    item.getEnunciado(), item.getCorrecta());

            listaInsert.add(sql);
            System.out.println(sql);
        }
        return listaInsert;
    }

    public static void enviarALaBd(List<String> listaInsert){
        try {
            String sentenciaInsert = " ";
            for (String lineaInsert : listaInsert){

                sentenciaInsert = lineaInsert;

                ejecutar(sentenciaInsert);
            }
        }catch (SQLException e){
            System.err.println("Error al insertar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

//        public int insertarPregunta (Pregunta pregunta) throws SQLException {
//            String sql = generarInsert(pregunta);
//            return ejecutar(sql);
//        }