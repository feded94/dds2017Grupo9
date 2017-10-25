package com.dds.persistence.entities;

import com.dds.persistence.services.UsuarioService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_metodologia")
public class Metodologia {
    private String nombre;
    private String cuentaIndicador;
    private String operador;
    private int periodos;
    private Double operando;
    private Usuario usuario;
    private String nombreUsuario;

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

    @Column(name = "operador")
    @NotNull
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
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

    @ManyToOne
    @JoinColumn(name = "usuario")
    @NotNull
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Transient
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.usuario = UsuarioService.getService().findByNombreUsuario(nombreUsuario);
        this.nombreUsuario = nombreUsuario;
    }
}
