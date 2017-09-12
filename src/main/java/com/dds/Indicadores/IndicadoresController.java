package com.dds.Indicadores;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("api/indicadores")
public class IndicadoresController {
    private static ArrayList<IndicadorBusiness> _indicadores;

    public IndicadoresController(){
        _indicadores = new ArrayList<IndicadorBusiness>();
    }

    @RequestMapping(method = RequestMethod.POST)
    void saveIndicador(@RequestBody IndicadorBusiness indicador) {
        try {
            indicador.parse();
        }
        catch(Exception ex) {
            throw new IndicadorException();
        }
        _indicadores.add(indicador);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<IndicadorBusiness> getIndicadores() {
        return _indicadores;
    }
}
