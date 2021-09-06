package com.ejemploUsuarios.usuarios.Repository;

import com.ejemploUsuarios.usuarios.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

        List<Usuario> findByNombreContaining(String nombre);
        List<Usuario> findByApellidoContaining(String apellio);
}
