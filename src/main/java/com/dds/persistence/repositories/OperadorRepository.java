package com.dds.persistence.repositories;

import com.dds.persistence.entities.Operador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperadorRepository extends CrudRepository<Operador, String> {
    Operador save(Operador operador);

    Operador findByNombre(String nombre);

    List<Operador> findByTipo(Operador.Tipo tipo);

    List<Operador> findByNombreAndTipo(String nombre, Operador.Tipo tipo);

    List<Operador> findAll();
}
