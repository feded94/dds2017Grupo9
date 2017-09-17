package com.dds.Empresas;
import com.dds.Cuentas.Cuenta;
import com.dds.Periodos.Periodo;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
//import java.io.Serializable;

import javax.persistence.*;


/**
 * Created by Federico on 28/8/2017.
 */
@Entity
@Table(name="empresas")
public class Empresa {
	
	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
    private String nombre;
    @OneToMany(mappedBy="empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas = new ArrayList<>();
    
    
    
    public Empresa() {
    
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public void setNombre(String nombre){
    	this.nombre=nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public List<Cuenta> getCuentas() {
        return this.cuentas;
    }




    public int sizeCuentas() {  //Tamaño Lista
        return cuentas.size();
    }


   public boolean contains_cuenta(String tipo, String periodo) throws ParseException { //Devuelve bool si contiene o no el tipo de cuenta en un periodo
        return this.getCuentas().stream().anyMatch(c -> (tipo.equals(c.getTipo()))
                && (periodo.equals(c.getPeriodoString())));
    }

        public void addCuenta(Cuenta cuenta) throws ParseException {   //Agrega la cuenta en la lista
        if (!this.contains_cuenta(cuenta.getTipo(), cuenta.getPeriodoString())) {
            this.getCuentas().add(cuenta);
            cuenta.setEmpresa(this);
        }
    }

    public Cuenta getCuenta(String tipo, String periodo) throws ParseException {    //Devuelve la cuenta del tipo, para un periodo
        return getCuentas().stream().filter(c -> (tipo.equals(c.getTipo()))
                && (periodo.equals(c.getPeriodoString()))).
                findFirst().orElse(null);
    }


}