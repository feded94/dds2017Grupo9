public class ExpresionCompuesta implements Expresion {

    private Expresion expresion1;
    private Operador operador;
    private Expresion expresion2;

    public ExpresionCompuesta(Expresion expresion1, Expresion expresion2, Operador operador) {
        this.expresion1 = expresion1;
        this.operador = operador;
        this.expresion2 = expresion2;
    }

    public ExpresionCompuesta() {
    }

    public double getResultado() {
        if(operador == null) {
            throw new RuntimeException("No Hay Operador");
        }
        return operador.operar(expresion1, expresion2);
    }

    public void setExpresion1(Expresion expresion1) {
        this.expresion1 = expresion1;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public void setExpresion2(Expresion expresion2) {
        this.expresion2 = expresion2;
    }

    public Expresion getExpresion1() {
        return expresion1;
    }

    public Operador getOperador() {
        return operador;
    }

    public Expresion getExpresion2() {
        return expresion2;
    }
}