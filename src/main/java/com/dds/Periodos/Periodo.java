package com.dds.Periodos;
import java.util.Date;

/**
 * Created by Federico on 16/09/2017.
 */

public class Periodo {

    private Date fechaInicio;

    private Date fechaFin;

    public Date getfechaInicio() {
        return fechaInicio;
    }

    public void setfechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }



    public Date getfechaFin(){return fechaFin;}

    public void setfechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    public Periodo(){

    }

}
