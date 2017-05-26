public class OperadorDIV implements Operador {

    public String getSimbolo() {
        return "DIV";
    }

    public double operar(Expresion expresion1, Expresion expresion2) {
        if(expresion1 == null || expresion2 == null) {    //no estoy seguro si es lo mismo poner null o cero
            throw new RuntimeException("No puede dividirse por cero");
        }

        return expresion1.getResultado() / expresion2.getResultado();
    }
}