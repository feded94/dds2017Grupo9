package com.dds.Empresas;
import com.dds.Cuentas.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;

/**
 * Created by Federico on 28/8/2017.
 */

public class Empresa {
    private String _nombre;
    private List<Cuenta> _cuentas;

    public Empresa(String nombre) {
        this._nombre = nombre;
        this._cuentas = new ArrayList<Cuenta>();
    }

    public String get_nombre() {
        return this._nombre;
    }

    public List<Cuenta> get_cuentas() {
        return this._cuentas;
    }




    public int size_cuentas() {  //Tamaño Lista
        return _cuentas.size();
    }

    public boolean contains_cuenta(String tipo, String periodo) throws ParseException { //Devuelve bool si contiene o no el tipo de cuenta en un periodo
        return this.get_cuentas().stream().anyMatch(c -> (tipo.equals(c.get_tipo()))
                && (periodo.equals(c.get_periodoString())));
    }

        public void add_cuenta(Cuenta cuenta) throws ParseException {   //Agrega la cuenta en la lista
        if (!this.contains_cuenta(cuenta.get_tipo(), cuenta.get_periodoString())) {
            this.get_cuentas().add(cuenta);
        }
    }

    public Cuenta get_cuenta(String tipo, String periodo) throws ParseException {    //Devuelve la cuenta del tipo, para un periodo
        return get_cuentas().stream().filter(c -> (tipo.equals(c.get_tipo()))
                && (periodo.equals(c.get_periodoString()))).
                findFirst().orElse(null);
    }

}