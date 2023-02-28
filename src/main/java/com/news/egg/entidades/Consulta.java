package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Consulta extends Turno {
   
    @OneToOne
    private Turno turno;
    
    private String diagnostico;
    private boolean status;
 
    //Constructores

    public Consulta() {
    }

    public Consulta (Turno turno, String diagnostico, boolean status) {

        this.turno = turno;
        this.diagnostico = diagnostico;
        this.status = status;
    }

      
    //Getters y Setters

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
}

