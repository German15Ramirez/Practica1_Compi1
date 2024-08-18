package source.estructura;

public class Animacion {
    private String objeto;
    private String tipoAnimacion;
    private double param1;
    private double param2;
    private double param3;

    public Animacion(String objeto, String tipoAnimacion, double param1, double param2, double param3) {
        this.objeto = objeto;
        this.tipoAnimacion = tipoAnimacion;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    // Getters y setters

    @Override
    public String toString() {
        return "Animacion{" +
                "objeto='" + objeto + '\'' +
                ", tipoAnimacion='" + tipoAnimacion + '\'' +
                ", param1=" + param1 +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }
}
