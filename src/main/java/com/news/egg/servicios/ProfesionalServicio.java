
package com.news.egg.servicios;

import com.news.egg.entidades.Profesional;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.UsuarioRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;




public class ProfesionalServicio {
    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar (Double honorario) throws MiException {

        Profesional profesional = new Profesional();
        profesional.setHonorario(honorario);

        usuarioRepositorio.save(profesional);
    }
}
