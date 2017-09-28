package com.dds.model.metodologia;

import com.dds.model.indicador.ID;
import com.dds.model.indicador.IndicadorException;
import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorUnario;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.EmpresaService;

import java.util.List;

public class MetodologiaTaxativa implements Metodologia {
    private final ID cuentaIndicador;
    private final Operador operador;
    private final int periodos;
    private final Double operando;

    private MetodologiaTaxativa(String idCuentaIndicador, int periodos, Operador operador, Double operando) {
        this.cuentaIndicador = new ID(idCuentaIndicador);
        this.operador = operador;
        this.periodos = periodos;
        this.operando = operando;
    }

    /**
        Usar MetodologiaBuilder para construir esta clase.
     */
    protected MetodologiaTaxativa(String idCuentaIndicador, int periodos, OperadorUnario operador) {
        // Un operador unario no necesita otro operando.
        this(idCuentaIndicador, periodos, operador, null);
    }

    /**
        Usar MetodologiaBuilder para construir esta clase.
     */
    protected MetodologiaTaxativa(String idCuentaIndicador, int periodos, OperadorBinario operador, Double operando) {
        this(idCuentaIndicador, periodos, (Operador) operador, operando);
    }

    public boolean evaluar(String nombreEmpresa) throws MetodologiaException {
        Integer cantidadPeriodos = EmpresaService.getService().getCantidadPeriodos(nombreEmpresa);
        if (cantidadPeriodos == null || cantidadPeriodos < periodos)
            throw new MetodologiaException("Esta empresa no tiene suficientes periodos para ser evaluado.");

        List<Integer> listaPeriodos = EmpresaService.getService().getUltimosPeriodos(nombreEmpresa, periodos);
        for (Integer periodo : listaPeriodos) {
            try {
                // TODO
                cuentaIndicador.getResultado(nombreEmpresa, periodo);
            }
            catch (IndicadorException e) {
                throw new MetodologiaException("No se encontro el valor de " + "\"" + cuentaIndicador + "\""
                        + "para el periodo " + periodo);
            }
        }

        return true;
    }

    public boolean evaluar(Empresa empresa) throws MetodologiaException {
        return evaluar(empresa.getNombreEmpresa());
    }

    public ID getCuentaIndicador() {
        return cuentaIndicador;
    }

    public Operador getOperador() {
        return operador;
    }

    public int getPeriodos() {
        return periodos;
    }

    public Double getOperando() {
        return operando;
    }
}
