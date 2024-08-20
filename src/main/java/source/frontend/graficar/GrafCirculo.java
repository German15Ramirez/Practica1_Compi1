package source.frontend.graficar;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.Color;
public class GrafCirculo extends JPanel {
    private double posicionX;
    private double posicionY;
    private double radio;
    private String color;

    public GrafCirculo() {
        System.out.println("graficar circulo");
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
        g.fillOval((int)this.posicionX, (int)this.posicionY, (int)this.radio * 2, (int)this.radio * 2);
    }
}
