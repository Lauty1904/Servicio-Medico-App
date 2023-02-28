package com.news.egg.entidades;


import com.news.egg.enumeraciones.ObraSocial;
import com.news.egg.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Paciente")
public class Paciente extends Usuario {

    private int idobraSocial;
    private Date nacimiento;
    private String genero;

    @Enumerated(EnumType.STRING)
    private ObraSocial obraSocial;

    @OneToOne
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(int idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, HistoriaClinica historiaClinica) {
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.obraSocial = obraSocial;        
        this.historiaClinica = historiaClinica;
    }

    public Paciente(int idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, HistoriaClinica historiaClinica, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, int numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.obraSocial = obraSocial;        
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
