package source.frontend.modelo;

import java.util.List;

public class Animacion {
    private String tipoAnimacion;
    private List<Object> parametros;

    public Animacion(String tipoAnimacion, List<Object> parametros) {
        this.tipoAnimacion = tipoAnimacion;
        this.parametros = parametros;
    }

    public String getTipoAnimacion() {
        return tipoAnimacion;
    }

    public List<Object> getParametros() {
        return parametros;
    }

    @Override
    public String toString() {
        return "Animación tipo: " + tipoAnimacion + " con parámetros: " + parametros;
    }
}