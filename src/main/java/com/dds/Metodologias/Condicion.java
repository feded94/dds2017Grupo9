package com.dds.Metodologias;
import com.dds.Empresas.Empresa;
import com.dds.Indicadores.IndicadorBusiness;
import com.dds.indicador.Indicador;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Created by Federico on 11/9/2017.
 */
@Entity
@Table(name="condiciones")
public class Condicion {

	@Id
	@GeneratedValue
	private Long ID;
	
	
	@ManyToMany
	Collection <Metodologia> metodologias = new ArrayList<Metodologia>();
    private String numero;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Indicador_id)")
    private Indicador indicador;
    private String tipo;

    public Condicion(){
    	
    }
    

    /*public Condicion(String numero, String indicador) {
        this.numero = numero;
        this.indicador = indicador;
    }*/
    
    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    /*public String getMetodologia() {
    	return metodologia;
    	}

    public void setMetodologia(String metodologia)
    {
    	this.metodologia = metodologia;
    	}*/

    public Indicador getIndicador() {
    	return indicador;
    	}

    public void setIndicador(Indicador indicador)
    {
    	this.indicador = indicador;
    	}


    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }


   /* public Boolean pasaCondicion(Empresa empresa,int primerAnio, int ultimoAnio){
        no estoy seguro de como terminar este metodo con el pasarConidicon de Metodologia;
    }*/


}

