public class Termino implements Expresion {

    private double valor;

    public Termino(double valor) {
        this.valor = valor;
    }

    public double getResultado() {
        return valor;
    }
}