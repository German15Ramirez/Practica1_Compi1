package source.estructura;

import java.util.HashMap;
import java.util.Map;

public class Poligono extends Figura {
    private double posX;
    private double posY;
    private int cantidadLados;
    private double ancho;
    private double alto;

    public Poligono(String nombre, double posX, double posY, int cantidadLados, double ancho, double alto, String color) {
        super(nombre, color);
        this.posX = posX;
        this.posY = posY;
        this.cantidadLados = cantidadLados;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Polígono");
        detalles.put("posX", posX);
        detalles.put("posY", posY);
        detalles.put("cantidadLados", cantidadLados);
        detalles.put("ancho", ancho);
        detalles.put("alto", alto);
        detalles.put("color", getColor());
        return detalles;
    }
}
