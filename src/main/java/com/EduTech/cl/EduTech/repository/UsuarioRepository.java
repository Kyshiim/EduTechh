package com.EduTech.cl.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EduTech.cl.EduTech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
