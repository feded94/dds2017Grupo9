package com.dds.persistence.services;

import com.dds.persistence.entities.Operador;
import com.dds.persistence.repositories.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OperadorService")
public class OperadorService {
    @Autowired
    private OperadorRepository repository;

    private static OperadorService service;

    @Transactional
    public Operador save(String nombre, Operador.Tipo tipo, String descripcion) {
        Operador operador = new Operador();

        operador.setNombre(nombre);
        operador.setTipo(tipo);
        operador.setDescripcion(descripcion);

        return repository.save(operador);
    }

    public Operador findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Operador> getAll() {
        return repository.findAll();
    }

    public List<Operador> getUnarios() {
        return repository.findByTipo(Operador.Tipo.UNARIO);
    }

    public List<Operador> getBinarios() {
        return repository.findByTipo(Operador.Tipo.BINARIO);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static OperadorService getService() {
        return service;
    }

    @Autowired
    public void setService(OperadorService service) {
        OperadorService.service = service;
    }
}
