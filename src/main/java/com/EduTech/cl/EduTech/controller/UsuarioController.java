package com.EduTech.cl.EduTech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EduTech.cl.EduTech.model.Usuario;
import com.EduTech.cl.EduTech.service.UsuarioService;

//  Anotación para exponer la clase como un controlador REST
@RestController 
// Ruta base para todos los endpoints de este controlador
@RequestMapping("/api/usuarios") 
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección del Servicio
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //  GET: Obtener todos los usuarios (Ruta: /api/usuarios)
    @GetMapping 
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    //  GET: Obtener un usuario por ID (Ruta: /api/usuarios/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        
        // Retorna 200 OK si lo encuentra, 404 NOT FOUND si no
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST: Crear nuevo usuario (Ruta: /api/usuarios)
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        // Retorna 201 CREATED (estándar para la creación exitosa)
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED); 
    }
    
    // DELETE: Eliminar usuario por ID (Ruta: /api/usuarios/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        Optional<Usuario> existingUser = usuarioService.findById(id);
        
        if (existingUser.isPresent()) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}