package com.dds.api;

import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.EmpresaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/empresas")
public class EmpresaController {
    @RequestMapping(method = RequestMethod.GET)
    List<Empresa> getEmpresas() {
        return EmpresaService.getService().getAll();
    }
}
