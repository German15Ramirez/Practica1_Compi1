package source.estructura;

import java.util.HashMap;
import java.util.Map;

public class Rectangulo extends Figura {
    private double posX;
    private double posY;
    private double ancho;
    private double alto;

    public Rectangulo(String nombre, double posX, double posY, double ancho, double alto, String color) {
        super(nombre, color);
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Rectángulo");
        detalles.put("posX", posX);
        detalles.put("posY", posY);
        detalles.put("ancho", ancho);
        detalles.put("alto", alto);
        detalles.put("color", getColor());
        return detalles;
    }
}
