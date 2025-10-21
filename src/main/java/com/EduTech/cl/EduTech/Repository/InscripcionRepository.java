package com.EduTech.cl.EduTech.Repository;

import com.EduTech.cl.EduTech.Model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

}
