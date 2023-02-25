package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private Long IdTurno;
    private boolean status;
    @OneToOne
    private Profesional profesional;
    @OneToOne
    private Paciente paciente;
    private int calificacion;
    //private Calendario calendario;
    
    //Constructores

    public Turno() {
    }

    public Turno(Long IdTurno, boolean status, Profesional profesional, Paciente paciente) {
        this.IdTurno = IdTurno;
        this.status = status;
        this.profesional = profesional;
        this.paciente = paciente;
    }
   
    
    //Getters y Setters

    public Long getIdTurno() {
        return IdTurno;
    }

    public void setIdTurno(Long IdTurno) {
        this.IdTurno = IdTurno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
    
}
