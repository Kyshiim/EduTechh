package com.EduTech.cl.EduTech;

import com.EduTech.cl.EduTech.Model.Inscripcion;
import com.EduTech.cl.EduTech.Repository.InscripcionRepository;
import com.EduTech.cl.EduTech.Service.InscripcionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class InscripcionServiceTest {

    @Mock
    private InscripcionRepository inscripcionRepository;

    @InjectMocks
    private InscripcionService inscripcionService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("guardar() persiste y devuelve la inscripción")
    void guardar_ok() {
        Inscripcion i = new Inscripcion();
        i.setIdInscripcion(1);
        i.setFecha(java.sql.Date.valueOf(LocalDate.now()));
        i.setEstado("ACTIVA");

        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(i);

        Inscripcion guardada = inscripcionService.guardar(i);

        ArgumentCaptor<Inscripcion> captor = ArgumentCaptor.forClass(Inscripcion.class);
        verify(inscripcionRepository, times(1)).save(captor.capture());
        assertThat(captor.getValue().getEstado()).isEqualTo("ACTIVA");

        assertThat(guardada.getIdInscripcion()).isEqualTo(1);
    }

    @Test
    @DisplayName("listar() devuelve todas las inscripciones")
    void listar_ok() {
        Inscripcion a = new Inscripcion();
        a.setIdInscripcion(1);
        Inscripcion b = new Inscripcion();
        b.setIdInscripcion(2);

        when(inscripcionRepository.findAll()).thenReturn(Arrays.asList(a, b));

        List<Inscripcion> todas = inscripcionService.listarInscripciones();
        assertThat(todas).hasSize(2);
    }

    @Test
    @DisplayName("buscarPorId() devuelve la inscripción cuando existe")
    void buscarPorId_ok() {
        Inscripcion a = new Inscripcion();
        a.setIdInscripcion(5);

        when(inscripcionRepository.findById(5)).thenReturn(Optional.of(a));

        Inscripcion encontrada = inscripcionService.encontrarPorId(5);
        assertThat(encontrada.getIdInscripcion()).isEqualTo(5);
    }

    @Test
    @DisplayName("borrar() elimina por id sin errores")
    void borrar_ok() {
        assertDoesNotThrow(() -> inscripcionService.eliminarPorId(7));
        verify(inscripcionRepository, times(1)).deleteById(7);
    }
}
