package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.app.dominio.EstadoCivilDominio;

public interface EstadoCivilJpaDAO extends JpaRepository<EstadoCivilDominio, Integer> {

}
