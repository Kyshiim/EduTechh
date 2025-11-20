package com.EduTech.cl.EduTech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok @Data genera Getters, Setters, toString, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Anotación que mapea esta clase a una tabla de base de datos
public class Usuario {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementable
    private Integer id;

    // RUN/RUT: Columna obligatoria y única
    @Column(name = "run", length = 13, nullable = false, unique = true)
    private String run;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
}