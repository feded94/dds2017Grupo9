package com.dds.api.viewmodels;

import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorFactory;
import com.dds.persistence.entities.Metodologia;

import java.util.ArrayList;
import java.util.List;

public class MetodologiaViewModel {
    private final String nombre;
    private final String condicion;
    private final String username;

    public MetodologiaViewModel(Metodologia metodologia) {
        this.nombre = metodologia.getNombre();

        StringBuilder sb = new StringBuilder()
                .append(metodologia.getCuentaIndicador())
                .append(" ");

        Operador operador = OperadorFactory.getOperador(metodologia.getOperador());

        if (operador instanceof OperadorBinario && metodologia.getOperando() == null)
            sb.append("(Empresa 1) ");

        sb.append(metodologia.getOperador());

        if (operador instanceof OperadorBinario) {
            sb.append(" ");

            // Comparativa
            if (metodologia.getOperando() == null)
                sb.append(metodologia.getCuentaIndicador()).append(" (Empresa 2)");
                // Taxativa con operando
            else
                sb.append(metodologia.getOperando());
        }

        if (metodologia.getPeriodos() > 1)
            sb.append(" durante últimos ")
                    .append(metodologia.getPeriodos())
                    .append(" periodos");

        this.condicion = sb.toString();
        this.username = metodologia.getUsuario().getNombreUsuario();
    }

    public static List<MetodologiaViewModel> mapAll(List<Metodologia> metodologias) {
        List<MetodologiaViewModel> metodologiaViewModels = new ArrayList<>(metodologias.size());

        for (Metodologia metodologia : metodologias) {
            metodologiaViewModels.add(new MetodologiaViewModel(metodologia));
        }

        return metodologiaViewModels;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getUsername() {
        return username;
    }
}

