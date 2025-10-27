package com.EduTech.cl.EduTech.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Generated;


@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String estado;

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Inscripcion(final Date fecha, final String estado) {
        this.fecha = fecha;
        this.estado = estado;
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
        else {
            Inscripcion other = (Inscripcion) o;
            return idInscripcion != null && idInscripcion.equals(other.idInscripcion);
        }
    }

    public int hashCode() {
        int result = 1;
        result = 59 * result + (idInscripcion == null ? 43 : idInscripcion.hashCode());
        result = 59 * result + (fecha == null ? 43 : fecha.hashCode());
        result = 59 * result + (estado == null ? 43 : estado.hashCode());
    return result;
    }

    @Generated
    public String toString() {
        String var10000 = String.valueOf(this.getIdInscripcion());
        return "Inscripcion(idInscripcion=" + this.getIdInscripcion() + ", fecha=" + this.getFecha() + ", estado=" + this.getEstado() + ")";
    }

    @Generated
    public Inscripcion(){
    }

    @Generated
    public Inscripcion(final Integer idInscripcion, final Date fecha, final String estado) {
        this.idInscripcion = idInscripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    
    
}
