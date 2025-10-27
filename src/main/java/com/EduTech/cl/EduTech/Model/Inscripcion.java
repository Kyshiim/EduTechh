package com.EduTech.cl.EduTech.Model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inscripcion")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    
    public Inscripcion(Date fecha, String estado) {
        this.fecha = fecha;
        this.estado = estado;
    }

    
    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripcion other = (Inscripcion) o;
        return idInscripcion != null && idInscripcion.equals(other.idInscripcion);
    }

  
    @Override
    public int hashCode() {
        int result = 1;
        result = 59 * result + (idInscripcion == null ? 43 : idInscripcion.hashCode());
        result = 59 * result + (fecha == null ? 43 : fecha.hashCode());
        result = 59 * result + (estado == null ? 43 : estado.hashCode());
        return result;
    }

    
    @Override
    public String toString() {
        return "Inscripcion(idInscripcion=" + idInscripcion +
               ", fecha=" + fecha +
               ", estado=" + estado + ")";
    }
}
