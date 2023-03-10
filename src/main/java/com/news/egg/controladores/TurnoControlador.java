package com.news.egg.controladores;

import com.news.egg.entidades.Profesional;
import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.PacienteServicio;
import com.news.egg.servicios.ProfesionalServicio;
import com.news.egg.servicios.TurnoServicio;
import java.text.ParseException;
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
@RequestMapping("/turno")
public class TurnoControlador {
    
    @Autowired
    private TurnoServicio turnoServicio;
    
    @Autowired
    private ProfesionalServicio profesionalServicio;
    
    @Autowired
    private PacienteServicio pacienteServicio;
     
    @GetMapping("/registrar") //localhost:8080/turno/registrar
    public String registrar(ModelMap modelo) {
        
        List<Profesional> profesionales = profesionalServicio.listarProfesionales();
        modelo.addAttribute("medicos", profesionales);
        
        return "registro_turno.html";
    }

    
    @GetMapping("/disponibilidadTurnos/{id}")
    public String disponibilidad(
        @PathVariable Long id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String apellido,
        @RequestParam(required = false) String especialidad,
        @RequestParam(required = false) String dia,
        @RequestParam(required = false) String desde,
        @RequestParam(required = false) String hasta,
        ModelMap modelo) throws MiException, ParseException {
        
        Profesional profesional = profesionalServicio.getOne(id);
        
        List<String> turnosDisponibles = turnoServicio.generarTurnos(profesional);
        modelo.addAttribute("disponibilidad", turnosDisponibles); //esto manda la info al htm
        
       
        return "lista_profesionales_turnos.html";
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
        return "profesional_modificar_form.html";
    }
    
     @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String nombre, String apellido, Integer dni, 
            String domicilio, Double honorario, Long numeroTelefono, String email, 
            String password, String password2, String especialidad, 
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
    
    