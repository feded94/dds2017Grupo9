package com.dds.persistence;

import com.dds.model.CuentaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
