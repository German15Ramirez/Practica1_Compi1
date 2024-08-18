package source.estructura;
import java.util.HashMap;
import java.util.Map;

public abstract class Figura {
    protected String nombre;
    protected String color;

    public Figura(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public abstract Map<String, Object> getDetalles();
}

