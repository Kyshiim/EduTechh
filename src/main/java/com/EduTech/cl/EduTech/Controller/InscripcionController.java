package com.EduTech.cl.EduTech.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EduTech.cl.EduTech.Model.Inscripcion;
import com.EduTech.cl.EduTech.Service.InscripcionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping({"api/v1/inscripcion"})
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    public InscripcionController() {
    }

    @GetMapping
    public ResponseEntity<List<Inscripcion>> listar() {
        List<Inscripcion> inscripciones = inscripcionService.listarInscripciones();
        return inscripciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(inscripciones);
    }

    @PostMapping
    public ResponseEntity<Inscripcion> guardar(@RequestBody Inscripcion inscripcion) {
        Inscripcion nueva = inscripcionService.guardar(inscripcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> buscar(@PathVariable Integer id) {
        try {
            Inscripcion inscripcion = inscripcionService.encontrarPorId(id);
            return ResponseEntity.ok(inscripcion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizar(@PathVariable Integer id, @RequestBody Inscripcion datos) {
        try {
            Inscripcion inscripcion = inscripcionService.encontrarPorId(id);
            inscripcion.setFecha(datos.getFecha());
            inscripcion.setEstado(datos.getEstado());
            inscripcionService.guardar(inscripcion);
            return ResponseEntity.ok(inscripcion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            inscripcionService.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


