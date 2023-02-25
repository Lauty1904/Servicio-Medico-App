package com.news.egg.repositorios;

import com.news.egg.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepositorio extends JpaRepository <Consulta, Long> {
      
    @Query("SELECT c FROM Consulta c WHERE c.id = :id")
    public Consulta buscarPorId(@Param("id") Long id);
    
}
