package source.frontend.modelo;

import java.util.List;

public class Figura {
    private String tipo;
    private String id;
    private String color;
    private List<Object> parametros;

    public Figura(String tipo, String id, String color) {
        this.tipo = tipo;
        this.id = id;
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public List<Object> getParametros() {
        return parametros;
    }

    public void setParametros(List<Object> parametros) {
        this.parametros = parametros;
    }

    @Override
    public String toString() {
        return tipo + " con ID: " + id + " y color: " + color;
    }
}