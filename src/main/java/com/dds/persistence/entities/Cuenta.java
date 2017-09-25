package com.dds.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_cuenta")
public class Cuenta {
    private CuentaPK id;
    private Empresa empresa;
    private double valor;

    @EmbeddedId
    public CuentaPK getId() {
        return id;
    }

    public void setId(CuentaPK id) {
        this.id = id;
    }

    @MapsId("nombreEmpresa")
    @ManyToOne
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Column(name = "valor")
    @NotNull
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(id)
                .append(" = ").append(valor).toString();
    }
}
