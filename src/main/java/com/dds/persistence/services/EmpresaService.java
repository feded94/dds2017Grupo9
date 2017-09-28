package com.dds.persistence.services;

import com.dds.persistence.entities.Empresa;
import com.dds.persistence.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("EmpresaService")
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    private static EmpresaService service;

    @Transactional
    public Empresa save(String nombreEmpresa, Date fechaAlta) {
        Empresa empresa = new Empresa();

        empresa.setNombreEmpresa(nombreEmpresa);
        empresa.setFechaAlta(fechaAlta);

        return repository.save(empresa);
    }

    public Empresa find(String nombreEmpresa) {
        return repository.findByNombreEmpresa(nombreEmpresa);
    }

    public Integer getUltimoPeriodo(String nombreEmpresa) {
        return repository.getLastPeriod(nombreEmpresa);
    }

    public List<Integer> getUltimosPeriodos(String nombreEmpresa, int nPeriodos) {
        return repository.getLastPeriods(nombreEmpresa, nPeriodos);
    }

    public Integer getCantidadPeriodos(String nombreEmpresa) {
        return repository.countPeriods(nombreEmpresa);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static EmpresaService getService() {
        return service;
    }

    @Autowired
    public void setService(EmpresaService service) {
        EmpresaService.service = service;
    }
}
