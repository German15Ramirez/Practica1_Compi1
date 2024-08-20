package source.frontend.graficar;

import javax.swing.*;
import java.awt.*;

public class GrafPoligono extends JPanel {
    private double posicionX;
    private double posicionY;
    private int cantLados;
    private double ancho;
    private double alto;
    private String color;

    public GrafPoligono() {

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

    public double getCantLados() {
        return cantLados;
    }

    public void setCantLados(int cantLados) {
        this.cantLados = cantLados;
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int[] xPoints = new int[cantLados];
        int[] yPoints = new int[cantLados];

        for (int i = 0; i < cantLados; i++) {
            double angle = 2 * Math.PI * i / cantLados;
            xPoints[i] = (int) (posicionX + ancho / 2 * Math.cos(angle));
            yPoints[i] = (int) (posicionY + alto / 2 * Math.sin(angle));
        }

        Polygon polygon = new Polygon(xPoints, yPoints, cantLados);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(polygon);

        switch (this.color) {
            case "rojo":
                g.setColor(new Color(255, 0, 0));
                break;
            case "azul":
                g.setColor(new Color(18, 45, 221));
                break;
            case "verde":
                g.setColor(new Color(11, 133, 41));
                break;
            case "negro":
                g.setColor(new Color(0, 0, 0));
                break;
            case "amarillo":
                g.setColor(new Color(255, 217, 84));
                break;
            case "lila":
                g.setColor(new Color(239, 155, 234));
                break;
            case "cafe":
                g.setColor(new Color(108, 69, 7));
                break;
            case "gris":
                g.setColor(new Color(107, 107, 107));
                break;
            case "naranja":
                g.setColor(new Color(197, 132, 17));
                break;
            default:
                g.setColor(Color.WHITE);
        }

        g2d.fillPolygon(polygon);
    }
}
