
package com.news.egg.repositorios;

import com.news.egg.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HorarioRepositorio extends JpaRepository <Usuario, Long> {
    
 
    
}
