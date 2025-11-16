package modelo;

public class Respuesta {

    private String opcion_a;
    private String opcion_b;
    private String opcion_c;
    private String opcion_d;

    public Respuesta(String opcion_a, String opcion_b, String opcion_c, String opcion_d) {
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
    }

    public String getOpcion_a() {
        return opcion_a;
    }

    public void setOpcion_a(String opcion_a) {
        this.opcion_a = opcion_a;
    }

    public String getOpcion_b() {
        return opcion_b;
    }

    public void setOpcion_b(String opcion_b) {
        this.opcion_b = opcion_b;
    }

    public String getOpcion_c() {
        return opcion_c;
    }

    public void setOpcion_c(String opcion_c) {
        this.opcion_c = opcion_c;
    }

    public String getOpcion_d() {
        return opcion_d;
    }

    public void setOpcion_d(String opcion_d) {
        this.opcion_d = opcion_d;
    }
}
