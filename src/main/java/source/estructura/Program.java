package source.estructura;
import java.util.List;

public class Program {
    private List<Instruccion> instrucciones;

    public Program(List<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    @Override
    public String toString() {
        return "Program{" +
                "instrucciones=" + instrucciones +
                '}';
    }
}
