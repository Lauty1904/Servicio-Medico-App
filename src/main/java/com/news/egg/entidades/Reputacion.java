package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Reputacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    private int calificacion; //valoracion de 1 a 5
    private String comentario;
    
    private Profesional profesional;

    public Reputacion() {
    }

    public Reputacion(Long id, int calificacion, String comentario, Profesional profesional) {
        this.id = id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.profesional = profesional;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
    
    
    
}
