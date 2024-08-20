package source.backend.Figuras;
import java.awt.*;

public class Circulo extends Figura {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private double radio;
    private String color;

    public Circulo(String nombre, double posicionX, double posicionY, double radio, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.radio = radio;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("Grafica de Circulo");
    }
}
