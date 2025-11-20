package com.EduTech.cl.EduTech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.EduTech.cl.EduTech.model.Usuario;
import com.EduTech.cl.EduTech.repository.UsuarioRepository;

//  Anotación que marca la clase como un componente de servicio
@Service 
public class UsuarioService {

    // Inyectamos el Repositorio para poder acceder a la base de datos
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //  Método para obtener todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //  Método para buscar un usuario por su ID
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    //  Método para guardar (crear o actualizar) un usuario
    public Usuario save(Usuario usuario) {
        // **Lógica de Negocio aquí**
        // Por ahora, solo guarda directamente:
        return usuarioRepository.save(usuario);
    }
    
    //  Método para eliminar un usuario
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}