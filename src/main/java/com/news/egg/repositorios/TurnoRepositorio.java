package com.news.egg.repositorios;

import com.news.egg.entidades.Turno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TurnoRepositorio extends JpaRepository <Turno, Long> {
         
    @Query ("SELECT t FROM Turno t WHERE t.status = :status")
    public List<Turno> buscarPorStatus(@Param("status")Boolean status);
    
    @Query ("SELECT t FROM Turno t WHERE t.profesional.id = :id")
    public List<Turno> buscarPorProfesional(@Param("id")Long id);
    
    @Query ("SELECT t FROM Turno t WHERE t.paciente.id = :id")
    public Turno buscarPorPaciente(@Param("id")Long id);
        
}
