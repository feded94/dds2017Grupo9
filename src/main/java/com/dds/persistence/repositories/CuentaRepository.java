package com.dds.persistence.repositories;

import com.dds.persistence.entities.Cuenta;
import com.dds.persistence.entities.CuentaPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, CuentaPK> {
    Cuenta save(Cuenta cuenta);

    Cuenta findById_NombreCuentaAndEmpresa_NombreEmpresaAndId_Periodo(String nombreCuenta,
                                                                      String nombreEmpresa,
                                                                      Integer periodo);

    List<Cuenta> findById_NombreEmpresa(String nombreEmpresa);
}
