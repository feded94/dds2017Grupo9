package com.dds.persistence.repositories;

import com.dds.persistence.entities.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, String> {
    Empresa save(Empresa empresa);
    Empresa findByNombreEmpresa(String nombreEmpresa);
}
