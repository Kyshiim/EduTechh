package com.EduTech.cl.EduTech.controller;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.getCursos();
    }

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    
    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable Integer idCurso) {
        Curso curso = cursoService.getCursoId(idCurso);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer idCurso, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.updateCurso(curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<String> eliminarCurso(@PathVariable Integer idCurso) {
        String mensaje = cursoService.deleteCurso(idCurso);
        return ResponseEntity.ok(mensaje);
    }


    @PutMapping("/{idCurso}/publicar")
    public ResponseEntity<Curso> publicarCurso(@PathVariable Integer idCurso) {
        Curso curso = cursoService.publicarCurso(idCurso);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idCurso}/eliminar")
    public ResponseEntity<Curso> cambiarEstadoEliminar(@PathVariable Integer idCurso) {
        Curso curso = cursoService.eliminarCurso(idCurso);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}