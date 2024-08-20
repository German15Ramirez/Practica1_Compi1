package source.backend.herramientas;

public class OperadorAritmetico {
    private String operador;
    private String simbolo;
    private int linea;
    private int columna;
    private int ocurrencia = 0;

    public OperadorAritmetico(String operador, String simbolo, int linea, int columna, int ocurrencia) {
        this.operador = operador;
        this.simbolo = simbolo;
        this.linea = linea;
        this.columna = columna;
        this.ocurrencia += ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
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

    public int getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(int ocurrencia) {
        this.ocurrencia = ocurrencia;
    }
}
