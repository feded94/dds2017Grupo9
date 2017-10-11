package com.dds.persistence.services;

import com.dds.persistence.entities.Usuario;
import com.dds.persistence.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UsuarioService")
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    private static UsuarioService service;

    @Transactional
    public Usuario save(String nombreUsuario, String clave) {
        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setClave(clave);

        return repository.save(usuario);
    }

    public Usuario findByNombreUsuario(String nombreUsuario) {
        return repository.findByNombreUsuario(nombreUsuario);
    }

    public boolean validarUsuario(String nombreUsuario, String clave) {
        return findByNombreUsuario(nombreUsuario).getClave().equals(clave);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }

    public static UsuarioService getService() {
        return service;
    }

    @Autowired
    public void setService(UsuarioService service) {
        UsuarioService.service = service;
    }
}
