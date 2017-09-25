package com.dds.model;

import com.dds.model.indicador.IndicadorException;

public interface Dato {
    double getResultado(String nombreEmpresa, Integer periodo) throws IndicadorException;

    @Override
    String toString();
}
