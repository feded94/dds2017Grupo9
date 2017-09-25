package com.dds.model.metodologia;

import com.dds.model.indicador.Indicador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.persistence.entities.Empresa;

public class MetodologiaComparativa implements Metodologia {
    private final Indicador indicador;
    private final OperadorBinario operador;
    private final int periodos;

    public MetodologiaComparativa(Indicador indicador, OperadorBinario operador, int periodos) {
        this.indicador = indicador;
        this.operador = operador;
        this.periodos = periodos;
    }

    public boolean evaluar(String nombreEmpresa1, String nombreEmpresa2) {
        // TODO
        return false;
    }

    public boolean evaluar(String nombreEmpresa1, Empresa empresa2) {
        return evaluar(nombreEmpresa1, empresa2.getNombreEmpresa());
    }

    public boolean evaluar(Empresa empresa1, String nombreEmpresa2) {
        return evaluar(empresa1.getNombreEmpresa(), nombreEmpresa2);
    }

    public boolean evaluar(Empresa empresa1, Empresa empresa2) {
        return evaluar(empresa1.getNombreEmpresa(), empresa2.getNombreEmpresa());
    }
}
