package source.estructura;

public class Operacion  implements Expresion{
    private Expresion izquierda;
    private Expresion derecha;
    private String operador;

    public Operacion(Expresion izquierda, Expresion derecha, String operador) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.operador = operador;
    }

    @Override
    public double evaluar() {
        switch (operador) {
            case "+":
                return izquierda.evaluar() + derecha.evaluar();
            case "-":
                return izquierda.evaluar() - derecha.evaluar();
            case "*":
                return izquierda.evaluar() * derecha.evaluar();
            case "/":
                return izquierda.evaluar() / derecha.evaluar();
            default:
                throw new UnsupportedOperationException("Operador no soportado");
        }
    }
}
