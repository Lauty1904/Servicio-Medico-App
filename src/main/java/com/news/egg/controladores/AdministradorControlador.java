
package com.news.egg.controladores;

import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.servicios.PacienteServicio;
import com.news.egg.servicios.ProfesionalServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {
    
    @Autowired
    private ProfesionalServicio profesionalServicio;
    
    @Autowired PacienteServicio pacienteServicio;
    
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

}
