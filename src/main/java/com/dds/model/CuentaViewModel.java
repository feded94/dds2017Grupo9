package com.dds.model;

import com.dds.persistence.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaViewModel {
    private Long id;
    private String empresa;
    private String nombre;
    private String periodo;
    private String tipo;
    private int valor;

    public CuentaViewModel(Cuenta cuenta){
        this.id = cuenta.getCuentaID();
        this.empresa = cuenta.getEmpresa().getNombre();
        this.nombre = cuenta.getNombre();
        this.periodo = cuenta.getPeriodoString();
        this.tipo = cuenta.getTipo();
        this.valor = cuenta.getValor();
    }

    public static List<CuentaViewModel> MapAll(List<Cuenta> cuentas){
        List<CuentaViewModel> cuentasViewModels = new ArrayList<CuentaViewModel>();
        for (Cuenta cuenta:
             cuentas) {
            cuentasViewModels.add(new CuentaViewModel(cuenta));
        }
        return cuentasViewModels;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public int getValor() {return valor;}
    public String getPeriodo() {return periodo;}
    public String getEmpresa() {
        return empresa;
    }
}
