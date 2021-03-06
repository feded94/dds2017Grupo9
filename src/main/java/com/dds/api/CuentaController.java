package com.dds.api;

import com.dds.api.viewmodels.CuentaViewModel;
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
    @RequestMapping(method = RequestMethod.GET, params = {"empresa", "periodo"})
    List<CuentaViewModel> getCuentas(
            @RequestParam(value = "empresa", required = false) String empresa,
            @RequestParam(value = "periodo", required = false) Integer periodo)
    {
        List<Cuenta> cuentas = CuentaService.getService().findByCompanyAndPeriod(empresa, periodo);

        return CuentaViewModel.MapAll(cuentas);
    }

    @RequestMapping(method = RequestMethod.GET, params = "empresa")
    List<CuentaViewModel> getCuentas(@RequestParam(value = "empresa", required = false) String empresa)
    {
        List<Cuenta> cuentas = CuentaService.getService().findByCompany(empresa);

        return CuentaViewModel.MapAll(cuentas);
    }

    @RequestMapping(method = RequestMethod.GET, params = "periodo")
    List<CuentaViewModel> getCuentas(@RequestParam(value = "periodo", required = false) Integer periodo)
    {
        List<Cuenta> cuentas = CuentaService.getService().findByPeriod(periodo);

        return CuentaViewModel.MapAll(cuentas);
    }
}
