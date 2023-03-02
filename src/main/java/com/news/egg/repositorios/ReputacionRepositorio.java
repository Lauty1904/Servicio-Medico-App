package com.news.egg.repositorios;

import com.news.egg.entidades.Reputacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputacionRepositorio extends JpaRepository<Reputacion, Long> {

    @Query("SELECT r FROM Reputacion r WHERE r.id = :id")
    public Reputacion buscarPorId(@Param("id") String id);

}
