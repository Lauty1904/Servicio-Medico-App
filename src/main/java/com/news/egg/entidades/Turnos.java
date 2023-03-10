
package com.news.egg.entidades;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;


public class Turnos {
  private Map<Date, List<Turno>> turnosDisponibles;

  //Constructores
  public Turnos() {
    this.turnosDisponibles = new HashMap<>();
  }

  
  
  public void agregarTurno(Date fecha, Turno turno) {
    List<Turno> turnos = this.turnosDisponibles.getOrDefault(fecha, new ArrayList<>());
    turnos.add(turno);
    this.turnosDisponibles.put(fecha, turnos);
  }

  public List<Date> getTurnosDisponiblesKeys() {
    List<Date> keys = new ArrayList<>(this.turnosDisponibles.keySet());
    Collections.sort(keys);
    return keys;
  }

  public List<Turno> getTurnosDisponibles(Date fecha) {
    return this.turnosDisponibles.getOrDefault(fecha, new ArrayList<>());
  }

  public Turno getTurnoDisponible(Date fecha) {
    List<Turno> turnos = this.turnosDisponibles.getOrDefault(fecha, new ArrayList<>());
    for (Turno turno : turnos) {
      if (turno.getPaciente() == null) {
        return turno;
      }
    }
    return null;
  }
}
  
  
  
