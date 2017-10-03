package com.dds.persistence.repositories;

import com.dds.persistence.entities.Metodologia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodologiaRepository extends CrudRepository<Metodologia, String> {
    Metodologia save(Metodologia metodologia);

    Metodologia findByNombre(String nombre);
}
