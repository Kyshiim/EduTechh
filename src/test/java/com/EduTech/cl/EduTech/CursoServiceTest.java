package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.service.CursoService;
import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("guardarCurso() persiste y devuelve el curso")
    void guardar_ok() {
        Curso c = new Curso();
        c.setIdCurso(1L);
        c.setTitulo("Spring Boot desde cero");
        c.setDescripcion("Curso completo para aprender Spring Boot");
        c.setCategoria("Backend");
        c.setEstado("DISPONIBLE");

        when(cursoRepository.guardar(any(Curso.class))).thenReturn(c);

        Curso guardado = cursoService.guardarCurso(c);

        ArgumentCaptor<Curso> captor = ArgumentCaptor.forClass(Curso.class);
        verify(cursoRepository, times(1)).guardar(captor.capture());
        assertThat(captor.getValue().getTitulo()).isEqualTo("Spring Boot desde cero");

        assertThat(guardado.getIdCurso()).isEqualTo(1L);
    }

    @Test
    @DisplayName("listarCursos() devuelve todos los cursos")
    void listar_ok() {
        Curso a = new Curso();
        a.setIdCurso(1L);
        Curso b = new Curso();
        b.setIdCurso(2L);

        when(cursoRepository.obtenerCursos()).thenReturn(Arrays.asList(a, b));

        List<Curso> todos = cursoService.listarCursos();
        assertThat(todos).hasSize(2);
    }

    @Test
    @DisplayName("encontrarCursoPorId() devuelve el curso cuando existe")
    void buscarPorId_ok() {
        Curso a = new Curso();
        a.setIdCurso(5L);

        when(cursoRepository.buscarPorId(5L)).thenReturn(a);

        Curso encontrado = cursoService.encontrarCursoPorId(5L);
        assertThat(encontrado.getIdCurso()).isEqualTo(5L);
    }

    @Test
    @DisplayName("borrarCurso() elimina por id sin errores")
    void borrar_ok() {
        assertDoesNotThrow(() -> cursoService.borrarCurso(7));
        verify(cursoRepository, times(1)).eliminar(7);
    }
}
