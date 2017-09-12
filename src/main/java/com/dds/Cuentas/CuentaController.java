package com.dds.Cuentas;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("api/cuentas")
public class CuentaController {
    @RequestMapping(method = RequestMethod.GET)
    Collection<Cuenta> getCuentas() {
        Collection<Cuenta> cuentas = new ArrayList<Cuenta>();
        Cuenta cuenta1 = new Cuenta();
        cuenta1.set_nombre("EE");
        cuenta1.set_valor(532);
        Cuenta cuenta2 = new Cuenta();
        cuenta2.set_nombre("FCF");
        cuenta2.set_valor(1235);
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        return cuentas;
    }
}
