package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;

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

    @Test
    public void testActualizar() {
        CursoRepository repository = new CursoRepository();
        Curso curso = new Curso(1, "Spring Boot", "Curso de Spring Boot", "DESARROLLO", "EN_REVISION");
        repository.guardar(curso);

        Curso cursoActualizado = new Curso(1, "Spring Boot Avanzado", "Curso avanzado de Spring Boot", "DESARROLLO", "EN_REVISION");
        repository.actualizar(cursoActualizado);

        assertEquals("Spring Boot Avanzado", repository.buscarPorId(1).getTitulo());
    }

    @Test
    public void testEliminar() {
        CursoRepository repository = new CursoRepository();
        Curso curso = new Curso(1, "Spring Boot", "Curso de Spring Boot", "DESARROLLO", "EN_REVISION");
        repository.guardar(curso);

        repository.eliminar(1);
        assertNull(repository.buscarPorId(1));
    }
}
