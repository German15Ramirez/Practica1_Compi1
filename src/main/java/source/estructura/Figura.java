package source.estructura;
import java.util.HashMap;
import java.util.Map;

public abstract class Figura {
    protected String nombre;
    protected String color;

    public Figura(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;

        // Mensajes de depuración
        System.out.println("Figura creada: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("--------------");
    }

    public String getNombre() {
        // Mensaje de depuración
        System.out.println("Obteniendo nombre de la figura: " + nombre);
        return nombre;
    }

    public String getColor() {
        // Mensaje de depuración
        System.out.println("Obteniendo color de la figura: " + color);
        return color;
    }

    public abstract Map<String, Object> getDetalles();
}