package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.app.dominio.TipoIdentificacionDominio;

public interface TipoIdentificacionJpaDAO extends JpaRepository<TipoIdentificacionDominio, Integer> {

}
