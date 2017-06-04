package com.dds.indicador;

public interface OperadorTermino {

    String getSimbolo();

    double operar(double termino1, Termino termino2);
}