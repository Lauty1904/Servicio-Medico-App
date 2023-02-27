package com.news.egg.entidades;

import com.news.egg.enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Profesional")
public class Profesional extends Usuario {
    
    private double honorario;
    private int disponibilidad;//esto va relacionado con calendario
    //javi hacé enum especialidad

    //Constructores
    public Profesional() {
    }

    public Profesional(double honorario, int disponibilidad) {
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
    }

    public Profesional(double honorario, int disponibilidad, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, int numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
    }

    //Getters y Setters
    public double getHonorario() {
        return honorario;
    }

    public void setHonorario(double honorario) {
        this.honorario = honorario;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
