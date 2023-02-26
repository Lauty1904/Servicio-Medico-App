package com.news.egg.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Consulta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private Long idConsulta;  
    
    @OneToOne
    private Turno turno;
    
    private String diagnostico;
   private boolean status;
 
    //Constructores

    public Consulta() {
    }

    public Consulta(Long idConsulta, Turno turno, String diagnostico, boolean status) {
        this.idConsulta = idConsulta;
        this.turno = turno;
        this.diagnostico = diagnostico;
        this.status = status;
    }

      
    //Getters y Setters

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

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
