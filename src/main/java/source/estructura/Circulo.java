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

        // Mensajes de depuración
        System.out.println("Circulo creado: " + nombre);
        System.out.println("Posición X: " + posX);
        System.out.println("Posición Y: " + posY);
        System.out.println("Radio: " + radio);
        System.out.println("Color: " + color);
        System.out.println("--------------");
    }

    @Override
    public Map<String, Object> getDetalles() {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("tipo", "Círculo");
        detalles.put("posX", posX);
        detalles.put("posY", posY);
        detalles.put("radio", radio);
        detalles.put("color", getColor());

        // Mensajes de depuración
        System.out.println("Obteniendo detalles del círculo: " + getNombre());
        System.out.println("Detalles: " + detalles);
        System.out.println("--------------");

        return detalles;
    }
}