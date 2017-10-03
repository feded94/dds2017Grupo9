package com.dds.persistence.repositories;

import com.dds.persistence.entities.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, String> {
    Empresa save(Empresa empresa);
    Empresa findByNombreEmpresa(String nombreEmpresa);

    /**
     * Obtener ultimo periodo de la empresa.
     * @param nombreEmpresa nombre de la empresa
     * @return ultimo periodo
     */
    @Query(nativeQuery = true,
            value = "SELECT DISTINCT periodo " +
                    "FROM t_cuenta " +
                    "WHERE empresa = ?1 " +
                    "ORDER BY periodo DESC " +
                    "LIMIT 1")
    Integer getLastPeriod(String nombreEmpresa);

    /**
     * Obtener los ultimos N periodos de la empresa.
     * @param nombreEmpresa nombre de la empresa
     * @param nPeriodos ultimos N periodos a obtener
     * @return lista que contiene a ultimos N periodos
     */
    @Query(nativeQuery = true,
            value = "SELECT DISTINCT periodo " +
                    "FROM t_cuenta " +
                    "WHERE empresa = ?1 " +
                    "ORDER BY periodo DESC " +
                    "LIMIT ?2")
    List<Integer> getLastPeriods(String nombreEmpresa, int nPeriodos);

    /**
     * Obtener la cantidad total de periodos de la empresa.
     * @param nombreEmpresa nombre de la empresa
     * @return cantidad total de periodos
     */
    @Query(nativeQuery = true,
            value = "SELECT COUNT (DISTINCT periodo) " +
                    "FROM t_cuenta " +
                    "WHERE empresa = ?1")
    Integer countPeriods(String nombreEmpresa);
}
