package com.dds.api;

import com.dds.api.viewmodels.MetodologiaViewModel;
import com.dds.persistence.entities.Metodologia;
import com.dds.persistence.services.MetodologiaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/metodologias")
public class MetodologiaController {
    @RequestMapping(method = RequestMethod.GET)
    List<MetodologiaViewModel> getMetodologias() {
        return MetodologiaViewModel.mapAll(MetodologiaService.getService().getAll());
    }

    @RequestMapping(method = RequestMethod.GET, params = {"nombre"})
    MetodologiaViewModel getMetodologia(@RequestParam(value = "nombre") String nombre) {
        try {
            return new MetodologiaViewModel(MetodologiaService.getService().findByNombre(nombre));
        }
        catch (NullPointerException e) {
            throw new RuntimeException("No existe la metodologia \"" + nombre + "\".");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    void saveMetodologia(@RequestBody Metodologia metodologia) {
        MetodologiaService.getService().save(metodologia);
    }
}
