public class OperadorRES implements Operador {


    public String getSimbolo() {
        return "RES";
    }

    public double operar(Expresion expresion1, Expresion expresion2) {
        return expresion1.getResultado() - expresion2.getResultado();
    }
}