package com.dds.model.indicador;

public abstract class Operador {
    String nombreEmpresa;
    int periodo;

    public String getEmpresa() {
        return nombreEmpresa;
    }

    public void setEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    abstract String getSimbolo();
    abstract double operar(Indicador izq, Indicador der) throws IndicadorException;
}
