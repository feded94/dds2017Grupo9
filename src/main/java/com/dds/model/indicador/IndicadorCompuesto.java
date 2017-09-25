package com.dds.model.indicador;

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
    public double getResultado(String nombreEmpresa, Integer periodo) throws IndicadorException {
        op.setEmpresa(nombreEmpresa);
        op.setPeriodo(periodo);

        return op.operar(izq, der);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("(")
                                  .append(izq.toString())
                                  .append(op.getSimbolo())
                                  .append(der.toString())
                                  .append(")")
                                  .toString();
    }
}
