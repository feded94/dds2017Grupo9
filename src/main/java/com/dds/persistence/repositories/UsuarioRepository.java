package com.dds.persistence.repositories;

import com.dds.persistence.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario save(Usuario usuario);
    Usuario findByNombreUsuario(String nombreUsuario);
}
