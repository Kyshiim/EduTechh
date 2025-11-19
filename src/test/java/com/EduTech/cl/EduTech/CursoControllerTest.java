package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.controller.CursoController;
import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.service.CursoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CursoController.class)
class CursoControllerTest {

    private static final String BASE = "/api/v1/cursos";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CursoService cursoService;

    @Test
    @DisplayName("GET /api/v1/cursos lista cursos (200)")
    void listar_ok() throws Exception {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setTitulo("Spring Boot");

        when(cursoService.listarCursos()).thenReturn(Collections.singletonList(curso));

        mvc.perform(get(BASE).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
