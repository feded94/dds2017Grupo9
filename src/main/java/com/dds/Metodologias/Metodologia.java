package com.dds.Metodologias;
import com.dds.Empresas.Empresa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="metodologias")
public class Metodologia {

		@Id
		@GeneratedValue
		private Long ID;
		
        private String _nombreMetodologia;

        @ManyToMany(mappedBy="metodologias", cascade = CascadeType.ALL)
        Collection <Condicion> condiciones = new ArrayList<Condicion>();




        public String getNombreMetodologia() {return _nombreMetodologia;}

        public void setNombreMetodologia(String nombreMetodologia) {this._nombreMetodologia = nombreMetodologia;}



        public Collection<Condicion> getCondiciones() {
            return condiciones;
        }

        public void addCondicion(Condicion condicion) {
           condiciones.add(condicion);
        }

        public void addCondiciones(ArrayList<Condicion> condicionesAAgregar){
            condicionesAAgregar.forEach(condicion -> addCondicion(condicion));
        }

       /* public boolean pasaCondiciones(Empresa empresa, int primerAnio, int anioHasta){
            return condiciones.stream().allMatch(condicion -> condicion.pasaCondicion(empresa, primerAnio, anioHasta));
            for(int i = 0; i < condiciones.size(); i++){
                if(condiciones.get(i).pasaCondicion(empresa, primerAnio, anioHasta))){
                return condiciones.stream().allMatch(condicion -> condicion.pasaCondicion(empresa, primerAnio, anioHasta));
                }
            }
            return pasar;
        }*/



    }