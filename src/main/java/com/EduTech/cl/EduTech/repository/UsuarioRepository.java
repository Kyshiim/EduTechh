package com.EduTech.cl.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EduTech.cl.EduTech.model.Usuario;

@Repository // Marca esta interfaz como un componente de acceso a datos
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Hereda todos los métodos CRUD básicos (save, findById, findAll, etc.)
}