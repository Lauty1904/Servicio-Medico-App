package com.news.egg.entidades;

import com.news.egg.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Paciente extends Usuario {
      
    private int idobraSocial;
    private Date nacimiento;
    private int edad;
    private String genero;


    public Paciente() {
    }

    public Paciente(int idobraSocial, Date nacimiento, int edad, String genero) {
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
    }

    public Paciente(int idobraSocial, Date nacimiento, int edad, String genero, Long id, String password, String password2, String email, String nombre, String apellido, Integer dni, String domicilio, Rol rol) {
        super(id, password, password2, email, nombre, apellido, dni, domicilio, rol);
        this.idobraSocial = idobraSocial;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
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
    
    
    
    
    
        
    
}
