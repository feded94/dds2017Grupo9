package com.dds.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_metodologia")
public class Metodologia {
    private String nombre;
    private String cuentaIndicador;
    private Operador operador;
    private int periodos;
    private Double operando;

    @Id
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "id_cuenta_indicador")
    @NotNull
    public String getCuentaIndicador() {
        return cuentaIndicador;
    }

    public void setCuentaIndicador(String cuentaIndicador) {
        this.cuentaIndicador = cuentaIndicador;
    }

    @ManyToOne
    @JoinColumn(name = "operador")
    @NotNull
    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @Column(name = "periodo")
    @NotNull
    public int getPeriodos() {
        return periodos;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }

    @Column(name = "operando")
    public Double getOperando() {
        return operando;
    }

    public void setOperando(Double operando) {
        this.operando = operando;
    }
}
