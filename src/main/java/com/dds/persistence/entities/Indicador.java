package com.dds.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_indicador")
public class Indicador {
    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "regla")
    private String regla;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }
}
