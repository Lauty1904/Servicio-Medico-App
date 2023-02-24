package com.news.egg.repositorios;

import com.news.egg.entidades.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepositorio extends JpaRepository <HistoriaClinica, Long> {
    
    @Query("SELECT h FROM HistoriaClinica h WHERE h.id = :id")
    public HistoriaClinica buscarPorId(@Param("id") Long id);
    
}
