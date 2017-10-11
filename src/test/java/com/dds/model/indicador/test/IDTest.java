package com.dds.model.indicador.test;

import com.dds.model.indicador.*;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.entities.Usuario;
import com.dds.persistence.services.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IDTest {
    public static final double Cuenta1 = 10;
    public static final double Cuenta2 = 20;
    public static final double Cuenta3 = 30;

    private IndicadorService indicadorService;
    private CuentaService cuentaService;
    private EmpresaService empresaService;

    @Before
    public void initialize() {
        indicadorService = IndicadorService.getService();
        cuentaService = CuentaService.getService();
        empresaService = EmpresaService.getService();

        indicadorService.clearAll();
        cuentaService.clearAll();
        empresaService.clearAll();
    }

    @Test
    public void obtenerValorIDTest() throws IndicadorException {
        Empresa empresa = empresaService.save("Empresa1", Date.valueOf("2017-01-01"));

        cuentaService.save("Cuenta1", empresa, 0, Cuenta1);
        cuentaService.save("Cuenta2", empresa, 0, Cuenta2);
        cuentaService.save("Cuenta3", empresa, 0, Cuenta3);

        Usuario usuario = UsuarioService.getService().save("Usuario", "123");

        indicadorService.save("Usuario", "Sumar3Cuentas", "Cuenta1 + Cuenta2 + Cuenta3");
        indicadorService.save("Usuario", "CalculosRaros", "Cuenta1 * Cuenta2 / (Cuenta3 - Cuenta1) + 50");

        Assert.assertEquals(
                Cuenta1 + Cuenta2 + Cuenta3,
                Indicador.parseFromString(indicadorService.findByName("Sumar3Cuentas").getRegla())
                        .getResultado("Empresa1", 0),
                0.1
        );
    }

    @Test
    public void obtenerValorIDTest2() throws IndicadorException {
        Empresa empresa = empresaService.save("Empresa1", Date.valueOf("2017-01-01"));

        /*
        indicadorService.save("Sumar3Indicadores", "Indicador1 + Indicador2 + Indicador3");

        indicadorService.save("Indicador1", "10");
        indicadorService.save("Indicador2", "20");
        indicadorService.save("Indicador3", "30");
        */

        Assert.assertEquals(
                10 + 20 + 30,
                Indicador.parseFromString(indicadorService.findByName("Sumar3Indicadores").getRegla())
                        .getResultado("Empresa1", 0),
                0.1
        );
    }
}
