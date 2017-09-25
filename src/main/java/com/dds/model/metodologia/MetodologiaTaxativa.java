package com.dds.model.metodologia;

import com.dds.model.indicador.Indicador;
import com.dds.model.metodologia.operadores.Operador;

public class MetodologiaTaxativa implements Metodologia {
    private final Indicador indicador;
    private final Operador operador;
    private final int periodos;
    private final Double operando;

    public MetodologiaTaxativa(Indicador indicador, Operador operador, int periodos, Double operando) {
        this.indicador = indicador;
        this.operador = operador;
        this.periodos = periodos;
        this.operando = operando;
    }
}
