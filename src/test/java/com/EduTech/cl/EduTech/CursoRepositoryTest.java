package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void testGuardarYObtenerCursos() {
        Curso curso = new Curso();
        curso.setTitulo("Spring Boot");
        curso.setDescripcion("Curso de Spring Boot");
        curso.setCategoria("DESARROLLO");
        curso.setEstado("EN_REVISION");

        entityManager.persist(curso);
        entityManager.flush();

        List<Curso> cursos = cursoRepository.findAll();
        assertEquals(1, cursos.size());
        assertEquals("Spring Boot", cursos.get(0).getTitulo());
    }

    @Test
    public void testBuscarPorId() {
        Curso curso = new Curso();
        curso.setTitulo("Spring Boot");
        curso.setDescripcion("Curso de Spring Boot");
        curso.setCategoria("DESARROLLO");
        curso.setEstado("EN_REVISION");

        entityManager.persist(curso);
        entityManager.flush();

        Optional<Curso> encontrado = cursoRepository.findById(curso.getIdCurso());
        assertTrue(encontrado.isPresent());
        assertEquals("Spring Boot", encontrado.get().getTitulo());
    }
}
