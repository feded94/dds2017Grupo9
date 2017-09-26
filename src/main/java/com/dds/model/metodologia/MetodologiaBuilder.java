package com.dds.model.metodologia;

import com.dds.model.indicador.Indicador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorUnario;

public class MetodologiaBuilder {
    public CondicionBuilder setIndicador(Indicador indicador, int periodos) {
        return new CondicionBuilder(indicador, periodos);
    }

    private class CondicionBuilder {
        private final Indicador indicador;
        private final int periodos;

        public CondicionBuilder(Indicador indicador, int periodos) {
            this.indicador = indicador;
            this.periodos = periodos;
        }

        public Metodologia setOperador(OperadorUnario operadorUnario) {
            return new MetodologiaTaxativa(indicador, periodos, operadorUnario);
        }

        public CondicionBinariaBuilder setOperador(OperadorBinario operadorBinario) {
            return new CondicionBinariaBuilder(indicador, periodos, operadorBinario);
        }

        private class CondicionBinariaBuilder {
            private final Indicador indicador;
            private final int periodos;
            private final OperadorBinario operador;

            public CondicionBinariaBuilder(Indicador indicador, int periodos, OperadorBinario operador) {
                this.indicador = indicador;
                this.periodos = periodos;
                this.operador = operador;
            }

            public MetodologiaTaxativa setOperando(Double constante) {
                return new MetodologiaTaxativa(indicador, periodos, operador, constante);
            }

            public MetodologiaComparativa setComparativo() {
                return new MetodologiaComparativa(indicador, periodos, operador);
            }
        }
    }
}
