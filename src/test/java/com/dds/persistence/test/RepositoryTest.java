package com.dds.persistence.test;

import com.dds.persistence.entities.Cuenta;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
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
    public void indicadorTest() {
        indicadorService.save("INDICADOR1", "1+1");
        Assert.assertEquals("1+1", indicadorService.findByName("INDICADOR1").getRegla());
    }

    @Test
    public void cuentaEmpresaTest() {
        Empresa empresa = empresaService.save("EmpresaX", Date.valueOf("2017-01-01"));
        cuentaService.save("Cuenta1", empresa, 0, 1);
    }

    @Test
    public void imprimirCuentasEmpresaX() {
        List<Cuenta> cuentas = cuentaService.findByCompany("EmpresaX");

        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    @Test
    public void buscarCuenta() {
        Empresa empresa = empresaService.save("EmpresaX", Date.valueOf("2017-01-01"));
        cuentaService.save("Cuenta1", empresa, 0, 555);

        Assert.assertEquals(
                555,
                cuentaService.findByPK("Cuenta1", "EmpresaX", 0).getValor(),
                0.
        );
    }

}
