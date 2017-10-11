package com.dds.api;

import com.dds.persistence.entities.Usuario;
import com.dds.persistence.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @RequestMapping(method = RequestMethod.GET)
    Usuario getByNombreUsuario(@RequestParam(value = "username") String usuario) {
        return UsuarioService.getService().findByNombreUsuario(usuario);
    }
}
