package source.frontend.graficar;

import javax.swing.*;

public class GrafRectangulo extends JPanel {
    private double inicialX;
    private double inicialY;
    private double ancho;
    private double alto;
    private String color;

    public GrafRectangulo(double posicionX, double posicionY, double ancho, double alto, String color) {
        this.inicialX = posicionX;
        this.inicialY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    public double getInicialX() {
        return inicialX;
    }

    public void setInicialX(double inicialX) {
        this.inicialX = inicialX;
    }

    public double getInicialY() {
        return inicialY;
    }

    public void setInicialY(double inicialY) {
        this.inicialY = inicialY;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
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
}
