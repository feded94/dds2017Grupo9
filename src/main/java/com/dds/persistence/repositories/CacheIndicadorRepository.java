package com.dds.persistence.repositories;

import com.dds.persistence.entities.CacheIndicador;
import com.dds.persistence.entities.CacheIndicadorPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CacheIndicadorRepository extends CrudRepository<CacheIndicador, CacheIndicadorPK> {
    CacheIndicador save(CacheIndicador cacheIndicador);

    @Query(nativeQuery = true,
            value = "SELECT valor " +
                    "FROM t_cache_indicador " +
                    "WHERE nombre = ?1 " +
                    "AND usuario = ?2 " +
                    "AND empresa = ?2 " +
                    "AND periodo = ?3 " +
                    "LIMIT 1")
    Double getValorCacheado(String nombreIndicador, String usuario,
                            String nombreEmpresa, Integer periodo);

    // Borrar los valores cacheados de la una empresa en un periodo.
    void deleteAllById_EmpresaAndId_Periodo(String empresa, Integer periodo);
}
