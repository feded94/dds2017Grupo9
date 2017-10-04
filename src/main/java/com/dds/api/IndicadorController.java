package com.dds.api;

import com.dds.persistence.IndicadorException;
import com.dds.persistence.entities.Indicador;
import com.dds.persistence.services.IndicadorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

        IndicadorService.getService().save(indicador.getNombre(), indicador.getRegla());
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Indicador> getIndicadores() {
        return IndicadorService.getService().getAll();
    }
}
