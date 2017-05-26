public class OperadorRES implements Operador {


    public String getSimbolo() {
        return "RES";
    }

    public double operar(Expresion expresion1, Expresion expresion2) {
        if(expresion1 == null || expresion2 == null) {
            throw new RuntimeException("Deben Definirse Las Expresiones");
        }
        return expresion1.getResultado() - expresion2.getResultado();
    }
}