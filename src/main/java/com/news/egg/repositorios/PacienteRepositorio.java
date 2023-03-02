
package com.news.egg.repositorios;

;
import com.news.egg.entidades.Paciente;
import com.news.egg.entidades.Turno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository <Paciente, Long> {
    
    @Query ("SELECT p FROM Paciente p WHERE p.idobrasocial = :id")
    public Paciente buscarPorIdOS(@Param("id") Long id) throws NullPointerException;
    
    @Query("SELECT p FROM Paciente")
    public List<Paciente> listarPacientes();
    
    @Query("SELECT p FROM Paciente p WHERE p.obrasocial = :os")
    public List<Paciente> listarPorOS(@Param("os") String os);
    
    @Query ("SELECT p FROM Paciente p WHERE p.turnos = :turno")
    public Paciente buscarPorTurno(@Param("turno") Turno turno) throws NullPointerException;
}
