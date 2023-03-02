
package com.news.egg.servicios;

import com.news.egg.entidades.HistoriaClinica;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.entidades.Turno;
import com.news.egg.enumeraciones.ObraSocial;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.TurnoRepositorio;
import com.news.egg.repositorios.UsuarioRepositorio;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


public class PacienteServicio {
    
    @Autowired
    private PacienteRepositorio pr;
    @Autowired
    private TurnoRepositorio tr;

    @Transactional // Anotacion para funciones que agreguen cosas a la base de datos.
    public void crearPaciente(Long idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, HistoriaClinica historiaClinica) throws Exception {
        

        if (idobraSocial == null) {
            throw new Exception("No se ingreso un id.");
        }
        if (nacimiento == null) {
            throw new Exception("No se ingreso una fecha de nacimiento.");
        }
        if (genero == null) {
            throw new Exception("No se ingreso un genero.");
        }
        if (obraSocial == null) {
            throw new Exception("No se ingreso una Obra Social.");
        }
        if (historiaClinica == null) {
            throw new Exception("No se ingreso una historia clinica.");
        }
        

        Paciente paciente = new Paciente(idobraSocial, nacimiento, genero, obraSocial, historiaClinica);

        pr.save(paciente); //guarda en la base de datos
    }

    public void modificarPaciente(Long id, Long idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, List<Turno> turnos, HistoriaClinica historiaClinica) throws Exception {
        Optional<Paciente> pacienteRespuesta = pr.findById(id);

        if (idobraSocial == null) {
            throw new Exception("No se ingreso un id.");
        }
        if (nacimiento == null) {
            throw new Exception("No se ingreso una fecha de nacimiento.");
        }
        if (genero == null) {
            throw new Exception("No se ingreso un genero.");
        }
        if (obraSocial == null) {
            throw new Exception("No se ingreso una Obra Social.");
        }
        if (historiaClinica == null) {
            throw new Exception("No se ingreso una historia clinica.");
        }

        if (pacienteRespuesta.isPresent()) {
            Paciente paciente = pacienteRespuesta.get();

            paciente.setIdobraSocial(idobraSocial);
            paciente.setNacimiento(nacimiento);
            paciente.setGenero(genero);
            paciente.setObraSocial(obraSocial);
            paciente.setTurnos(turnos);
            paciente.setHistoriaClinica(historiaClinica);


            pr.save(paciente); //guarda en la base de datos
        } else {
            throw new Exception("El ID no corresponde a ningun paciente");
        }

    }

    public void agregarTurno(Long id, Turno turno) throws Exception {
        Optional<Paciente> pacienteRespuesta = pr.findById(id);
        Optional<Turno> turnoRespuesta = tr.findById(turno.getIdTurno())
        

        if (!pacienteRespuesta.isPresent()) {
            throw new Exception("El ID no corresponde a ningun paciente");
        }
        
        if (!turnoRespuesta.isPresent()) {
            throw new Exception("El ID no corresponde a ningun turno");
        }
        
        Turno t = turnoRespuesta.get();
        
        if (t.getPaciente() != null){
            throw new Exception("El turno ya esta asignado");
        }

        Paciente p = pacienteRespuesta.get();

        List<Turno> turnos = p.getTurnos();
          
        turnos.add(turno);
        
        p.setTurnos(turnos);
        
        pr.save(p);
    }

