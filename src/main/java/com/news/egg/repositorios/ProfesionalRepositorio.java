
package com.news.egg.repositorios;

import com.news.egg.entidades.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesionalRepositorio extends JpaRepository <Profesional, Long>{
    

}
