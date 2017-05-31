package com.dds.Cuentas;

/**
 * Created by USER on 19-Apr-17.
 */
public class Cuenta {
    private String _nombre;
    private String _tipo;
    private int _valor;

    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    public String get_tipo() {
        return _tipo;
    }
    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }
    public int get_valor() {
        return _valor;
    }
    public void set_valor(int _valor) {
        this._valor = _valor;
    }

    public Integer ConsultarValor(Integer periodo){
        return 0;
    }
}
