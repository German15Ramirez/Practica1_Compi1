package source.estructura;

import java.util.HashMap;
import java.util.Map;

public class Cuadrado extends Figura {
    private double posX;
    private double posY;
    private double tamanoLado;

    public Cuadrado(String nombre, double posX, double posY, double tamanoLado, String color) {
        super(nombre, color);
        this.posX = posX;
        this.posY = posY;
        this.tamanoLado = tamanoLado;
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Cuadrado");
        detalles.put("posX", posX);
        detalles.put("posY", posY);
        detalles.put("tamanoLado", tamanoLado);
        detalles.put("color", getColor());
        return detalles;
    }
}
