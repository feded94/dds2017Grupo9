package com.dds.model.indicador;

import com.dds.persistence.services.CuentaService;
import com.dds.persistence.services.IndicadorService;

public class ID extends Indicador {
    private String id;

    public ID(String id) {
        this.id = id;
    }

    @Override
    public double getResultado(String nombreEmpresa, Integer periodo) throws IndicadorException {
        com.dds.persistence.entities.Indicador indicador = IndicadorService.getService().findByName(id);

        if (indicador == null) {
            com.dds.persistence.entities.Cuenta cuenta = CuentaService.getService().findByPK(id, nombreEmpresa, periodo);

            if (cuenta == null) {
                throw new IndicadorException("No existe cuenta/indicador \"" + id + "\"");
            }

            return cuenta.getValor();
        }

        return Indicador.parseFromString(indicador.getRegla())
                .getResultado(nombreEmpresa, periodo);
    }

    @Override
    public String toString() {
        return id;
    }
}
