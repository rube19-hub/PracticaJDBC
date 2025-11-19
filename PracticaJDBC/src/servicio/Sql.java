package servicio;

import modelo.ListaPreguntas;
import modelo.Pregunta;
import repositorio.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        } //finally {
//            if (conn != null) {
//                conn.close();
//            }
//        }
        return datos;
    }
/*
"SELECT * FROM preguntas ORDER BY RAND() LIMIT " + numeroPreguntas + ";";
    SELECT P.ID, P.ENUNCIADO, P.CORRECTA, R.OPCION_A, R.OPCION_B, R.OPCION_C, R.OPCION_D, R.PREGUNTA_ID ORDER BY RAND() LIMIT " + numeroPreguntas + ";"
    FROM PREGUNTAS P INNER JOIN RESPUESTAS R
    ON P.ID = R.PREGUNTA_ID
*/
    public static ListaPreguntas selectPreguntasAleatorias(int numeroPreguntas) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rst = null;
        String sql = "SELECT p.ID, p.ENUNCIADO, p.CORRECTA, r.OPCION_A, r.OPCION_B, r.OPCION_C, r.OPCION_D \n" +
                     "FROM preguntas p INNER JOIN respuestas r ON p.ID = r.PREGUNTA_ID \n" +
                     "ORDER BY RAND() LIMIT " + numeroPreguntas + ";";

        ArrayList<Pregunta> listilla = new ArrayList<>();
        //ListaPreguntas preguntasAleatorias = new ListaPreguntas(listilla);

        int id;
        String enunciado = "";
        String correcta = "";

        Pregunta pregunta = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rst = stmt.executeQuery();

            while (rst.next()) {

                String[] opciones = new String[4];

                id = rst.getInt("ID");
                enunciado = rst.getString("ENUNCIADO");
                correcta = rst.getString("CORRECTA");
                opciones[0] = rst.getString("OPCION_A");
                opciones[1] = rst.getString("OPCION_B");
                opciones[2] = rst.getString("OPCION_C");
                opciones[3] = rst.getString("OPCION_D");

                pregunta = new Pregunta(id, enunciado, opciones, correcta);
                listilla.add(pregunta);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        //ListaPreguntas preguntasAleatorias = new ListaPreguntas(listilla);
        return new ListaPreguntas(listilla);
    }


    public static List<String> generarInsert(ListaPreguntas listaLLPreguntas) {
        ArrayList<String> listaInsert = new ArrayList<>();
        String sql = "";
        for (Pregunta item : listaLLPreguntas.getLista()) {

            sql = String.format("INSERT INTO PREGUNTAS (ID, ENUNCIADO, CORRECTA) VALUES ('%d', '%s', '%s')",
                    item.getId(), item.getEnunciado(), item.getCorrecta());
            //System.out.println(sql);
            listaInsert.add(sql);
            //System.out.println(sql);

            sql = String.format("INSERT INTO RESPUESTAS (OPCION_A, OPCION_B, OPCION_C, OPCION_D) VALUES ('%s', '%s', '%s', '%s')",
                    item.getOpciones()[0], item.getOpciones()[1], item.getOpciones()[2], item.getOpciones()[3]);

                                                        //TODO= en el insert tengo que poner tambien el id
            listaInsert.add(sql);
            //System.out.println(sql);
        }
        return listaInsert;
    }



    public static void enviarALaBd(List<String> listaInsert){
        try {
            String sentenciaInsert = " ";
            ejecutar("DELETE FROM PREGUNTAS");
            ejecutar("DELETE FROM RESPUESTAS");

            for (String lineaInsert : listaInsert){

                sentenciaInsert = lineaInsert;

                ejecutar(sentenciaInsert);
            }
        }catch (SQLException e){
            System.err.println("Error al insertar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //SELECT * FROM preguntas ORDER BY RAND() LIMIT 3;


}
