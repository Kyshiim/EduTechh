package com.EduTech.cl.EduTech;


import com.EduTech.cl.EduTech.model.Curso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    @DisplayName("guardar() persiste y listar() devuelve cursos")
    void guardar_y_listar() {
        Curso curso = new Curso();
        curso.setTitulo("Java Avanzado");
        curso.setDescripcion("Conceptos avanzados");
        curso.setCategoria("Programación");
        curso.setEstado("DISPONIBLE");

        cursoRepository.save(curso);

        List<Curso> cursos = cursoRepository.findAll();
        assertThat(cursos).isNotEmpty();
        assertThat(cursos.get(0).getTitulo()).isEqualTo("Java Avanzado");
    }
}
