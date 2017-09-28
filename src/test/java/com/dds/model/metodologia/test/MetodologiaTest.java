package com.dds.model.metodologia.test;

import com.dds.model.metodologia.MetodologiaBuilder;
import com.dds.model.metodologia.MetodologiaException;
import com.dds.model.metodologia.MetodologiaTaxativa;
import com.dds.model.metodologia.operadores.unarios.Creciente;
import com.dds.model.metodologia.operadores.unarios.CrecienteEstricto;
import com.dds.model.metodologia.operadores.unarios.Decreciente;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.services.CuentaService;
import com.dds.persistence.services.EmpresaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetodologiaTest {
    private CuentaService cuentaService;
    private EmpresaService empresaService;

    @Before
    public void initialize() {
        cuentaService = CuentaService.getService();
        empresaService = EmpresaService.getService();

        cuentaService.clearAll();
        empresaService.clearAll();
    }

    @Test
    public void validarMetodologiaTaxativaCreciente() throws MetodologiaException {
        MetodologiaTaxativa metodologia = new MetodologiaBuilder()
                .setIDYPeriodo("CuentaX", 4)
                .setOperador(new Creciente());

        Empresa empresa = EmpresaService.getService().save("EmpresaX", Date.valueOf("2017-01-01"));
        CuentaService service = CuentaService.getService();

        service.save("CuentaX", empresa, 0, 2);
        service.save("CuentaX", empresa, 2, 3);
        service.save("CuentaX", empresa, 6, 5);
        service.save("CuentaX", empresa, 7, 9);

        Assert.assertTrue(metodologia.evaluar(empresa));

        service.save("CuentaX", empresa, 10, 6);

        Assert.assertFalse(metodologia.evaluar(empresa));
    }

    @Test
    public void validarMetodologiaTaxativaDecreciente() throws MetodologiaException {
        MetodologiaTaxativa metodologia = new MetodologiaBuilder()
                .setIDYPeriodo("CuentaX", 4)
                .setOperador(new Decreciente());

        Empresa empresa = EmpresaService.getService().save("EmpresaX", Date.valueOf("2017-01-01"));
        CuentaService service = CuentaService.getService();

        service.save("CuentaX", empresa, 0, 50);
        service.save("CuentaX", empresa, 2, 30);
        service.save("CuentaX", empresa, 6, 22.5);
        service.save("CuentaX", empresa, 7, 15.6);

        Assert.assertTrue(metodologia.evaluar(empresa));

        service.save("CuentaX", empresa, 10, 15.6);

        Assert.assertTrue(metodologia.evaluar(empresa));

        service.save("CuentaX", empresa, 12, 15.601);

        Assert.assertFalse(metodologia.evaluar(empresa));
    }

    @Test
    public void validarMetodologiaTaxativaCrecienteEstricto() throws MetodologiaException {
        MetodologiaTaxativa metodologia = new MetodologiaBuilder()
                .setIDYPeriodo("CuentaX", 4)
                .setOperador(new CrecienteEstricto());

        Empresa empresa = EmpresaService.getService().save("EmpresaX", Date.valueOf("2017-01-01"));
        CuentaService service = CuentaService.getService();

        service.save("CuentaX", empresa, 0, 50);
        service.save("CuentaX", empresa, 2, 60);
        service.save("CuentaX", empresa, 6, 92.5);
        service.save("CuentaX", empresa, 7, 92.6);

        Assert.assertTrue(metodologia.evaluar(empresa));

        service.save("CuentaX", empresa, 10, 92.601);

        Assert.assertTrue(metodologia.evaluar(empresa));

        service.save("CuentaX", empresa, 12, 92.601);

        Assert.assertFalse(metodologia.evaluar(empresa));
    }
}
