package com.EduTech.cl.EduTech.controller;

import com.EduTech.cl.EduTech.model.Usuario;
import com.EduTech.cl.EduTech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!usuarioService.obtenerUsuarioPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setIdUsuario(id);
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (!usuarioService.obtenerUsuarioPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
