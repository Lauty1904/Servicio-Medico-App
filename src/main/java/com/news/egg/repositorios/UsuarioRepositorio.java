package com.news.egg.repositorios;

import com.news.egg.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    public Usuario buscarPorId(@Param("id") Long IdUsuario);
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String IdEmail);
    
}
