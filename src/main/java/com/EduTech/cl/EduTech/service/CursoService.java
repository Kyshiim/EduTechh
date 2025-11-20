package com.EduTech.cl.EduTech.service;

import com.EduTech.cl.EduTech.model.Curso;
import com.EduTech.cl.EduTech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.obtenerCursos();
    }

    public Curso encontrarCursoPorId(long id) {
        return cursoRepository.buscarPorId(id);
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.guardar(curso);
    }

    public Curso actualizarCurso(Curso curso) {
        return cursoRepository.actualizar(curso);
    }

    public void borrarCurso(Integer id) {
        cursoRepository.eliminar(id);
    }

    public Curso publicarCurso(Integer id) {
        Curso curso = cursoRepository.buscarPorId(id);
        if (curso != null) {
            curso.publicar();
            return cursoRepository.actualizar(curso);
        }
        return null;
    }

    public Curso eliminarCurso(Integer id) {
        Curso curso = cursoRepository.buscarPorId(id);
        if (curso != null) {
            curso.eliminar();
            return cursoRepository.actualizar(curso);
        }
        return null;
    }
}