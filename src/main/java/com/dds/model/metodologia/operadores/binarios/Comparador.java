package com.dds.model.metodologia.operadores.binarios;

import com.dds.model.metodologia.operadores.OperadorBinario;

import java.util.List;
import java.util.Map;

public abstract class Comparador implements OperadorBinario {
    protected abstract boolean compare(Double a, Double b);

    @Override
    public boolean evaluar(List<Double> resultados, Double operando) {
        return resultados.stream().allMatch(r -> compare(r, operando));
    }

    @Override
    public boolean evaluar(List<Map.Entry<Double, Double>> resultados) {
        return resultados.stream().allMatch(r -> compare(r.getKey(), r.getValue()));
    }
}
