package com.dds.indicador;

public class IndicadorCompuesto extends Indicador {
    private Indicador izq;
    private Operador op;
    private Indicador der;

    protected IndicadorCompuesto(Indicador izq, Operador op, Indicador der) {
        this.izq = izq;
        this.op = op;
        this.der = der;
    }

    @Override
    public double getResultado() {
        return op.operar(izq, der);
    }
}
