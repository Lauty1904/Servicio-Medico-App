
package com.news.egg.repositorios;

import com.news.egg.entidades.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesionalRepositorio extends JpaRepository <Profesional, Long>{
    
    @Query ("SELECT p FROM Profesional p WHERE p.email = :email")
    public Profesional buscarPorEmail(@Param("email")String email);
    
    @Query("SELECT p FROM Profesional p WHERE p.id = :id")
    public Profesional buscarPorId(@Param("id") Long id);
    
}
