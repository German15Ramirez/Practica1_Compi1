package source.backend.Figuras;
import java.awt.*;

public class Cuadrado extends Figura {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private double tamano;
    private String color;

    public Cuadrado(String nombre, double posicionX, double posicionY, double tamano, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tamano = tamano;
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

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamanoLado) {
        this.tamano = tamanoLado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("Grafica de Cuadrado");
    }


}
