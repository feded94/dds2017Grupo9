package com.dds.model.metodologia.operadores;

import com.dds.model.metodologia.operadores.binarios.*;
import com.dds.model.metodologia.operadores.unarios.Creciente;
import com.dds.model.metodologia.operadores.unarios.CrecienteEstricto;
import com.dds.model.metodologia.operadores.unarios.Decreciente;
import com.dds.model.metodologia.operadores.unarios.DecrecienteEstricto;

import java.util.ArrayList;
import java.util.List;

public final class OperadorFactory {
    private static final List<Operador> operadores;

    static {
        operadores = new ArrayList<>(10);

        operadores.add(new Igual());
        operadores.add(new Distinto());
        operadores.add(new Mayor());
        operadores.add(new MayorOIgual());
        operadores.add(new Menor());
        operadores.add(new MenorOIgual());

        operadores.add(new Creciente());
        operadores.add(new CrecienteEstricto());
        operadores.add(new Decreciente());
        operadores.add(new DecrecienteEstricto());
    }

    private OperadorFactory() {}

    public static List<Operador> getOperadores() {
        return operadores;
    }

    public static Operador getOperador(String nombreOperador) {
        for (Operador op : operadores) {
            if (op.nombre().equals(nombreOperador))
                return op;
        }

        throw new RuntimeException("El operador no existe.");
    }
}
