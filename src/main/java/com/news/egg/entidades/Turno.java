package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private int IdTurno;
    private boolean status;
    private Profesional profesional;
    private Paciente paciente;
    //private Calendario calendario;
    
    //Constructores

    public Turno() {
    }

    public Turno(int IdTurno, boolean status, Profesional profesional, Paciente paciente) {
        this.IdTurno = IdTurno;
        this.status = status;
        this.profesional = profesional;
        this.paciente = paciente;
    }
    
    //Getters y Setters

    public int getIdTurno() {
        return IdTurno;
    }

    public void setIdTurno(int IdTurno) {
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
