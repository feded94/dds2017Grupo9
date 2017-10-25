package com.dds.api;

import com.dds.api.viewmodels.OperadorViewModel;
import com.dds.model.metodologia.operadores.Operador;
import com.dds.model.metodologia.operadores.OperadorFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/operadores")
public class OperadorController {
    @RequestMapping(method = RequestMethod.GET)
    List<OperadorViewModel> getAll() {
        return OperadorViewModel.mapAll(OperadorFactory.getOperadores());
    }

    @RequestMapping(method = RequestMethod.GET, params = {"nombre"})
    OperadorViewModel getByNombre(@RequestParam(value = "nombre") String nombre) {
        return new OperadorViewModel(OperadorFactory.getOperador(nombre));
    }
}
