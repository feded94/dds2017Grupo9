package com.dds.persistence.test;

import com.dds.model.metodologia.MetodologiaBuilder;
import com.dds.persistence.entities.Cuenta;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.*;
import edu.emory.mathcs.backport.java.util.Arrays;
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
    private UsuarioService usuarioService;
    private MetodologiaService metodologiaService;

    @Before
    public void initialize() {
        indicadorService = IndicadorService.getService();
        cuentaService = CuentaService.getService();
        empresaService = EmpresaService.getService();
        usuarioService = UsuarioService.getService();

        indicadorService.clearAll();
        cuentaService.clearAll();
        empresaService.clearAll();
        usuarioService.clearAll();
    }

    @Test
    public void indicadorTest() {
        usuarioService.save("USUARIO1", "123");
        indicadorService.save("USUARIO1", "INDICADOR1", "1+1");
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

    @Test
    public void consultaPeriodosTest() {
        Empresa empresa = empresaService.save("EmpresaX", Date.valueOf("2017-01-01"));
        cuentaService.save("Cuenta", empresa, 0, 0);
        cuentaService.save("Cuenta", empresa, 1, 112);
        cuentaService.save("Cuenta2", empresa, 1, 112);
        cuentaService.save("Cuenta3", empresa, 1, 111);
        cuentaService.save("Cuenta2", empresa, 3, 333);

        Assert.assertEquals(
                3,
                empresaService.getUltimoPeriodo("EmpresaX"),
                0
        );

        Assert.assertEquals(
                3,
                empresaService.getCantidadPeriodos("EmpresaX"),
                0
        );

        cuentaService.save("Cuenta5", empresa, 9, 999);
        cuentaService.save("Cuenta5", empresa, 15, 151515);

        Assert.assertEquals(
                15,
                empresaService.getUltimoPeriodo("EmpresaX"),
                0
        );

        Assert.assertEquals(
                5,
                empresaService.getCantidadPeriodos("EmpresaX"),
                0
        );

        List<Integer> expectedPeriodos = Arrays.asList(new Integer[]{0, 1, 3, 9, 15});
        List<Integer> actualPeriodos = empresaService.getUltimosPeriodos("EmpresaX", 5);

        Assert.assertTrue(actualPeriodos.containsAll(expectedPeriodos));
        Assert.assertTrue(actualPeriodos.size() == expectedPeriodos.size());
    }

    @Test
    public void consultaPeriodosTest2() {
        Assert.assertEquals(
                0,
                empresaService.getCantidadPeriodos("EmpresaX"),
                0
        );

        Assert.assertEquals(
                null,
                empresaService.getUltimoPeriodo("EmpresaX")
        );
    }
}
