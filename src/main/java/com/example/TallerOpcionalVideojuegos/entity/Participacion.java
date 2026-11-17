package com.example.TallerOpcionalVideojuegos.entity;



import jakarta.persistence.*;


@Entity
@Table(name = "participacion")
public class Participacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    private Personaje personaje;
    
    @ManyToOne
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;
    
    @Column(nullable = false)
    private Integer posicion;
    
    @Column(nullable = false)
    private Integer puntos;
    
    
    public Participacion(){
    }
    
    public Participacion(Personaje personaje, 
            Torneo torneo, Integer posicion, Integer puntos){
        
        this.personaje = personaje;
        this.torneo = torneo;
        this.posicion = posicion;
        this.puntos = puntos; 
    }

    public long getId() {
        return id;
    }


    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
public String toString() {
    return "Participacion{" +
            "id=" + id +
            ", personaje=" + (personaje != null ? personaje.getNombre() : null) +
            ", torneo=" + (torneo != null ? torneo.getNombre() : null) +
            ", posicion=" + posicion +
            ", puntos=" + puntos +
            '}';
}
    
    
}
