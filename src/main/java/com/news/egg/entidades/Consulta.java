package com.news.egg.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Consulta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private Long idConsulta;
    
    private boolean status;
    @OneToOne
    private Turno turno;
    @OneToOne   
    private Profesional profesional;
    private String diagnostico;
    private Date fechaConsulta;
    @OneToOne
    private Paciente paciente;
 
    //Constructores

    public Consulta() {
    }

    public Consulta(Long idConsulta, boolean status, Turno turno, Profesional profesional, String diagnostico, Date fechaConsulta, Paciente paciente) {
        this.idConsulta = idConsulta;
        this.status = status;
        this.turno = turno;
        this.profesional = profesional;
        this.diagnostico = diagnostico;
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
    }
    
    //Getters y Setters

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
