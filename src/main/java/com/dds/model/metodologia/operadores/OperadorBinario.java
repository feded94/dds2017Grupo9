package com.dds.model.metodologia.operadores;

import java.util.List;
import java.util.Map;

public interface OperadorBinario extends Operador {
    boolean evaluar(List<Double> resultados, Double operando);
    boolean evaluar(List<Map.Entry<Double, Double>> resultados);
}
