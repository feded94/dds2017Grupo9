package com.dds.api;

import com.dds.api.viewmodels.MetodologiaViewModel;
import com.dds.persistence.services.MetodologiaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/metodologias")
public class MetodologiaController {
    @RequestMapping(method = RequestMethod.GET)
    MetodologiaViewModel getByNombre(@RequestParam(value = "nombre") String nombre) {
        return new MetodologiaViewModel(MetodologiaService.getService().findByNombre(nombre));
    }

}
