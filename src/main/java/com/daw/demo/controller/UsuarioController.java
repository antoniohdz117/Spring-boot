package com.daw.demo.controller;


import com.daw.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired

    // Obtener todos los usuarios
    @GetMapping
    public <Usuario> List<Usuario> getAllUsuarios() {
        CompositeData usuarioService;
        return usuarioService.getAll();
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public <Usuario> Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getById(id).orElse(null);
    }

    // Crear un nuevo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return usuarioService.update(id, usuarioActualizado);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    // Obtener usuarios por ID de Rol
    @GetMapping("/by-rol/{idRol}")
    public List<Usuario> getUsuariosByRol(@PathVariable Long idRol) {
        return usuarioService.getByRolId(idRol);
    }



    // DELETE:elimancion de ususario


}
