package com.EduTech.cl.EduTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EduTech.cl.EduTech.Model.Inscripcion;
import com.EduTech.cl.EduTech.Repository.InscripcionRepository;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public InscripcionService() {
    }

    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion guardar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion encontrarPorId(Integer id) throws Exception {
        return (Inscripcion)this.inscripcionRepository.findById(id).get();
    }

    public void eliminarPorId(Integer id) {
        inscripcionRepository.deleteById(id);
    }
   
}    
