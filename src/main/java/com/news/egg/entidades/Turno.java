package com.news.egg.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long IdTurno;
    private boolean status = false;
    private int calificacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Turno", nullable = false)
    private Date fechaTurno;

    @Column(name = "Hora_Turno", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaTurno;

    @Column(name = "Fecha_ALta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Profesional", nullable = false)
    private Profesional profesional;

    @OneToOne
    @JoinColumn(name = "Paciente", nullable = false)
    private Paciente paciente;

    public Turno() {
    }

    public Turno(Long IdTurno, boolean status, int calificacion, Date fechaTurno, Date horaTurno, Date fechaAlta, Profesional profesional, Paciente paciente) {
        this.IdTurno = IdTurno;
        this.status = status;
        this.calificacion = calificacion;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.fechaAlta = fechaAlta;
        this.profesional = profesional;
        this.paciente = paciente;
    }

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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Date getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(Date horaTurno) {
        this.horaTurno = horaTurno;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
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
