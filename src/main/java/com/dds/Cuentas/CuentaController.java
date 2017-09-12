package com.dds.Cuentas;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by USER on 19-Apr-17.
 */
@RestController
@RequestMapping("api/cuentas")
public class CuentaController {
    @RequestMapping(method = RequestMethod.GET)
    Collection<Cuenta> getCuentas() {
        Collection<Cuenta> cuentas = new ArrayList<Cuenta>();
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNombre("EE");
        cuenta1.setValor(532);
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNombre("FCF");
        cuenta2.setValor(1235);
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        return cuentas;
    }
}
