package source.frontend.graficar;

import javax.swing.*;
import java.awt.*;

public class GrafCuadrado extends JPanel {
    private  double inicialX;
    private  double inicialY;
    private double tamanio;
    private String color;

    public GrafCuadrado() {

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

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
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
        g.fillRect((int)this.inicialX, (int)this.inicialY, (int)this.tamanio, this.color.length());
    }
}
