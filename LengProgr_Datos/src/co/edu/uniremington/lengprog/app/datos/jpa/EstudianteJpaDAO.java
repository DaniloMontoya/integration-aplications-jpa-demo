package co.edu.uniremington.lengprog.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.lengprog.app.dominio.EstudianteDominio;

public interface EstudianteJpaDAO extends JpaRepository<EstudianteDominio, Integer> {

}
