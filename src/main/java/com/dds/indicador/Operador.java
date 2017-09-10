package com.dds.indicador;

public interface Operador {
    String getSimbolo();
    double operar(Indicador izq, Indicador der);
}
