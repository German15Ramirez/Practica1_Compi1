package source.backend.Figuras;
import java.awt.*;
public class Poligono  extends Figura {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private int cantidadLados;
    private double ancho;
    private double alto;
    private String color;

    public Poligono(String nombre, double posicionX, double posicionY, int cantidadLados, double ancho, double alto, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.cantidadLados = cantidadLados;
        this.ancho = ancho;
        this.alto = alto;
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

    public int getCantidadLados() {
        return cantidadLados;
    }

    public void setCantidadLados(int cantidadLados) {
        this.cantidadLados = cantidadLados;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("Grafica de Poligono");
    }
}
