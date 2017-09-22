package com.dds.model;

import com.dds.persistence.Indicador;

public interface Operador {
    String getSimbolo();
    double operar(Indicador izq, Indicador der);
}
