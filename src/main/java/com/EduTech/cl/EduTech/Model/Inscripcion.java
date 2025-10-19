package com.EduTech.cl.EduTech.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Generated;


@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(
        strategy = GeneratedValue.IDENTITY
    )
    
    private Integer idInscripcion;
    @column(
        unique = true,
        length = 9,
        nullable = false
    )

    private Date fecha;
    @column(
        nullable = false
    )

    private String estado;
    public Inscripcion() {
    }

    
    @Generated
    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    @Generated
    public Date getFecha() {
        return fecha;
    }

    @Generated
    public String getEstado() {
        return estado;
    }

    @Generated
    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    


}
