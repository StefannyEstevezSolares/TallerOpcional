
package com.example.TallerOpcionalVideojuegos.repository;

import com.example.TallerOpcionalVideojuegos.entity.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TorneoRepository extends JpaRepository<Torneo, Long> {
    
}
