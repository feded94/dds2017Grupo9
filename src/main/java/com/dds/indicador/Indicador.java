package com.dds.indicador;

public class Indicador implements Factor {
    private Termino termino1;
    private OperadorTermino operador;
    private Termino termino2;

    @Override
    public double getResultado() {
        return operador.operar(termino1, termino2);
    }

    public void setTermino1(Termino termino1) {
        this.termino1 = termino1;
    }

    public void setTermino2(Termino termino2) {
        this.termino2 = termino2;
    }

    public void setOperador(OperadorTermino operador) {
        this.operador = operador;
    }
}
