
package com.example.TallerOpcionalVideojuegos.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")

public class Personaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public long getId(){
        return id;
    }
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String universo;
    
    @Column(nullable = false)
    private String tipo;
    
    @OneToMany(mappedBy = "personaje")
    private List<Participacion> participaciones = new ArrayList<>();
    
    public Personaje(){}
    
    public Personaje(String nombre, String universo, String tipo){
        this.nombre = nombre;
        this.universo = universo;
        this.tipo = tipo;
    }

    // No creamos el setter de ID ya que queremos que MYSQL lo asigne.
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    @Override
    public String toString() {
        return "Personaje{" + "id=" + id + 
                ", nombre=" + nombre + 
                ", universo=" + universo + 
                ", tipo=" + tipo +  '}';
        
        //Como dijo profe, no vamos a dejar participaciones
        //para evitar un bucle infinito al hacer la relación
    }
    
    
    
}
