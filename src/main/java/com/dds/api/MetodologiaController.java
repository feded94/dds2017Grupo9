package com.dds.api;

import com.dds.persistence.entities.Metodologia;
import com.dds.persistence.services.MetodologiaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/metodologias")
public class MetodologiaController {
    @RequestMapping(method = RequestMethod.GET)
    Metodologia getByNombre(@RequestParam(value = "nombre") String nombre) {
        return MetodologiaService.getService().findByNombre(nombre);
    }
}
