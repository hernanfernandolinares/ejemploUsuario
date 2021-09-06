package com.ejemploUsuarios.usuarios.Controller;

import com.ejemploUsuarios.usuarios.Entity.Usuario;
import com.ejemploUsuarios.usuarios.Repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(
        @RequestParam(name = "nombre", required = false) String nombre,
        @RequestParam(name = "apellido", required = false) String apellido){
        if (nombre!= null) {
            return new ResponseEntity<>(usuarioRepository.findByNombreContaining(nombre), HttpStatus.OK);
        }
        if(apellido != null) {
            return new ResponseEntity<>(usuarioRepository.findByApellidoContaining(apellido), HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = { "/{id}" })
    public Usuario obtenerUsurioPorId(@PathVariable("id")Integer id){
        return usuarioRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<?> reemplazarUsuarioPorId(@PathVariable("id")Integer id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioExiste= usuarioRepository.findById(id).get();
        if(usuarioExiste!=null){
            usuarioExiste.setNombre(usuario.getNombre());
            usuarioExiste.setApellido(usuario.getApellido());
            return new ResponseEntity<>(usuarioRepository.save(usuarioExiste), HttpStatus.OK);
        }
        return new ResponseEntity<>("el usuario no existe",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = { "/{id}" })
    public void eleminarUsuarioPorId(@PathVariable("id")Integer id){
        usuarioRepository.deleteById(id);
    }
}
