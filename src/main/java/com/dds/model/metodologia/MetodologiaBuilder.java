package com.dds.model.metodologia;

import com.dds.model.indicador.Indicador;
import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorBinario;
import com.dds.model.metodologia.operadores.OperadorUnario;

public class MetodologiaBuilder {
    public class CondicionBuilder {
        private final Indicador indicador;

        public CondicionBuilder(Indicador indicador) {
            this.indicador = indicador;
        }

        public CondicionTaxativaBuilder setOperador(OperadorUnario operadorUnario) {
            return new CondicionTaxativaBuilder(indicador, operadorUnario);
        }

        public CondicionBinariaBuilder setOperador(OperadorBinario operadorBinario) {
            return new CondicionBinariaBuilder(indicador, operadorBinario);
        }

        public class CondicionTaxativaBuilder {
            private final Indicador indicador;
            private final Operador operador;
            private Double constante;

            public CondicionTaxativaBuilder(Indicador indicador, OperadorUnario operador) {
                this.indicador = indicador;
                this.operador = operador;
            }

            public CondicionTaxativaBuilder(Indicador indicador, OperadorBinario operador, Double constante) {
                this.indicador = indicador;
                this.operador = operador;
                this.constante = constante;
            }

            public Metodologia setPeriodos(int periodos) {
                return new MetodologiaTaxativa(indicador, operador, periodos, constante);
            }
        }

        public class CondicionBinariaBuilder {
            private final Indicador indicador;
            private final OperadorBinario operador;

            public CondicionBinariaBuilder(Indicador indicador, OperadorBinario operador) {
                this.indicador = indicador;
                this.operador = operador;
            }

            public CondicionTaxativaBuilder setOperando(Double constante) {
                return new CondicionTaxativaBuilder(indicador, operador, constante);
            }

            public CondicionComparativaBuilder setComparativo() {
                return new CondicionComparativaBuilder(indicador, operador);
            }

            public class CondicionComparativaBuilder {
                private final Indicador indicador;
                private final OperadorBinario operador;

                public CondicionComparativaBuilder(Indicador indicador, OperadorBinario operador) {
                    this.indicador = indicador;
                    this.operador = operador;
                }

                public Metodologia setPeriodo(int periodos) {
                    return new MetodologiaComparativa(indicador, operador, periodos);
                }
            }
        }
    }

    public CondicionBuilder setIndicador(Indicador indicador) {
        return new CondicionBuilder(indicador);
    }
}
