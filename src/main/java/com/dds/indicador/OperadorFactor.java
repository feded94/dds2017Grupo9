package com.dds.indicador;

public interface OperadorFactor {
    String getSimbolo();

    double operar(Factor factor1, Factor factor2);
}
