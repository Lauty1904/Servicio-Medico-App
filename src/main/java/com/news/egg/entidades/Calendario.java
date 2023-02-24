
package com.news.egg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendario  {
    //modificar todo
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) 
    private int IdCalendario;
    private String nombre;
}
