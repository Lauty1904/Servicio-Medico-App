
package com.news.egg.servicios;

import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.entidades.Turno;
import com.news.egg.enumeraciones.Especialidad;
import com.news.egg.enumeraciones.Rol;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.TurnoRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


public class TurnoServicio {
    
    @Autowired
    private PacienteRepositorio pacienteRepositorio;
    
    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    
    @Autowired
    private TurnoRepositorio turnoRepositorio;
    
    @Transactional
    public void registrarTurno (Long IdTurno, Paciente paciente, Profesional profesional) throws MiException {

        Turno turno = new Turno();
        turno.setIdTurno(IdTurno);
        turno.setPaciente(paciente);
        turno.setProfesional(profesional);
        turno.setStatus(false);
        
 
        turnoRepositorio.save(turno);

    }
}
