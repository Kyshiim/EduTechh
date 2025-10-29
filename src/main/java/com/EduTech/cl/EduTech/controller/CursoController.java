package com.EduTech.cl.EduTech.controller;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.listarCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        Curso cursoNuevo = cursoService.guardarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Integer id) {
        Curso curso = cursoService.encontrarCursoPorId(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoExistente = cursoService.encontrarCursoPorId(id);
        if (cursoExistente != null) {
            cursoExistente.setTitulo(curso.getTitulo());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setCategoria(curso.getCategoria());
            Curso cursoActualizado = cursoService.actualizarCurso(cursoExistente);
            return ResponseEntity.ok(cursoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        Curso curso = cursoService.encontrarCursoPorId(id);
        if (curso != null) {
            cursoService.borrarCurso(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/publicar")
    public ResponseEntity<Curso> publicar(@PathVariable Integer id) {
        Curso curso = cursoService.publicarCurso(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/eliminar")
    public ResponseEntity<Curso> eliminarEstado(@PathVariable Integer id) {
        Curso curso = cursoService.eliminarCurso(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}