package com.news.egg.servicios;

import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.entidades.Turno;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.TurnoRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServicio {

    @Autowired
    private TurnoRepositorio turnoRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Transactional
    public void crearTurno(Long idTurno, boolean status, Long idProfesional, Long idPaciente, Date fechaTurno, Date horaTurno, Date fechaAlta) throws MiException {

        Turno turno = new Turno();

        Paciente paciente = pacienteRepositorio.findById(idPaciente).get();
        Profesional profesional = profesionalRepositorio.findById(idProfesional).get();

        validar(idTurno, idProfesional, idPaciente, fechaTurno, horaTurno, fechaAlta);

        turno.setIdTurno(idTurno);
        turno.setStatus(status);
        turno.setPaciente(paciente);
        turno.setProfesional(profesional);
        turno.setFechaTurno(fechaTurno);
        turno.setHoraTurno(horaTurno);

        turno.setFechaAlta(new Date());

        turnoRepositorio.save(turno);

    }

    public void confirmarTurno(Long idTurno, boolean status, Long idProfesional, Long idPaciente, Date fechaTurno, Date horaTurno, Date fechaAlta) throws MiException {

        validar(idTurno, idProfesional, idPaciente, fechaTurno, horaTurno, fechaAlta);

        Optional<Turno> respuesta = turnoRepositorio.findById(idTurno);

        if (respuesta.isPresent()) {

            Turno turno = respuesta.get();

            turno.setStatus(true);

            turnoRepositorio.save(turno);

        }

    }

    public void modificarTurno(Long idTurno, boolean status, Long idProfesional, Long idPaciente, Date fechaTurno, Date horaTurno, Date fechaAlta) throws MiException {

        validar(idTurno, idProfesional, idPaciente, fechaTurno, horaTurno, fechaAlta);

        Optional<Turno> respuesta = turnoRepositorio.findById(idTurno);

        if (respuesta.isPresent()) {

            Turno turno = respuesta.get();

            turno.setFechaTurno(fechaTurno);
            turno.setHoraTurno(horaTurno);

            turnoRepositorio.save(turno);

        }

    }

    public List<Turno> listarTurnos() {

        List<Turno> turnos = new ArrayList();

        turnos = turnoRepositorio.findAll();

        return turnos;

    }

    public List<Turno> listarTurnosStatus(Boolean status) {

        List<Turno> turnosStatus = new ArrayList();

        turnosStatus = turnoRepositorio.buscarPorStatus(status);

        return turnosStatus;

    }

    public List<Turno> listarTurnosPorProfesional(Long idProfesional) {

        List<Turno> turnosPorProfesional = new ArrayList();

        turnosPorProfesional = turnoRepositorio.buscarPorProfesional(idProfesional);

        return turnosPorProfesional;

    }
    
    public Turno TurnoPorPaciente(Long idPaciente) {

        Turno turnoPorPaciente = new Turno();

        turnoPorPaciente = turnoRepositorio.buscarPorPaciente(idPaciente);

        return turnoPorPaciente;

    }

    private void validar(Long idTurno, Long idProfesional, Long idPaciente, Date fechaTurno, Date horaTurno, Date fechaAlta) throws MiException {

        if (fechaTurno == null) {
            throw new MiException("La Fecha del turno no puede ser nulo");
        }

        if (horaTurno == null) {
            throw new MiException("La hora del turno no puede ser nulo");
        }

        if (fechaAlta == null) {
            throw new MiException("La Fecha de alta no puede ser nulo");
        }

        if (idTurno == null) {
            throw new MiException("El profesional no puede ser nulo");
        }

        if (idProfesional == null) {
            throw new MiException("El profesional no puede ser nulo");
        }

        if (idPaciente == null) {
            throw new MiException("El paciente no puede ser nulo");
        }

    }

    private void eliminarTurno(Long idTurno){
        
        Turno turno = new Turno();
        turno = turnoRepositorio.findById(idTurno).get();   
        
        turnoRepositorio.delete(turno);
        
    }
}
