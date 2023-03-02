package com.news.egg.servicios;

import com.news.egg.entidades.Usuario;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
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
public class UsuarioServicio implements UserDetailsService{ 

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrarNuevoUsuario(String nombre, String apellido, Integer dni, String domicilio, String email,
            String password, String password2, Integer numeroTeléfono, String rol) throws MiException {

        validar(nombre, apellido, dni, domicilio, email, password, password2, numeroTeléfono);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setDomicilio(domicilio);
        usuario.setEmail(email);
        usuario.setNumeroTelefono(numeroTeléfono);
        usuario.setRol(Rol.valueOf(rol.toUpperCase()));
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuarioRepositorio.save(usuario);

    }

    public Usuario getOne(Long id) {
        return usuarioRepositorio.getOne(id);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuariosRegistrados = new ArrayList();
        usuariosRegistrados = usuarioRepositorio.findAll();
        return usuariosRegistrados;
    }

    private void validar(String nombre, String apellido, Integer dni, String domicilio, String email, String password, String password2, Integer numeroTelefono) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre del usuario no puede ser nulo ni vacio");
        }

        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido del usuario no puede ser nulo ni vacio");
        }

        if (dni == null) {
            throw new MiException("El dni no puede ser nulo ni vacio");
        }
        
        if (numeroTelefono == null) {
            throw new MiException("El número de contacto no puede ser nulo ni vacio");
        }

        if (domicilio.isEmpty() || domicilio == null) {
            throw new MiException("El domicilio del usuario no puede ser nulo ni vacio");
        }

        if (email.isEmpty() || email == null) {
            throw new MiException("El email no puede ser nulo ni vacio");
        }

        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La clave no puede ser nula ni vacia y debe ser de mas de 5 caracteres");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contrasenas deben ser iguales");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        
        List <GrantedAuthority> permisos = new ArrayList();
        
        GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
        
        permisos.add(p);
        
        if(usuario != null){
            
            return new User(usuario.getEmail(), usuario.getPassword(),permisos);
        
        }else{
            
            return null;
        }
        
    }

}
