package com.dds.Cuentas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/cuentas")
public class CuentaController {
    @Autowired
    CuentaRepository cuentaRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<CuentaViewModel> getCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return CuentaViewModel.MapAll(cuentas);
    }
}
