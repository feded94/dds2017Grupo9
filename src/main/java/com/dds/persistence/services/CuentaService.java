package com.dds.persistence.services;

import com.dds.persistence.entities.Cuenta;
import com.dds.persistence.entities.CuentaPK;
import com.dds.persistence.entities.Empresa;
import com.dds.persistence.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("CuentaService")
public class CuentaService {
    @Autowired
    private CuentaRepository repository;

    private static CuentaService service;

    @Transactional
    public Cuenta save(String nombreCuenta, Empresa empresa, Integer periodo, double valor) {
        CuentaPK cuentaPK = new CuentaPK();

        cuentaPK.setNombreCuenta(nombreCuenta);
        cuentaPK.setPeriodo(periodo);
        cuentaPK.setNombreEmpresa(empresa.getNombreEmpresa());

        Cuenta cuenta = new Cuenta();

        cuenta.setEmpresa(empresa);
        cuenta.setId(cuentaPK);
        cuenta.setValor(valor);

        // Al actualizar la cuenta, se borran los valores cacheados de los indicadores asociados.
        CacheIndicadorService.getService().deleteValorCacheado(empresa.getNombreEmpresa(), periodo);

        return repository.save(cuenta);
    }

    @Transactional
    public Cuenta save(String nombreCuenta, String nombreEmpresa, Integer periodo, double valor) {
        Empresa empresa = EmpresaService.getService().find(nombreEmpresa);
        if (empresa == null) {
            System.err.println("No existe la empresa \"" + nombreEmpresa + "\".");
            return null;
        }

        return save(nombreCuenta, empresa, periodo, valor);
    }

    public List<Cuenta> getAll() {
        List<Cuenta> cuentas = new ArrayList<>();
        repository.findAll().forEach(cuentas::add);
        return cuentas;
    }

    public Cuenta findByPK(String nombreCuenta, String nombreEmpresa, Integer periodo) {
        return repository.findById_NombreCuentaAndId_NombreEmpresaAndId_Periodo(
                nombreCuenta, nombreEmpresa, periodo
        );
    }

    public List<Cuenta> findByCompany(String nombreEmpresa) {
        return repository.findById_NombreEmpresa(nombreEmpresa);
    }

    public List<Cuenta> findByCompanyAndPeriod(String nombreEmpresa, Integer periodo) {
        return repository.findById_NombreEmpresaAndId_Periodo(nombreEmpresa, periodo);
    }

    public List<Cuenta> findByPeriod(Integer periodo) {
        return repository.findById_Periodo(periodo);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static CuentaService getService() {
        return service;
    }

    @Autowired
    public void setService(CuentaService service) {
        CuentaService.service = service;
    }
}
