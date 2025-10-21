package com.EduTech.cl.EduTech.repository;

import com.EduTech.cl.EduTech.model.Curso;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    private List<Curso> listaCursos = new ArrayList<>();

    // Obtener todos los cursos
    public List<Curso> obtenerCursos() {
        return listaCursos;
    }

    // Buscar un curso por su ID
    public Curso buscarPorId(Integer idCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getIdCurso().equals(idCurso)) {
                return curso;
            }
        }
        return null;
    }

    // Guardar un curso
    public Curso guardar(Curso curso) {
        listaCursos.add(curso);
        return curso;
    }

    // Actualizar un curso
    public Curso actualizar(Curso curso) {
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getIdCurso().equals(curso.getIdCurso())) {
                listaCursos.set(i, curso);
                return curso;
            }
        }
        return null;
    }

    // Eliminar un curso
    public void eliminar(Integer idCurso) {
        listaCursos.removeIf(curso -> curso.getIdCurso().equals(idCurso));
    }
}