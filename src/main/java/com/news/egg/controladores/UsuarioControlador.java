

package com.news.egg.controladores;

import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioservicio;

    @GetMapping("/registrar")
    public String registrar() {

        return "registro_paciente.html";

    }

    @PostMapping("/registro")
    public String registro(@RequestParam (required = false) String nombre, @RequestParam (required = false) String apellido, @RequestParam (required = false) Integer dni, @RequestParam (required = false) String domicilio, 
            @RequestParam (required = false) String email, @RequestParam (required = false) String password, @RequestParam (required = false) String password2, @RequestParam (required = false) Integer numeroTelefono, 
            @RequestParam (required = false) String rol, ModelMap modelo) { 
        
        
        try {               
                usuarioservicio.registrarNuevoUsuario(nombre, apellido, dni, domicilio, email, password, password2, numeroTelefono, rol);
                
                modelo.put("Exito", "Usuario registrado correctamente");                             
                
        } catch (MiException ex) {
            
            modelo.put("Error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("dni", dni);
            modelo.put("domicilio", domicilio);
            modelo.put("email", email);
            modelo.put("numero de contacto", numeroTelefono);
            modelo.put("rol", rol);
            
            return "UsuarioForm(camo).html";
        }
            
            return "registro_paciente.html";           
                   

    }


    
    
}
