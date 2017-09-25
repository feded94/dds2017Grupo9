package com.dds.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CuentaPK implements Serializable {
    private String nombreCuenta;
    private String nombreEmpresa;
    private Integer periodo;

    @Column(name = "nombre_cuenta")
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    @Column(name = "nombre_empresa")
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Column(name = "periodo")
    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(nombreEmpresa)
                .append("(periodo ").append(periodo).append(")")
                .append(": ").append(nombreCuenta).toString();
    }
}
