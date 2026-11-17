
package com.example.TallerOpcionalVideojuegos.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "torneo")
public class Torneo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String ubicacion;
    
    @Column(nullable = false)
    private LocalDate fecha;
    
    @OneToMany(mappedBy = "torneo")
    private List<Participacion> participaciones = new ArrayList<>();
    
    public Torneo(){}
    
    public Torneo(String nombre, String ubicacion, LocalDate fecha){
        
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        
        
        
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

   @Override
public String toString() {
    return "Torneo{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", ubicacion='" + ubicacion + '\'' +
            ", fecha=" + fecha +
            '}';
}
    
    
}
