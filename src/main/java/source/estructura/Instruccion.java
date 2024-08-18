package source.estructura;

public abstract class Instruccion {
    public abstract void ejecutar();

    // Método opcional que puede tener una implementación predeterminada
    public void mostrar() {
        System.out.println(this.toString());
    }
}
