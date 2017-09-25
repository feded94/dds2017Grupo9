package com.dds.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_empresa")
public class Empresa {
    @Id
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_alta")
    private Date fechaAlta;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
