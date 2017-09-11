package com.dds.Metodologias;
import com.dds.Empresas.Empresa;


/**
 * Created by Federico on 11/9/2017.
 */
public class Condicion {

    public Condicion(String numero, String indicador) {
        this.numero = numero;
        this.indicador = indicador;
    }

    private String metodologia;
    private String numero;
    String indicador;
    private String tipo;

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getMetodologia() {return metodologia;}

    public void setMetodologia(String metodologia) {this.metodologia = metodologia;}

    public String getIndicador() {return indicador;}

    public void setIndicador(String indicador) {this.indicador = indicador;}


    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}



   /* public Boolean pasaCondicion(Empresa empresa,int primerAnio, int ultimoAnio){
        no estoy seguro de como terminar este metodo con el pasarConidicon de Metodologia;
    }*/


}

