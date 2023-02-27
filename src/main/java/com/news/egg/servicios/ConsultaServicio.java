package com.news.egg.servicios;

import com.news.egg.entidades.Consulta;
import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Profesional;
import com.news.egg.entidades.Turno;
import com.news.egg.excepciones.MiException;
import com.news.egg.repositorios.ConsultaRepositorio;
import com.news.egg.repositorios.TurnoRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


public class ConsultaServicio extends Turno {
    
    @Autowired
    private TurnoRepositorio turnoRepositorio;
    
    @Autowired
    private ConsultaRepositorio consultaRepositorio;

    @Transactional
    public void registrarConsulta (Long IdConsulta, String diagnostico, Turno turno, Paciente paciente, Profesional profesional) throws MiException {

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(IdConsulta);
        consulta.setTurno(turno);
        consulta.setDiagnostico(diagnostico);
        consulta.setStatus(true);

    }

       public List<Consulta> listarConsultas() {

        List<Consulta> consultas = new ArrayList();
        consultas = consultaRepositorio.findAll();

        return consultas;
    }
    
   
    public Consulta getOne(Long IdConsulta){
        return consultaRepositorio.getOne(IdConsulta);
    }
    

}
