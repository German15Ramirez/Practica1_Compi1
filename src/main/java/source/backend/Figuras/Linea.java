package source.backend.Figuras;
import java.awt.*;

public class Linea extends Figura {
    private String nombre;
    private double posicionInicialX;
    private double posicionInicialY;
    private double posicionFinalX;
    private double posicionFinalY;
    private String color;

    public Linea(String nombre, double posicionInicialX, double posicionInicialY, double posicionFinalX, double posicionFinalY, String color) {
        this.nombre = nombre;
        this.posicionInicialX = posicionInicialX;
        this.posicionInicialY = posicionInicialY;
        this.posicionFinalX = posicionFinalX;
        this.posicionFinalY = posicionFinalY;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionInicialX() {
        return posicionInicialX;
    }

    public void setPosicionInicialX(double posicionInicialX) {
        this.posicionInicialX = posicionInicialX;
    }

    public double getPosicionInicialY() {
        return posicionInicialY;
    }

    public void setPosicionInicialY(double posicionInicialY) {
        this.posicionInicialY = posicionInicialY;
    }

    public double getPosicionFinalX() {
        return posicionFinalX;
    }

    public void setPosicionFinalX(double posicionFinalX) {
        this.posicionFinalX = posicionFinalX;
    }

    public double getPosicionFinalY() {
        return posicionFinalY;
    }

    public void setPosicionFinalY(double posicionFinalY) {
        this.posicionFinalY = posicionFinalY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("Grafico de Linea");
    }
}
