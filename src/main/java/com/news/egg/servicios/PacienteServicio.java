package com.news.egg.servicios;

import com.news.egg.entidades.Paciente;
import com.news.egg.enumeraciones.Genero;
import com.news.egg.enumeraciones.ObraSocial;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicio implements UserDetailsService {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional

    public void registrarNuevoPaciente(String nombre, String apellido, Integer dni, 
            String domicilio, Date nacimiento, Long numeroTelefono, String genero, 
            String obraSocial, String email, String password, String password2) throws MiException{
        
        validar(nombre, apellido, dni, numeroTelefono, email, password, password2);

        Paciente paciente = new Paciente();
        
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(dni);
        paciente.setDomicilio(domicilio);
        paciente.setNacimiento(nacimiento);
        paciente.setNumeroTelefono(numeroTelefono);
        paciente.setGenero(Genero.valueOf(genero));
        paciente.setObraSocial(ObraSocial.valueOf(obraSocial));

        paciente.setEmail(email);

        paciente.setPassword(new BCryptPasswordEncoder().encode(password));        

        paciente.setRol(Rol.PACIENTE);

        pacienteRepositorio.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList();
        pacientes = pacienteRepositorio.findAll();
        return pacientes;
    }

    @Transactional
    public void actualizar(Long id, String nombre, String apellido, Integer dni, String domicilio, 
            Long numeroTelefono, String genero, String obraSocial, String email) throws MiException {


        validarSinPassword(nombre, apellido, dni, numeroTelefono, email);

        Optional<Paciente> respuesta = pacienteRepositorio.findById(id);
        
        if (respuesta.isPresent()) {

            Paciente paciente = respuesta.get();

            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setDomicilio(domicilio);
            paciente.setDni(dni);            
            paciente.setNumeroTelefono(numeroTelefono);
            paciente.setGenero(Genero.valueOf(genero));
            paciente.setObraSocial(ObraSocial.valueOf(obraSocial));
            paciente.setEmail(email);

            paciente.setRol(Rol.PACIENTE);

            pacienteRepositorio.save(paciente);
        }

    }   
    
    public Paciente getOne(Long id){

        return pacienteRepositorio.getOne(id);
    }

    private void validar(String nombre, String apellido, Integer dni, Long numeroTelefono, 
            String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }

        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede ser nulo o estar vacío");
        }

        if (dni == null) {
            throw new MiException("El dni no puede ser nulo o estar vacío");
        }

        if (numeroTelefono == null) {
            throw new MiException("El telefono no puede ser nulo o estar vacío");
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
    
     private void validarSinPassword(String nombre, String apellido, Integer dni, Long numeroTelefono, String email) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede ser nulo o estar vacío");
        }
        
        if (dni == null) {
            throw new MiException("El dni no puede ser nulo o estar vacío");
        }
        
        if (numeroTelefono == null) {
            throw new MiException("El telefono no puede ser nulo o estar vacío");
        }
        
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Paciente paciente = pacienteRepositorio.buscarPorEmail(email);

        if (paciente != null) {
            List<GrantedAuthority> permisos = new ArrayList();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + paciente.getRol().toString());
            permisos.add(p);
            return new User(paciente.getEmail(), paciente.getPassword(), permisos);

        } else {
            return null;
        }

    }

}
