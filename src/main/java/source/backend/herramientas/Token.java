package source.backend.herramientas;

public class Token {
    private String tipo;
    private int linea;
    private int columna;
    private String lexema;

    public Token(String tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tipo='" + tipo + '\'' +
                ", linea=" + linea +
                ", columna=" + columna +
                ", lexema='" + lexema + '\'' +
                '}';
    }
}