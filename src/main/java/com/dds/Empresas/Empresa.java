package com.dds.Empresas;

/**
 * Created by Federico on 28/8/2017.
 */

public class Empresa {
    private String _nombre;
    private int _ROE;
    private int _deuda;
    private int _longevidad; //seria la cantidad de años desde la creacion de la empresa

    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {this._nombre = _nombre;}
    public int get_ROE() {return _ROE;}
    public void set_ROE(int _ROE) {this._ROE = _ROE;}
    public int get_deuda() {return _deuda;}
    public void set_deuda(int _deuda) {this._deuda = _deuda;}
    public int get_longevidad() {return _longevidad;}
    public void set_longevidad(int _longevidad) {this._longevidad = _longevidad;}
}
