package source.frontend;

import source.backend.Figuras.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PanelGraficas extends JPanel {
    private static final Color COLOR_ROJO = new Color(255, 0, 0);
    private static final Color COLOR_AZUL = new Color(18, 45, 221);
    private static final Color COLOR_VERDE = new Color(11, 133, 41);
    private static final Color COLOR_NEGRO = new Color(0, 0, 0);
    private static final Color COLOR_AMARILLO = new Color(255, 217, 84);
    private static final Color COLOR_LILA = new Color(239, 155, 234);
    private static final Color COLOR_CAFE = new Color(108, 69, 7);
    private static final Color COLOR_GRIS = new Color(107, 107, 107);
    private static final Color COLOR_NARANJA = new Color(197, 132, 17);

    private List<Figura> listaFiguras;

    public PanelGraficas() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Agrega un borde negro
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (listaFiguras != null) {
            for (Figura figura : listaFiguras) {
                if (figura instanceof Circulo) {
                    dibujarCirculo(g2d, (Circulo) figura);
                } else if (figura instanceof Linea) {
                    dibujarLinea(g2d, (Linea) figura);
                } else if (figura instanceof Cuadrado) {
                    dibujarCuadrado(g2d, (Cuadrado) figura);
                } else if (figura instanceof Rectangulo) {
                    dibujarRectangulo(g2d, (Rectangulo) figura);
                } else if (figura instanceof Poligono) {
                    dibujarPoligono(g2d, (Poligono) figura);
                }
            }
        }
    }

    private void dibujarCirculo(Graphics2D g2d, Circulo circulo) {
        g2d.setColor(devolverColor(circulo.getColor()));
        g2d.fillOval((int) circulo.getPosicionX(), (int) circulo.getPosicionY(),
                (int) circulo.getRadio() * 2, (int) circulo.getRadio() * 2);
    }

    private void dibujarLinea(Graphics2D g2d, Linea linea) {
        g2d.setColor(devolverColor(linea.getColor()));
        g2d.setStroke(new BasicStroke(2)); // Línea más gruesa para mayor visibilidad
        g2d.drawLine((int) linea.getPosicionInicialX(), (int) linea.getPosicionInicialY(),
                (int) linea.getPosicionFinalX(), (int) linea.getPosicionFinalY());
    }

    private void dibujarCuadrado(Graphics2D g2d, Cuadrado cuadrado) {
        g2d.setColor(devolverColor(cuadrado.getColor()));
        g2d.fillRect((int) cuadrado.getPosicionX(), (int) cuadrado.getPosicionY(),
                (int) cuadrado.getTamano(), (int) cuadrado.getTamano());
    }

    private void dibujarRectangulo(Graphics2D g2d, Rectangulo rectangulo) {
        g2d.setColor(devolverColor(rectangulo.getColor()));
        g2d.fillRect((int) rectangulo.getPosicionX(), (int) rectangulo.getPosicionY(),
                (int) rectangulo.getAncho(), (int) rectangulo.getAlto());
    }

    private void dibujarPoligono(Graphics2D g2d, Poligono poligono) {
        g2d.setColor(devolverColor(poligono.getColor()));
        int numLados = poligono.getCantidadLados();
        int[] xPoints = new int[numLados];
        int[] yPoints = new int[numLados];

        double centroX = poligono.getPosicionX();
        double centroY = poligono.getPosicionY();
        double radio = Math.min(poligono.getAncho(), poligono.getAlto()) / 2.0;

        for (int i = 0; i < numLados; i++) {
            double angulo = 2 * Math.PI * i / numLados;
            xPoints[i] = (int) (centroX + radio * Math.cos(angulo));
            yPoints[i] = (int) (centroY + radio * Math.sin(angulo));
        }

        g2d.fillPolygon(xPoints, yPoints, numLados);
    }

    private Color devolverColor(String color) {
        switch (color.toLowerCase()) {
            case "rojo": return COLOR_ROJO;
            case "azul": return COLOR_AZUL;
            case "verde": return COLOR_VERDE;
            case "negro": return COLOR_NEGRO;
            case "amarillo": return COLOR_AMARILLO;
            case "lila": return COLOR_LILA;
            case "cafe": return COLOR_CAFE;
            case "gris": return COLOR_GRIS;
            case "naranja": return COLOR_NARANJA;
            default: return Color.WHITE;
        }
    }

    public void guardarComoPNG() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como PNG");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
            }

            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            paint(g2d);
            g2d.dispose();

            try {
                ImageIO.write(image, "PNG", fileToSave);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo PNG: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void guardarComoPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como PDF");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
            }

            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            paint(g2d);
            g2d.dispose();

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();
                Image pdfImage = Image.getInstance(image, null);
                document.add(pdfImage);
            } catch (DocumentException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo PDF: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                document.close();
            }
        }
    }
}