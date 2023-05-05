package com.alura.api.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.api.Entity.Topico;

@Repository
public interface TopicoRep extends JpaRepository<Topico, Long> {
    
}
