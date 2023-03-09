
package com.news.egg.controladores;


import com.news.egg.entidades.Profesional;
import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.ProfesionalServicio;
import java.util.List;
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
            ModelMap modelo) {
        
        try {            
            profesionalServicio.registrar(nombre, apellido, dni, domicilio, honorario, numeroTelefono, email, password, password2, especialidad);
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
        
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo){
        
        //para que los datos que ya estan cargados aparezcan listados usamos modelo.put
        //es decir, inyectamos los datos del profesional
      modelo.put("Profesional", profesionalServicio.getOne(id)); //esto pone el mensaje en la vista!
        // a traves de modelo.put pasamos como llave a "Profesional" conteniendo el objeto que tenga el id 
        // que se obtuvo desde el metodo getOne()
        // y eso se muestra con la estructura de vista que llamamos en el return
        // notimodificar_form.
        
        return "profesional_modificar.html";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String titulo, String cuerpo, String foto, ModelMap modelo) {
        List<Profesional> profesionales = profesionalServicio.listarProfesionales();
        modelo.addAttribute("Profesionales", profesionales);
        //profesionalServicio.actualizar(Long.MIN_VALUE, foto, cuerpo, Integer.SIZE, titulo, id, foto, foto, Double.NaN); //arrreglar esto
        return "redirect:../lista";
    }
    
    
    
    
}
