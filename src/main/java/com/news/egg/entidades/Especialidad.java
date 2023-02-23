
package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private int IdEspecialidad;
    private String nombre;
    
    //Constructores

    public Especialidad() {
    }

    public Especialidad(int IdEspecialidad, String nombre) {
        this.IdEspecialidad = IdEspecialidad;
        this.nombre = nombre;
    }
    
    //Getters y Setters

    public int getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(int IdEspecialidad) {
        this.IdEspecialidad = IdEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
