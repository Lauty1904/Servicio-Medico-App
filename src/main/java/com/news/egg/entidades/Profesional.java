package com.news.egg.entidades;

import com.news.egg.enumeraciones.Especialidad;
import com.news.egg.enumeraciones.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table (name = "Profesional")
public class Profesional extends Usuario implements Serializable {

    private double honorario;
    private int disponibilidad; //esto va relacionado con calendario
    
    @OneToMany
    @JoinColumn(name = "Turnos", nullable = false)
    private List<Turno> listaTurnos;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    //Constructores
    public Profesional() {
    }

    public Profesional(double honorario, int disponibilidad, Especialidad especialidad) {
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
    }

    public Profesional(double honorario, int disponibilidad, Especialidad especialidad, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, int numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
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
