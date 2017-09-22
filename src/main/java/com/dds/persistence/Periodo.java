package com.dds.persistence;

import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue
    private Long ID;

    private Date fechaInicio;
    private Date fechaFin;

    public Date getfechaInicio() {
        return fechaInicio;
    }

    public void setfechaInicio(Date _fechaInicio) {
        this.fechaInicio = _fechaInicio;
    }



    public Date getfechaFin(){return fechaFin;}

    public void setfechaFin(Date _fechaFin) {
        this.fechaFin = _fechaFin;
    }


    public Periodo(){

    }

}
