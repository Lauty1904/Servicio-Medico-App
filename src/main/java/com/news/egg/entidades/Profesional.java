package com.news.egg.entidades;

import com.news.egg.enumeraciones.Especialidad;
import com.news.egg.enumeraciones.Rol;
import javax.persistence.Entity;

@Entity
public class Profesional extends Usuario {
    
    private double honorario;
    //private Calendario disponibilidad;//esto va relacionado con calendario
    private Especialidad especialidad;
   
    //Constructores

    public Profesional() {
    }
    
    public Profesional(double honorario, Calendario disponibilidad, Especialidad especialidad) {
        this.honorario = honorario;
        //this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
    }

    public Profesional(double honorario, Calendario disponibilidad, Especialidad especialidad, Long id, String password, String password2, String email, String nombre, String apellido, Integer dni, String domicilio, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, rol);
        this.honorario = honorario;
        //this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
    }

    
    
    //Getters y Setters

    public double getHonorario() {
        return honorario;
    }

    public void setHonorario(double honorario) {
        this.honorario = honorario;
    }
    /*
    public Calendario getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Calendario disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    
    
}
