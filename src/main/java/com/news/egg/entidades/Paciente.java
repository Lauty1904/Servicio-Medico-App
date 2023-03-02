package com.news.egg.entidades;


import com.news.egg.enumeraciones.ObraSocial;
import com.news.egg.enumeraciones.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="Paciente")
public class Paciente extends Usuario implements Serializable {

    private Long idobraSocial;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nacimiento;
    private String genero;

    @Enumerated(EnumType.STRING)
    private ObraSocial obraSocial;

    @ManyToOne
    private List<Turno> turnos;
    
    @OneToOne
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(Long idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, HistoriaClinica historiaClinica) {
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.obraSocial = obraSocial;        
        this.historiaClinica = historiaClinica;
        this.turnos = new ArrayList();
    }

    public Paciente(Long idobraSocial, Date nacimiento, String genero, ObraSocial obraSocial, HistoriaClinica historiaClinica, Long id, String password, String password2, String email, String nombre, String apellido, int dni, String domicilio, int numeroTelefono, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, numeroTelefono, rol);
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.obraSocial = obraSocial;        
        this.historiaClinica = historiaClinica;
        this.turnos = new ArrayList();
    }




    //Getters y Setters
    public Long getIdobraSocial() {
        return idobraSocial;
    }

    public void setIdobraSocial(Long idobraSocial) {
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

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

}
