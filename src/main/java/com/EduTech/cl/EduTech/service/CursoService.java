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

    public List<Curso> getCursos() {
        return cursoRepository.obtenerCursos();
    }

    public Curso getCursoId(Integer idCurso) {
        return cursoRepository.buscarPorId(idCurso);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.guardar(curso);
    }

    public Curso updateCurso(Curso curso) {
        return cursoRepository.actualizar(curso);
    }

    public String deleteCurso(Integer idCurso) {
        cursoRepository.eliminar(idCurso);
        return "Curso eliminado con éxito";
    }

    public Curso publicarCurso(Integer idCurso) {
        Curso curso = cursoRepository.buscarPorId(idCurso);
        if (curso != null) {
            curso.publicar();
            cursoRepository.actualizar(curso);
        } 
        return curso;
    }

    public Curso eliminarCurso(Integer idCurso) {
        Curso curso = cursoRepository.buscarPorId(idCurso);
        if (curso != null) {
            curso.eliminar();
            cursoRepository.actualizar(curso);
        }
        return curso; 
    }
}