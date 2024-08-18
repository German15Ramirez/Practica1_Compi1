package source.estructura;

import java.util.HashMap;
import java.util.Map;

public class Linea extends Figura {
    private double posX1;
    private double posY1;
    private double posX2;
    private double posY2;

    public Linea(String nombre, double posX1, double posY1, double posX2, double posY2, String color) {
        super(nombre, color);
        this.posX1 = posX1;
        this.posY1 = posY1;
        this.posX2 = posX2;
        this.posY2 = posY2;
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Línea");
        detalles.put("posX1", posX1);
        detalles.put("posY1", posY1);
        detalles.put("posX2", posX2);
        detalles.put("posY2", posY2);
        detalles.put("color", getColor());
        return detalles;
    }
}
