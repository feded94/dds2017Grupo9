package com.dds.Cuentas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by USER on 19-Apr-17.
 */

@Entity 
@Table(name="cuentas")

public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long cuentaID;
	@Column(name = "nombre")
    private String _nombre;


	@Column(name= "tipo")
    private String _tipo;
	@Column(name = "valor")
    private int _valor;

	public long getCuentaID() {
		return cuentaID;
	}
	public void setCuentaID(long cuentaID) {
		this.cuentaID = cuentaID;
	}
	
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
