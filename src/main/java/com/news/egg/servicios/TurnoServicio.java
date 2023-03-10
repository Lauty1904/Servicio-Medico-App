package com.news.egg.servicios;


import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.entidades.Turno;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.PacienteRepositorio;
import com.news.egg.repositorios.ProfesionalRepositorio;
import com.news.egg.repositorios.TurnoRepositorio;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
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
    public void registrar(String dia, String desde, String hasta, Profesional profesional) throws MiException, ParseException {

      

        
        Turno turno = new Turno();

        turno.setStatus(true);
        //turno.getPaciente(Paciente);
        turno.setProfesional(profesional);
        turno.setFechaAlta(new Date());
        //turno.setFechaTurno(turno);
        

        turnoRepositorio.save(turno);

    }
    
    
    public List<String> generarTurnos(Profesional profesional) throws MiException, ParseException {
        List<String> turnosDisponibles = new ArrayList();
        System.out.println(profesional.getDia() + "  " + profesional.getDesde() + "  " + profesional.getHasta());

        turnosDisponibles = calculoHorarios(profesional.getDia(), profesional.getDesde(), profesional.getHasta());
        return turnosDisponibles;
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
    
    
    private List<String> calculoHorarios(String dia, String horaInicio, String horaFin) throws MiException, ParseException{
       
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
  
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        
        DateFormat dateFormatDay = new SimpleDateFormat("dd-MM-yyy");
    
        DateFormat dateFormatTime = new SimpleDateFormat("HH:mm");
        
        
        Date fechaHoy = new Date();
        String fechaActual = dateFormat.format(fechaHoy); 
   
        System.out.println("valor de dia dentro de calculoHorario" + dia);

        int nrodia=0;
        switch (dia) {
                case "lunes": nrodia=1;
                            break;
                case "martes": nrodia=2;
                            break;
                case "miercoles": nrodia=3;
                            break;
                case "jueves": nrodia=4;
                            break;
                case "viernes": nrodia=5;
                            break;     
                case "sabado": nrodia=6;
                            break;            
                default: nrodia=7;
                        break;
        }


        // generar los turnos disponibles
 
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.set(Calendar.DAY_OF_MONTH, 1);
        fechaInicio.set(Calendar.MONTH, Calendar.getInstance().get(Calendar.MONTH));
        fechaInicio.set(Calendar.HOUR_OF_DAY, 0);
        fechaInicio.set(Calendar.MINUTE, 0);
        fechaInicio.set(Calendar.SECOND, 0);
        fechaInicio.set(Calendar.MILLISECOND, 0);

        Calendar fechaFin = (Calendar) fechaInicio.clone();
        fechaFin.set(Calendar.MONTH, fechaFin.get(Calendar.MONTH) + 1);

        List <String> horarios = new ArrayList<>();
 
        System.out.println("valor de horaInicio" + horaInicio);
       
        while (fechaInicio.before(fechaFin)) {
    
            int diaSemana = fechaInicio.get(Calendar.DAY_OF_WEEK);
         
            if (diaSemana == nrodia){
             
                horarios.add(horaInicio);
                Calendar cal = Calendar.getInstance();
                cal.setTime(timeFormat.parse(horaInicio));
                cal.add(Calendar.MINUTE, 30);
                horaInicio = timeFormat.format(cal.getTime());
            }
    
            fechaInicio.add(Calendar.DAY_OF_MONTH, 1);
        }
        

        for (String key : horarios) {
            System.out.println(key);
        }
        return horarios;
      }
  
}




