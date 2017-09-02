package com.dds.Cuentas;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by USER on 19-Apr-17.
 */
public class Cuenta {
    private String _nombre;
    private String _tipo;
    private int _valor;
    private Date _periodo;


    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    public String get_tipo() {
        return _tipo;
    }
    public void set_tipo(String _tipo) {this._tipo = _tipo;}
    public int get_valor() {return _valor;}
    public void set_valor(int _valor) {
        this._valor = _valor;
    }

    public Date get_periodo() {return _periodo;}
    public void set_periodo(Date _periodo) {
        this._periodo = _periodo;
    }


    public String get_periodoString() {    //Necesario para Empresa
        return new SimpleDateFormat("yyyyMMdd").format(this._periodo);
    }


    public Integer ConsultarValor(Date _periodo){
        return 0;
    } //verificar si ConsultarVelor sigue funcionando con el Date


}
