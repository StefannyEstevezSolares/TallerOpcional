
package com.example.TallerOpcionalVideojuegos.execution;

import com.example.TallerOpcionalVideojuegos.entity.Personaje;
import com.example.TallerOpcionalVideojuegos.entity.Torneo;
import com.example.TallerOpcionalVideojuegos.entity.Participacion;

import com.example.TallerOpcionalVideojuegos.repository.PersonajeRepository;
import com.example.TallerOpcionalVideojuegos.repository.TorneoRepository;
import com.example.TallerOpcionalVideojuegos.repository.ParticipacionRepository;

import java.time.LocalDate;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SmashMain implements CommandLineRunner {

    private final PersonajeRepository personajeRepo;
    private final TorneoRepository torneoRepo;
    private final ParticipacionRepository participacionRepo;

    // Inyección de dependencias por constructor
    public SmashMain(PersonajeRepository personajeRepo,
                     TorneoRepository torneoRepo,
                     ParticipacionRepository participacionRepo) {

        this.personajeRepo = personajeRepo;
        this.torneoRepo = torneoRepo;
        this.participacionRepo = participacionRepo;
    }

    @Override
    @Transactional
    public void run(String... args) {

        // Creamos los datos solamente si las tablas están vacías
        if (personajeRepo.count() == 0
                && torneoRepo.count() == 0
                && participacionRepo.count() == 0) {

            // Creación de personajes
            Personaje mario = new Personaje(
                    "Mario", "Super Mario", "Equilibrado");

            Personaje link = new Personaje(
                    "Link", "The Legend of Zelda", "Espadachin");

            Personaje pikachu = new Personaje(
                    "Pikachu", "Pokemon", "Electricidad");

            Personaje kirby = new Personaje(
                    "Kirby", "Kirby Deluxe", "Buen Muchacho");

            personajeRepo.save(mario);
            personajeRepo.save(link);
            personajeRepo.save(pikachu);
            personajeRepo.save(kirby);

            // Creación de torneos
            Torneo copaUniversitaria = new Torneo(
                    "Copa Universitaria",
                    "Guatemala",
                    LocalDate.of(2026, 12, 15));

            Torneo campeonatoFinal = new Torneo(
                    "Campeonato Final",
                    "Ciudad de Guatemala",
                    LocalDate.of(2027, 1, 20));

            torneoRepo.save(copaUniversitaria);
            torneoRepo.save(campeonatoFinal);

            // Creación de participaciones
            Participacion p1 = new Participacion(
                    mario, copaUniversitaria, 1, 100);

            Participacion p2 = new Participacion(
                    link, copaUniversitaria, 2, 80);

            Participacion p3 = new Participacion(
                    pikachu, copaUniversitaria, 3, 60);

            Participacion p4 = new Participacion(
                    mario, campeonatoFinal, 2, 80);

            Participacion p5 = new Participacion(
                    kirby, campeonatoFinal, 1, 100);

            participacionRepo.save(p1);
            participacionRepo.save(p2);
            participacionRepo.save(p3);
            participacionRepo.save(p4);
            participacionRepo.save(p5);
        }

        // Mostrar todas las participaciones
        System.out.println("\n=========== TORNEOS SUPER SMASH BROS ==========");

        participacionRepo.findAll().forEach(p -> {
            System.out.println(p);
        });

        // Mostrar personajes registrados
        System.out.println("\n========== PERSONAJES REGISTRADOS ==========");

        personajeRepo.findAll().forEach(p -> {
            System.out.println(p);
        });

        // Mostrar torneos registrados
        System.out.println("\n========== TORNEOS REGISTRADOS ==========");

        torneoRepo.findAll().forEach(t -> {
            System.out.println(t);
        });

        // Mostrar cada personaje y los torneos en los que participa
        System.out.println("\n========== PERSONAJES Y SUS TORNEOS ==========");

        personajeRepo.findAll().forEach(p -> {

            System.out.println("Personaje: " + p.getNombre());

            p.getParticipaciones().forEach(participacion -> {

                System.out.println(
                        "- Torneo: " + participacion.getTorneo().getNombre()
                );

            });

        });

        // Mostrar cada torneo y sus personajes
        System.out.println("\n========== TORNEOS Y SUS PERSONAJES ==========");

        torneoRepo.findAll().forEach(t -> {

            System.out.println("Torneo: " + t.getNombre());

            t.getParticipaciones().forEach(participacion -> {

                System.out.println(
                        "- Personaje: " + participacion.getPersonaje().getNombre()
                );

            });

        });

        // Consultar una participación por su ID
        System.out.println("\n========== CONSULTAR PARTICIPACION ==========");

        participacionRepo.findById(1L).ifPresent(p -> {

            System.out.println("Personaje: " + p.getPersonaje().getNombre());
            System.out.println("Torneo: " + p.getTorneo().getNombre());
            System.out.println("Posicion: " + p.getPosicion());
            System.out.println("Puntos: " + p.getPuntos());

        });

    }
}
