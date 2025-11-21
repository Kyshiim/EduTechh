package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.Controller.InscripcionController;
import com.EduTech.cl.EduTech.Model.Inscripcion;
import com.EduTech.cl.EduTech.Service.InscripcionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InscripcionController.class)
class InscripcionControllerTest {

    // Ajusta este path si tu @RequestMapping del controlador es distinto
    private static final String BASE = "/api/v1/inscripcion";

    @Autowired
    private MockMvc mvc;

    @SuppressWarnings("removal")
    @MockBean
    private InscripcionService inscripcionService;

    @Test
    @DisplayName("GET /api/v1/inscripcion lista inscripciones (200)")
    void listar_ok() throws Exception {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdInscripcion(1);
        inscripcion.setFecha(new Date());
        inscripcion.setEstado("ACTIVA");

        when(inscripcionService.listarInscripciones()).thenReturn(Collections.singletonList(inscripcion));

        mvc.perform(get(BASE).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
