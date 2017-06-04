package com.dds.indicador;

public interface OperadorFactor {
    String getSimbolo();

    double operar(double factor1, Factor factor2);
}
