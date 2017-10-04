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

        Cuenta cuenta = new Cuenta();

        cuenta.setEmpresa(empresa);
        cuenta.setId(cuentaPK);
        cuenta.setValor(valor);

        return repository.save(cuenta);
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
