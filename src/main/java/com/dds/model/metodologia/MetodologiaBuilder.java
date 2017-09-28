package com.dds.model.metodologia;

import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorUnario;

public class MetodologiaBuilder {
    public CondicionBuilder setIDYPeriodo(String idCuentaIndicador, int periodos) {
        return new CondicionBuilder(idCuentaIndicador, periodos);
    }

    public class CondicionBuilder {
        private final String idCuentaIndicador;
        private final int periodos;

        private CondicionBuilder(String idCuentaIndicador, int periodos) {
            this.idCuentaIndicador = idCuentaIndicador;
            this.periodos = periodos;
        }

        public MetodologiaTaxativa setOperador(OperadorUnario operadorUnario) {
            return new MetodologiaTaxativa(idCuentaIndicador, periodos, operadorUnario);
        }

        public CondicionBinariaBuilder setOperador(OperadorBinario operadorBinario) {
            return new CondicionBinariaBuilder(idCuentaIndicador, periodos, operadorBinario);
        }

        public class CondicionBinariaBuilder {
            private final String idCuentaIndicador;
            private final int periodos;
            private final OperadorBinario operador;

            private CondicionBinariaBuilder(String idCuentaIndicador, int periodos, OperadorBinario operador) {
                this.idCuentaIndicador = idCuentaIndicador;
                this.periodos = periodos;
                this.operador = operador;
            }

            public MetodologiaTaxativa setOperando(Double constante) {
                return new MetodologiaTaxativa(idCuentaIndicador, periodos, operador, constante);
            }

            public MetodologiaComparativa setComparativo() {
                return new MetodologiaComparativa(idCuentaIndicador, periodos, operador);
            }
        }
    }
}
