package com.news.egg.servicios;

import java.util.Optional;
import com.news.egg.entidades.Profesional;
import com.news.egg.enumeraciones.Especialidad;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.ProfesionalRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {
   
    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Transactional
    public void registrar(String nombre, String apellido, Integer dni, String domicilio, Double honorario, Integer numeroTelefono, String email, String password, String password2, String especialidad) throws MiException {
        
        Profesional profesional = new Profesional();
        profesional.setNombre(nombre);
        profesional.setApellido(apellido);
        profesional.setDomicilio(domicilio);
        profesional.setDni(dni);
        profesional.setNumeroTelefono(numeroTelefono);
        
        profesional.setEmail(email);
        profesional.setPassword(new BCryptPasswordEncoder().encode(password));
        profesional.setPassword2(password2);
        
     
        profesional.setRol(Rol.MEDICO);
        
        profesional.setHonorario(honorario);
        profesional.setEspecialidad(Especialidad.valueOf(especialidad));//ver de CAMBIAR los enums por una tabla aparte con Id de especialidad y nombre
        
        profesionalRepositorio.save(profesional);

    }

       public List<Profesional> listarProfesionales() {

        List<Profesional> profesional = new ArrayList();
        profesional = profesionalRepositorio.findAll();
        return profesional;
    }
    
 
    
    @Transactional
    public void actualizar (Long id, String nombre, String apellido, Integer dni, String domicilio, Double honorario, Integer numeroTelefono, String email, String password, String password2, String especialidad) throws MiException {

        validar(nombre, apellido, dni, email, password, password2);

        Optional<Profesional> respuesta = profesionalRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Profesional profesional = respuesta.get();
        
            profesional.setNombre(nombre);
            profesional.setApellido(apellido);
            profesional.setDomicilio(domicilio);
            profesional.setDni(dni);    
            profesional.setEmail(email);
            profesional.setNumeroTelefono(numeroTelefono);
            
            profesional.setPassword(password);
            profesional.setPassword(new BCryptPasswordEncoder().encode(password));
            profesional.setPassword2(password2);
        
            profesional.setRol(Rol.MEDICO);
        
            profesional.setHonorario(honorario);
            profesional.setEspecialidad(Especialidad.valueOf(especialidad));//cambiar desde html - Ver de cambiar este ENUM por una tabla de especialidades

            profesionalRepositorio.save(profesional);
        }
    }
    
    
    
    public Profesional getOne(Long id){
        return profesionalRepositorio.getOne(id);
    }
    

    private void validar(String nombre, String apellido, Integer dni, String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede ser nulo o estar vacío");
        }
        
        if (dni == null) {
            throw new MiException("El dni no puede ser nulo o estar vacío");
        }
        
        
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

}
