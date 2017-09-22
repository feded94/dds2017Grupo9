package com.dds.persistence;

import com.dds.model.Operador;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Indicador {
	
	@Id
	@GeneratedValue
	private Long id;
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
