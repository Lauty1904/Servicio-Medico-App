
package com.news.egg.controladores;

import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.ProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {
    
    @Autowired
    private ProfesionalServicio profesionalServicio;
        
    
    @GetMapping("/registrar") //localhost:8080/profesional/registrar
    public String registrar() {
        return "registro_profesional.html";
    }

    
    @PostMapping("/registro")
    public String registro(
        @RequestParam(required = false)String nombre,
        @RequestParam(required = false)String apellido, 
        @RequestParam(required = false) Integer dni, 
        @RequestParam(required = false) String domicilio, 
        @RequestParam(required = false) Double honorario, 
        @RequestParam(required = false) Long numeroTelefono,
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String password, 
        @RequestParam(required = false) String password2,
        @RequestParam(required = false) String especialidad,
        @RequestParam(required = false) String dia,
        @RequestParam(required = false) String desde,
        @RequestParam(required = false) String hasta,
            ModelMap modelo) {
        
        try {            
            profesionalServicio.registrar(nombre, apellido, dni, domicilio, 
                    honorario, numeroTelefono, email, password, password2, 
                    especialidad, dia, desde, hasta);

            modelo.put("exito", "El médico fue cargado correctamente!");

        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre",nombre);
            modelo.put("apellido",apellido);
            modelo.put("dni",dni);
            modelo.put("domicilio",domicilio);
            modelo.put("honorario",honorario);
            modelo.put("numero de telefono",numeroTelefono);
            modelo.put("email",email);
            modelo.put("password",password);
            modelo.put("password2",password2);
            modelo.put("especialidad",especialidad);
            
            return "registro_profesional.html";  // volvemos a cargar el formulario.
        }
        return "panel_admin.html";
    }
        
   @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String nombre, String apellido, Integer dni, 
            String domicilio, Double honorario, Long numeroTelefono, String email, 
            String especialidad, 
            String dia, String desde, String hasta, 
            ModelMap modelo) {

        List<Profesional> profesionales = profesionalServicio.listarProfesionales();
        modelo.addAttribute("Profesionales", profesionales);
        return "redirect:../lista";
    }

    
     @GetMapping("/listar")
    public String listar(ModelMap modelo){ //recibe un ModelMap como parametro
        //va a traernos una lista de profesiionales y rellenarla con los datos que nos trae nuestro service
        List<Profesional> lista = profesionalServicio.listarProfesionales();
        //luego inyectamos con nuesto modelo nuestros atributos bajo el nombre de llave "Lista"
        //vamos a enviar la lista de noticias dentro de lista
        modelo.addAttribute("lista", lista); //esto manda la info al html

        
        return "lista_profesionales.html";
    }

}