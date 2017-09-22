package com.dds.persistence;

import com.dds.model.Operador;
import com.dds.persistence.Indicador;

public class OperadorDIV implements Operador {
    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public double operar(Indicador factor1, Indicador factor2) {
        if (factor2.getResultado() == 0) {
            throw new RuntimeException("No puede dividirse por cero");
        }
        return factor1.getResultado() / factor2.getResultado();
    }
}