package com.dds.model.metodologia;

import com.dds.model.indicador.ID;
import com.dds.model.indicador.IndicadorException;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.EmpresaService;

import java.util.*;

public class MetodologiaComparativa implements Metodologia {
    private final ID cuentaIndicador;
    private final OperadorBinario operador;
    private final int periodos;

    /**
        Usar MetodologiaBuilder para construir esta clase.
     */
    protected MetodologiaComparativa(String idCuentaIndicador, int periodos, OperadorBinario operador) {
        this.cuentaIndicador = new ID(idCuentaIndicador);
        this.operador = operador;
        this.periodos = periodos;
    }

    public boolean evaluar(String nombreEmpresa1, String nombreEmpresa2) throws MetodologiaException {
        Integer cantidadPeriodos1 = EmpresaService.getService().getCantidadPeriodos(nombreEmpresa1);
        Integer cantidadPeriodos2 = EmpresaService.getService().getCantidadPeriodos(nombreEmpresa2);

        if (cantidadPeriodos1 < periodos) {
            throw new MetodologiaException(nombreEmpresa1 + " no tiene suficientes periodos para ser evaluada.");
        }
        if (cantidadPeriodos2 < periodos) {
            throw new MetodologiaException(nombreEmpresa2 + " no tiene suficientes periodos para ser evaluada.");
        }

        List<Integer> listaPeriodos = EmpresaService.getService().getUltimosPeriodos(nombreEmpresa1, periodos);

        List<Map.Entry<Double, Double>> resultados = this.getResultados(nombreEmpresa1, nombreEmpresa2, listaPeriodos);

        return operador.evaluar(resultados);
    }

    public boolean evaluar(String nombreEmpresa1, Empresa empresa2) throws MetodologiaException {
        return evaluar(nombreEmpresa1, empresa2.getNombreEmpresa());
    }

    public boolean evaluar(Empresa empresa1, String nombreEmpresa2) throws MetodologiaException {
        return evaluar(empresa1.getNombreEmpresa(), nombreEmpresa2);
    }

    public boolean evaluar(Empresa empresa1, Empresa empresa2) throws MetodologiaException {
        return evaluar(empresa1.getNombreEmpresa(), empresa2.getNombreEmpresa());
    }

    private List<Map.Entry<Double, Double>> getResultados(String nombreEmpresa1,
                                                          String nombreEmpresa2,
                                                          List<Integer> periodos) throws MetodologiaException
    {
        List<Map.Entry<Double, Double>> result = new LinkedList<>();
        for (int periodo : periodos) {
            Double a, b;

            try {
                a = cuentaIndicador.getResultado(nombreEmpresa1, periodo);
            }
            catch (IndicadorException e) {
                throw new MetodologiaException("No se encontro el valor de " + "\"" + cuentaIndicador + "\""
                        + "para el periodo " + periodo + " de la Empresa \"" + nombreEmpresa1 + "\"");
            }

            try {
                b = cuentaIndicador.getResultado(nombreEmpresa2, periodo);
            }
            catch (IndicadorException e) {
                throw new MetodologiaException("No se encontro el valor de " + "\"" + cuentaIndicador + "\""
                        + "para el periodo " + periodo + " de la Empresa \"" + nombreEmpresa2 + "\"");
            }

            result.add(new AbstractMap.SimpleEntry<>(a, b));
        }

        return result;
    }

    public ID getCuentaIndicador() {
        return cuentaIndicador;
    }

    public OperadorBinario getOperador() {
        return operador;
    }

    public int getPeriodos() {
        return periodos;
    }
}
