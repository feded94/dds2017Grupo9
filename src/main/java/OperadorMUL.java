public class OperadorMUL  implements Operador{

    public String getSimbolo() {

        return "MUL";
    }

    public double operar(Expresion expresion1, Expresion expresion2) {
        return expresion1.getResultado() * expresion2.getResultado();
    }
}