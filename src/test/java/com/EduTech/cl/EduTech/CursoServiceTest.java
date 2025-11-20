package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;
import com.EduTech.cl.EduTech.service.CursoService;
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
    @DisplayName("guardar() persiste y devuelve el curso")
    void guardar_ok() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setTitulo("Spring Boot");
        curso.setDescripcion("Curso de Spring Boot");
        curso.setCategoria("DESARROLLO");
        curso.setEstado("EN_REVISION");

        when(cursoRepository.guardar(any(Curso.class))).thenReturn(curso);

        Curso guardado = cursoService.guardarCurso(curso);

        ArgumentCaptor<Curso> captor = ArgumentCaptor.forClass(Curso.class);
        verify(cursoRepository, times(1)).guardar(captor.capture());

        assertThat(captor.getValue().getTitulo()).isEqualTo("Spring Boot");
        assertThat(guardado.getIdCurso()).isEqualTo(1);
    }

    @Test
    @DisplayName("listar() devuelve todos los cursos")
    void listar_ok() {
        Curso curso1 = new Curso();
        curso1.setIdCurso(1);
        Curso curso2 = new Curso();
        curso2.setIdCurso(2);

        when(cursoRepository.obtenerCursos()).thenReturn(Arrays.asList(curso1, curso2));

        List<Curso> todos = cursoService.listarCursos();
        assertThat(todos).hasSize(2);
    }

    @Test
    @DisplayName("buscarPorId() devuelve el curso cuando existe")
    void buscarPorId_ok() {
        Curso curso = new Curso();
        curso.setIdCurso(5);

        when(cursoRepository.buscarPorId(5)).thenReturn(curso);

        Curso encontrado = cursoService.encontrarCursoPorId(5);
        assertThat(encontrado.getIdCurso()).isEqualTo(5);
    }

    @Test
    @DisplayName("borrar() elimina por id sin errores")
    void borrar_ok() {
        assertDoesNotThrow(() -> cursoService.borrarCurso(7));
        verify(cursoRepository, times(1)).eliminar(7);
    }
}
