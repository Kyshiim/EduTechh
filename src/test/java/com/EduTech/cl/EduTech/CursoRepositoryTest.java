package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.model.Curso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CursoRepositoryTest {

    @Test
    public void testGuardarYObtenerCursos() {
        CursoRepository repository = new CursoRepository();
        Curso curso = new Curso(1, "Spring Boot", "Curso de Spring Boot", "DESARROLLO", "EN_REVISION");
        repository.guardar(curso);

        assertEquals(1, repository.obtenerCursos().size());
        assertEquals("Spring Boot", repository.obtenerCursos().get(0).getTitulo());
    }

    @Test
    public void testBuscarPorId() {
        CursoRepository repository = new CursoRepository();
        Curso curso = new Curso(1, "Spring Boot", "Curso de Spring Boot", "DESARROLLO", "EN_REVISION");
        repository.guardar(curso);

        assertNotNull(repository.buscarPorId(1));
        assertEquals("Spring Boot", repository.buscarPorId(1).getTitulo());
    }
}

