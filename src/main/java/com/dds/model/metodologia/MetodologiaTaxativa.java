package com.dds.model.metodologia;

import com.dds.model.indicador.Indicador;
import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorUnario;

public class MetodologiaTaxativa implements Metodologia {
    private final Indicador indicador;
    private final Operador operador;
    private final int periodos;
    private final Double operando;

    public MetodologiaTaxativa(Indicador indicador, int periodos, OperadorUnario operador) {
        this.indicador = indicador;
        this.operador = operador;
        this.periodos = periodos;

        // Un operador unario no necesita otro operando.
        this.operando = null;
    }

    public MetodologiaTaxativa(Indicador indicador, int periodos, OperadorBinario operador, Double operando) {
        this.indicador = indicador;
        this.operador = operador;
        this.periodos = periodos;
        this.operando = operando;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public Operador getOperador() {
        return operador;
    }

    public int getPeriodos() {
        return periodos;
    }

    public Double getOperando() {
        return operando;
    }
}
