package com.dds.persistence;
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
	
	@ManyToOne
	@JoinColumn(name="empresa")
	private Empresa empresa;
	
	@Column(name = "nombre")
    private String nombre;

    private Date periodo;

	@Column(name= "tipo")
    private String tipo;
	@Column(name = "valor")
    private int valor;

	/*@Column(name="periodo")
    private Periodo periodo;*/


    
    public Cuenta(){
    
    }

	public Long getCuentaID() {
		return cuentaID;
	}
	public void setCuentaID(long cuentaID) {
		this.cuentaID = cuentaID;
	}
	
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {this.tipo = tipo;}
    public int getValor() {return valor;}
    public void setValor(int valor) {
        this.valor = valor;
    }


    public Date getPeriodo() {return periodo;}
    public void setPeriodo(Date _periodo) {
        this.periodo = _periodo;
    }


    public String getPeriodoString() {    //Necesario para Empresa
        return new SimpleDateFormat("yyyyMMdd").format(this.periodo);
    }

   /* public Periodo getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }*/

	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}