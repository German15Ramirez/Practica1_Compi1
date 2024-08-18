package source.estructura;

import java.util.HashMap;
import java.util.Map;

public class Circulo extends Figura {
    private double posX;
    private double posY;
    private double radio;

    public Circulo(String nombre, double posX, double posY, double radio, String color) {
        super(nombre, color);
        this.posX = posX;
        this.posY = posY;
        this.radio = radio;
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Círculo");
        detalles.put("posX", posX);
        detalles.put("posY", posY);
        detalles.put("radio", radio);
        detalles.put("color", getColor());
        return detalles;
    }
}
