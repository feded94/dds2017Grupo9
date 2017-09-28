package com.dds.model.metodologia.operadores.unarios;

import com.dds.model.metodologia.operadores.OperadorUnario;

import java.util.List;

public abstract class OperadorCrecimiento implements OperadorUnario {
    protected abstract boolean compare(Double a, Double b);

    @Override
    public final boolean evaluar(List<Double> resultados) {
        for (int i = 1; i < resultados.size(); i++) {
            if (!compare(resultados.get(i - 1), resultados.get(i))) {
                return false;
            }
        }

        return true;
    }
}
