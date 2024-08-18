package source.estructura;
import java.util.List;
public class Instrucciones {
    private List<Instruccion> instrucciones;

    public Instrucciones(List<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    @Override
    public String toString() {
        return "Instrucciones{" +
                "instrucciones=" + instrucciones +
                '}';
    }
}
