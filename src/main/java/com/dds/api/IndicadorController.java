package com.dds.api;

import com.dds.persistence.IndicadorException;
import com.dds.persistence.entities.Indicador;
import com.dds.persistence.services.IndicadorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/indicadores")
public class IndicadorController {
    @RequestMapping(method = RequestMethod.POST)
    void saveIndicador(@RequestBody Indicador indicador) {
        try {
            com.dds.model.indicador.Indicador indicadorGenerado =
                    com.dds.model.indicador.Indicador.parseFromString(indicador.getRegla());

            if (indicadorGenerado == null)
                throw new Exception();
        }
        catch (Exception ex) {
            throw new IndicadorException();
        }

        IndicadorService.getService().save(indicador.getUsername(), indicador.getNombre(), indicador.getRegla());
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Indicador> getIndicadores() {
        return IndicadorService.getService().getAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"empresa", "periodo"})
    List<IndicadorEvaluado> getIndicadores(
            @RequestParam(value = "empresa") String empresa,
            @RequestParam(value = "periodo") Integer periodo)
    {
        List<Indicador> indicadores = this.getIndicadores();
        List<IndicadorEvaluado> indicadoresEvaluados = new ArrayList<>();

        for (Indicador indicador : indicadores) {
            IndicadorEvaluado indicadorEvaluado = new IndicadorEvaluado();

            indicadorEvaluado.setNombre(indicador.getNombre());

            try {
                indicadorEvaluado.setValor(
                        com.dds.model.indicador.Indicador.parseFromString(
                                indicador.getRegla()
                        ).getResultado(empresa, periodo)
                );
                indicadoresEvaluados.add(indicadorEvaluado);
            }
            catch (Exception e) { }
        }

        return indicadoresEvaluados;
    }

    class IndicadorEvaluado {
        private String nombre;
        private double valor;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }
}
