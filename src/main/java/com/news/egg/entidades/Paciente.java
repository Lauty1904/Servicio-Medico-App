package com.news.egg.entidades;


import com.news.egg.enumeraciones.Genero;
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

    @Enumerated(EnumType.STRING)
    private ObraSocial obraSocial;

    @Enumerated(EnumType.STRING)
    private Genero genero;
     
    @OneToOne
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(int idobraSocial, Date nacimiento, ObraSocial obraSocial, Genero genero, HistoriaClinica historiaClinica) {
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.obraSocial = obraSocial;
        this.genero = genero;
        this.historiaClinica = historiaClinica;
    }

    public Paciente(int idobraSocial, Date nacimiento, ObraSocial obraSocial, Genero genero, HistoriaClinica historiaClinica, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, Long numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.obraSocial = obraSocial;
        this.genero = genero;
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

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
    

}