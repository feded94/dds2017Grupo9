package com.dds.persistence.services;

import com.dds.persistence.entities.CacheIndicador;
import com.dds.persistence.entities.CacheIndicadorPK;
import com.dds.persistence.repositories.CacheIndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CacheIndicadorService")
public class CacheIndicadorService {
    @Autowired
    private CacheIndicadorRepository repository;

    private static CacheIndicadorService service;

    @Transactional
    public CacheIndicador save(String indicador,
                               String usuario,
                               String empresa,
                               Integer periodo,
                               Double valor)
    {
        CacheIndicadorPK cacheIndicadorPK = new CacheIndicadorPK();
        cacheIndicadorPK.setNombre(indicador);
        cacheIndicadorPK.setUsuario(usuario);
        cacheIndicadorPK.setPeriodo(periodo);
        cacheIndicadorPK.setEmpresa(empresa);

        CacheIndicador cacheIndicador = new CacheIndicador();
        cacheIndicador.setId(cacheIndicadorPK);
        cacheIndicador.setValor(valor);

        return repository.save(cacheIndicador);
    }

    public Double getValorCacheado(String indicador, String usuario,
                                    String empresa, Integer periodo) {
        return repository.getValorCacheado(indicador, usuario, empresa, periodo);
    }

    public void deleteValorCacheado(String empresa, Integer periodo){
        repository.deleteAllById_EmpresaAndId_Periodo(empresa, periodo);
    }

    public static CacheIndicadorService getService() {
        return service;
    }

    @Autowired
    public void setService(CacheIndicadorService service) {
        CacheIndicadorService.service = service;
    }
}
