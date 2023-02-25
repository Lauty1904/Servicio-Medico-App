package com.news.egg.entidades;

import com.news.egg.enumeraciones.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Profesional extends Usuario {
    
    private double honorario;
    private List disponibilidad;//esto va relacionado con calendario
    private int idespecialidad;

   //Holi prueba
    //Constructores

    public Profesional() {
    }

    public Profesional(double honorario, List disponibilidad, int idespecialidad) {
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
        this.idespecialidad = idespecialidad;
    }

    public Profesional(double honorario, List disponibilidad, int idespecialidad, Long id, String password, String password2, String email, String nombre, String apellido, Integer dni, String domicilio, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, rol);
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
        this.idespecialidad = idespecialidad;
    }

   
    
    
    //Getters y Setters

    public double getHonorario() {
        return honorario;
    }

    public void setHonorario(double honorario) {
        this.honorario = honorario;
    }

    public List getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(List disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    
    

}
