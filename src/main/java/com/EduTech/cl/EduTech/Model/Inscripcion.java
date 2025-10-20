package com.EduTech.cl.EduTech.Model;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String estado;

    public Inscripcion() {
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    private Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Generated
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        else if (o == null || getClass() != o.getClass())
            return false;
        else if (idInscripcion == null)
            return false;
        else {
            Inscripcion other = (Inscripcion) o;
            return idInscripcion.equals(other.idInscripcion);
        }
    }

    Object
    
}
