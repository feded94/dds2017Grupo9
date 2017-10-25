package com.dds.api.viewmodels;

import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorUnario;

import java.util.ArrayList;
import java.util.List;

public class OperadorViewModel {
    private final String tipo;
    private final String nombre;
    // TODO: private String descripcion;

    public OperadorViewModel(Operador operador) {
        this.tipo = operador instanceof OperadorUnario
                ? "unario"
                : "binario";

        this.nombre = operador.nombre();
    }

    public static List<OperadorViewModel> mapAll(List<Operador> operadores) {
        List<OperadorViewModel> operadorViewModels = new ArrayList<>(operadores.size());

        for (Operador op : operadores) {
            operadorViewModels.add(new OperadorViewModel(op));
        }

        return  operadorViewModels;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }
}
