
package com.news.egg.servicios;

import com.news.egg.entidades.Usuario;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UsuarioServicio  { //hay que agreegar dps implements UserDetailsService
   @Autowired
   private UsuarioRepositorio usuarioRepositorio;
   
   @Autowired
   private ProfesionalServicio profesionalServicio;
   
   @Autowired
   private PacienteServicio pacienteServicio;
   
    
   @Transactional
   public void registrar(String nombre, String apellido, Integer dni, String email, 
                        String password, String password2, String rol) throws MiException {
       
        validar(nombre, apellido, dni, email, password, password2);
             
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.valueOf(rol));
       
        if (rol.equals("MEDICO")){            
            profesionalServicio.registrar(honorario);     
        } 
        
        if (rol.equals("PACIENTE")){            
            pacienteServicio.registrar(obraSocial, nacimiento, edad, genero);     
        } 
  
            usuarioRepositorio.save(usuario);
            
        }
       
 

   
    public Usuario getOne(Long id){
        return usuarioRepositorio.getOne(id);
    }
   
    
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();
        usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }
    
    
    
    private void validar(String nombre, String apellido, Integer dni, String email, String password, String password2) throws MiException{
        

    if (nombre.isEmpty() || nombre == null){
        throw new MiException("El nombre no puede ser nulo ni vacio");
    }
    
    if (apellido.isEmpty() || apellido == null){
        throw new MiException("El apellido no puede ser nulo ni vacio");
    }
    
    if (dni == null){
        throw new MiException("El dni no puede ser nulo ni vacio");
    }
    
     if (email.isEmpty() || email == null){
        throw new MiException("El email no puede ser nulo ni vacio");
    }
    
    if (password.isEmpty() || password == null || password.length()<=5 ){
        throw new MiException("La clave no puede ser nula ni vacia y debe ser de mas de 5 caracteres");
    }
    
    if (!password.equals(password2)){
        throw new MiException("Las contrasenas deben ser iguales");
    }
 }

}
    
    
