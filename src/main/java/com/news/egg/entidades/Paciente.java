package com.news.egg.entidades;


import com.news.egg.enumeraciones.ObraSocial;
import com.news.egg.enumeraciones.Rol;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Paciente")
public class Paciente extends Usuario {

    private int idobraSocial;
    private Date nacimiento;
    private int edad;
    private String genero;

    @Enumerated(EnumType.STRING)
    private ObraSocial obraSocial;

    @OneToOne
    private Turno turno;
    @OneToOne
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(int idobraSocial, Date nacimiento, int edad, String genero, ObraSocial obraSocial, Turno turno, HistoriaClinica historiaClinica) {
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
        this.obraSocial = obraSocial;
        this.turno = turno;
        this.historiaClinica = historiaClinica;
    }


    
   
    //Getters y Setters

    public Paciente(int idobraSocial, Date nacimiento, int edad, String genero, ObraSocial obraSocial, Turno turno, HistoriaClinica historiaClinica, Long id, String password, String password2, String email, String nombre, String apellido, Integer dni, String domicilio, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, rol);
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
        this.obraSocial = obraSocial;
        this.turno = turno;
        this.historiaClinica = historiaClinica;
    }


    //Getters y Setters
    public int getIdobraSocial() {
        return idobraSocial;
    }

    public void setIdobraSocial(int idobraSocial) {
        this.idobraSocial = idobraSocial;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

}
