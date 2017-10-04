package com.dds.api;

import com.dds.model.CuentaViewModel;
import com.dds.persistence.entities.Cuenta;
import com.dds.persistence.services.CuentaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cuentas")
public class CuentaController {
    @RequestMapping(method = RequestMethod.GET)
    List<CuentaViewModel> getCuentas(@RequestParam(value = "empresa") String empresa)
    {
        List<Cuenta> cuentas = CuentaService.getService().findByCompany(empresa);

        return CuentaViewModel.MapAll(cuentas);
    }
}
