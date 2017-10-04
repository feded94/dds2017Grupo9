package com.dds.persistence.services;

import com.dds.persistence.entities.Indicador;
import com.dds.persistence.repositories.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("IndicadorService")
public class IndicadorService {
    @Autowired
    private IndicadorRepository repository;

    private static IndicadorService service;

    @Transactional
    public Indicador save(String name, String regla) {
        Indicador indicador = new Indicador();

        indicador.setNombre(name);
        indicador.setRegla(regla);

        return repository.save(indicador);
    }

    public List<Indicador> getAll() {
        List<Indicador> indicadores = new ArrayList<>();
        repository.findAll().forEach(indicadores::add);
        return indicadores;
    }

    public Indicador findByName(String name) {
        return repository.findByNombre(name);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static IndicadorService getService() {
        return service;
    }

    @Autowired
    public void setService(IndicadorService service) {
        IndicadorService.service = service;
    }
}
