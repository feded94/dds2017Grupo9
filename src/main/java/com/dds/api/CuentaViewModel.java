package com.dds.api;

import com.dds.persistence.entities.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaViewModel {
    private String nombre;
    private String empresa;
    private int periodo;
    private double valor;

    public CuentaViewModel(Cuenta cuenta) {
        this.nombre = cuenta.getId().getNombreCuenta();
        this.empresa = cuenta.getId().getNombreEmpresa();
        this.periodo = cuenta.getId().getPeriodo();
        this.valor = cuenta.getValor();
    }

    public static List<CuentaViewModel> MapAll(List<Cuenta> cuentas){
        List<CuentaViewModel> cuentasViewModels = new ArrayList<>();

        for (Cuenta cuenta: cuentas) {
            cuentasViewModels.add(new CuentaViewModel(cuenta));
        }

        return cuentasViewModels;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public int getPeriodo() {
        return periodo;
    }

    public double getValor() {
        return valor;
    }
}
