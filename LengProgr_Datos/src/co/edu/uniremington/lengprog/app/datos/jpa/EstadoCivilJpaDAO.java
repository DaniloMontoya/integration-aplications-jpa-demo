package co.edu.uniremington.lengprog.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.lengprog.app.dominio.EstadoCivilDominio;

public interface EstadoCivilJpaDAO extends JpaRepository<EstadoCivilDominio, Integer> {

}
