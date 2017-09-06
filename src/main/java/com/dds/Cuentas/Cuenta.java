package com.dds.Cuentas;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by USER on 19-Apr-17.
 */

@Entity 
@Table(name="cuentas")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
    private Long cuentaID;
	@Column(name = "nombre")
    private String _nombre;


	@Column(name= "tipo")
    private String _tipo;
	@Column(name = "valor")
    private int _valor;
    private Date _periodo;


	public Long getCuentaID() {
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