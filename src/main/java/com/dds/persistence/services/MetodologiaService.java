package com.dds.persistence.services;

import com.dds.model.metodologia.MetodologiaComparativa;
import com.dds.model.metodologia.MetodologiaTaxativa;
import com.dds.persistence.entities.Metodologia;
import com.dds.persistence.repositories.MetodologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MetodologiaService")
public class MetodologiaService {
    @Autowired
    private MetodologiaRepository repository;

    private static MetodologiaService service;

    @Transactional
    public Metodologia save(String usuario, String nombre, MetodologiaTaxativa objMetodologia) {
        Metodologia metodologia = new Metodologia();

        metodologia.setUsuario(UsuarioService.getService().findByNombreUsuario(usuario));
        metodologia.setNombre(nombre);
        metodologia.setCuentaIndicador(objMetodologia.getCuentaIndicador().toString());
        metodologia.setOperador(
                OperadorService.getService().findByNombre(
                        objMetodologia.getOperador().nombre()
                )
        );
        metodologia.setPeriodos(objMetodologia.getPeriodos());
        metodologia.setOperando(objMetodologia.getOperando());

        return repository.save(metodologia);
    }

    @Transactional
    public Metodologia save(String usuario, String nombre, MetodologiaComparativa objMetodologia) {
        Metodologia metodologia = new Metodologia();

        metodologia.setUsuario(UsuarioService.getService().findByNombreUsuario(usuario));
        metodologia.setNombre(nombre);
        metodologia.setCuentaIndicador(objMetodologia.getCuentaIndicador().toString());
        metodologia.setOperador(
                OperadorService.getService().findByNombre(
                        objMetodologia.getOperador().nombre()
                )
        );
        metodologia.setPeriodos(objMetodologia.getPeriodos());
        metodologia.setOperando(null);

        return repository.save(metodologia);
    }

    public Metodologia findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static MetodologiaService getService() {
        return service;
    }

    @Autowired
    public void setService(MetodologiaService service) {
        MetodologiaService.service = service;
    }
}

