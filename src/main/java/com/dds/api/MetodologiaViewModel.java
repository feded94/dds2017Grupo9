package com.dds.api;

import com.dds.persistence.entities.Metodologia;
import com.dds.persistence.entities.Operador;

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

        if (metodologia.getOperador().getTipo() == Operador.Tipo.BINARIO)
            sb.append("(Empresa 1) ");

        sb.append(metodologia.getOperador().getNombre());

        if (metodologia.getOperador().getTipo() == Operador.Tipo.BINARIO) {
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
}

