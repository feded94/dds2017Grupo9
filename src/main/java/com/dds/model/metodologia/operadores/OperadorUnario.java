package com.dds.model.metodologia.operadores;

import java.util.List;

public interface OperadorUnario extends Operador {
    boolean evaluar(List<Double> resultados);
}
