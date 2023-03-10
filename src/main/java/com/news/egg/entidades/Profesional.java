package com.news.egg.entidades;

import com.news.egg.enumeraciones.Especialidad;
import com.news.egg.enumeraciones.Rol;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Profesional extends Usuario implements Serializable {

    private double honorario;
    private int disponibilidad; //esto va relacionado con calendario
    private String dia;
    private String desde;
    private String hasta;
    
    @OneToMany
    private List<Turno> listaTurnos;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    
 

    //Constructores
    
    public Profesional() {
    }

    public Profesional(double honorario, int disponibilidad, String dia, String desde, String hasta, List<Turno> listaTurnos, Especialidad especialidad) {
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
        this.dia = dia;
        this.desde = desde;
        this.hasta = hasta;
        this.listaTurnos = listaTurnos;
        this.especialidad = especialidad;
    }

    public Profesional(double honorario, int disponibilidad, String dia, String desde, String hasta, List<Turno> listaTurnos, Especialidad especialidad, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, Long numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.honorario = honorario;
        this.disponibilidad = disponibilidad;
        this.dia = dia;
        this.desde = desde;
        this.hasta = hasta;
        this.listaTurnos = listaTurnos;
        this.especialidad = especialidad;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    

}
