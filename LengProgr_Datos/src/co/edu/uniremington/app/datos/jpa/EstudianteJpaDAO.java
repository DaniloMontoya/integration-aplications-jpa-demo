package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.app.dominio.EstudianteDominio;

public interface EstudianteJpaDAO extends JpaRepository<EstudianteDominio, Integer> {

}
