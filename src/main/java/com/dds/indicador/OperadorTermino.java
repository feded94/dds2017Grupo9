package com.dds.indicador;

public interface OperadorTermino {

    String getSimbolo();

    double operar(Termino termino1, Termino termino2);
}