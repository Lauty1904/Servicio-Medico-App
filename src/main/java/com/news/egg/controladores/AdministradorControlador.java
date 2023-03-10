package com.news.egg.controladores;

import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.excepciones.MiException;
import com.news.egg.servicios.PacienteServicio;
import com.news.egg.servicios.ProfesionalServicio;
import com.news.egg.servicios.UsuarioServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private UsuarioServicio usuarioservicio;

    @GetMapping("/panelPrincipal")
    public String inicio() {
        return "panel_admin";
    }

    @GetMapping("/listaProfesionales")
    public String listarProfesionales(ModelMap modelo) {
        List<Profesional> profesionales = profesionalServicio.listarProfesionales();
        modelo.addAttribute("medicos", profesionales);
        return "lista_profesionales.html";
    }

    @GetMapping("/listaPacientes")
    public String listarPacientes(ModelMap modelo) {
        List<Paciente> pacientes = pacienteServicio.listarPacientes();
        modelo.addAttribute("pacientes", pacientes);
        return "lista_pacientes.html";
    }
    

    @GetMapping("/modificarProfesional/{id}")
    public String modificarProfesional(@PathVariable Long id, ModelMap modelo) {

        //para que los datos que ya estan cargados aparezcan listados usamos modelo.put
        //es decir, inyectamos los datos del profesional
        modelo.put("profesional", profesionalServicio.getOne(id)); //esto pone el mensaje en la vista!
        // a traves de modelo.put pasamos como llave a "Profesional" conteniendo el objeto que tenga el id 
        // que se obtuvo desde el metodo getOne()
        // y eso se muestra con la estructura de vista que llamamos en el return
        // notimodificar_form.

        return "profesional_modificar.html";
    }

    @PostMapping("/modificarProfesional/{id}")
    public String modificarProfesional(@PathVariable Long id, String nombre, String apellido, Integer dni, String domicilio, Double honorario,
            Long numeroTelefono, String email, String especialidad, ModelMap modelo) {

        try {
            profesionalServicio.actualizar(id, nombre, apellido, dni, domicilio, honorario,
                    numeroTelefono, email, especialidad);
            
            //modelo.addAttribute("Profesionales", profesionales);
            //profesionalServicio.actualizar(Long.MIN_VALUE, foto, cuerpo, Integer.SIZE, titulo, id, foto, foto, Double.NaN); //arrreglar esto
            return "redirect:../listaProfesionales";

        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "profesional_modificar.html";

        }

    }
}
