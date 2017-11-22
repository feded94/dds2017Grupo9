package com.dds.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_cache_indicador")
public class CacheIndicador {
    private CacheIndicadorPK id;
    private Double valor;

    @EmbeddedId
    public CacheIndicadorPK getId() {
        return id;
    }

    public void setId(CacheIndicadorPK id) {
        this.id = id;
    }

    @Column(name = "valor")
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
