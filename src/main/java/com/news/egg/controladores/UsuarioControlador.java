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

        return "UsuarioForm.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer dni, @RequestParam String domicilio, @RequestParam String email,
            @RequestParam String password, @RequestParam String password2, @RequestParam String rol, ModelMap modelo) {

        try {
            usuarioservicio.registrarNuevoUsuario(nombre, apellido, dni, domicilio, email, password, password2, rol);
            modelo.put("Exito", "Usuario registrado correctamente");
            
            return "index.html";

        } catch (MiException ex) {
            
            modelo.put("Error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("dni", dni);
            modelo.put("domicilio", domicilio);
            modelo.put("email", email);
            modelo.put("rol", rol);
            
            return "registro.html";
            
        }

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        
        if (error!=null){
            modelo.put("Error","Usuario o contraseña inválidos");
        }

        return "login.html";
    }
    
    @GetMapping("/inicio")
    public String inicio() {

        return "inicio.html";
    }
    
}
