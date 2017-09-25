package com.dds.persistence.repositories;

import com.dds.persistence.entities.Indicador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepository extends CrudRepository<Indicador, String> {
    Indicador save(Indicador indicador);
    Indicador findByNombre(String nombre);
}
