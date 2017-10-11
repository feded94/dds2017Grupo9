package com.dds.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_indicador")
public class Indicador {
    private String nombre;
    private String regla;
    private Usuario usuario;

    @Id
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "regla")
    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }

    @ManyToOne
    @JoinColumn(name = "usuario")
    @NotNull
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
