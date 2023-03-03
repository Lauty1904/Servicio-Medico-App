
package com.news.egg.servicios;

import com.news.egg.entidades.Paciente;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicio {
    
    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional
    public void registrarNuevoPaciente(String nombre, String apellido, Integer dni, String domicilio, Integer numeroTelefono, String email, String password, String password2, String genero, Integer obraSocial) throws MiException{

        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(dni);
        paciente.setDomicilio(domicilio);
        paciente.setGenero(genero);
        paciente.setNumeroTelefono(numeroTelefono);

        paciente.setRol(Rol.PACIENTE);

        paciente.setEmail(email);
        paciente.setPassword(new BCryptPasswordEncoder().encode(password));
        paciente.setPassword2(new BCryptPasswordEncoder().encode(password2));
        
        pacienteRepositorio.save(paciente);
    }
    
    public List <Paciente> listarPacientes(){
        List <Paciente> pacientes = new ArrayList();
        pacientes = pacienteRepositorio.findAll();
        return pacientes;
    }  
    
}
