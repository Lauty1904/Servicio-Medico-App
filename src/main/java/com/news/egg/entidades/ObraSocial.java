
package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ObraSocial {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private int idObraSocial;
    private String nombre;
    
    //Constructores

    public ObraSocial() {
    }

    public ObraSocial(int idObraSocial, String nombre) {
        this.idObraSocial = idObraSocial;
        this.nombre = nombre;
    }
    
    
    //Getters y Setters

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
