package com.dds.indicador;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public abstract class Indicador {
    public static Indicador getIndicador(String nombre) {
        return new ID(nombre);
    }

    public static Indicador getIndicador(double valor) {
        return new Numero(valor);
    }

    public static Indicador getIndicador(Indicador izq, Operador op, Indicador der) {
        return new IndicadorCompuesto(izq, op, der);
    }

    public Indicador operarCon(Operador op, String nombre) {
        return new IndicadorCompuesto(this, op, getIndicador(nombre));
    }

    public Indicador operarCon(Operador op, double numero) {
        return new IndicadorCompuesto(this, op, getIndicador(numero));
    }

    public Indicador operarCon(Operador op, Indicador indicador) {
        return new IndicadorCompuesto(this, op, indicador);
    }

    public abstract double getResultado();
}
