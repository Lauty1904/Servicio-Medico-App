package com.news.egg.repositorios;

import com.news.egg.entidades.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TurnoRepositorio extends JpaRepository <Turno, Long> {
    
     @Query ("SELECT t FROM Turno t WHERE t.id = :id")
    public Turno buscarPorEmail(@Param("id")String email);
        
}
