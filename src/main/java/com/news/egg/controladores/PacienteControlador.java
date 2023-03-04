package com.news.egg.controladores;

import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.PacienteServicio;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/registrar")
    public String registrar() {

        return "registro_paciente.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) String nombre, 
            @RequestParam(required = false) String apellido, 
            @RequestParam(required = false) Integer dni, 
            @RequestParam(required = false) String domicilio,
            @RequestParam(required = false) Date nacimiento,
            @RequestParam(required = false) Integer numeroTelefono,
            @RequestParam(required = false) String genero, 
            @RequestParam(required = false) String obraSocial, 
            @RequestParam(required = false) String email, 
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String password2,
            ModelMap modelo){
        
        try {            
            pacienteServicio.registrarNuevoPaciente(nombre, apellido, dni, domicilio, nacimiento, numeroTelefono, genero, obraSocial, email, password, password2);
            modelo.put("Exito", "Paciente registrado correctamente");

        } catch (MiException ex) {

            modelo.put("Error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("dni", dni);
            modelo.put("domicilio", domicilio);
            modelo.put("nacimiento", nacimiento);
            modelo.put("email", email);
            modelo.put("numero de contacto", numeroTelefono);

            return "registro_paciente.html";
        }
        return "paciente_index.html";
    }

}
