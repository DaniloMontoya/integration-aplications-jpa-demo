package co.edu.uniremington.lengprog.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.lengprog.app.dominio.TipoIdentificacionDominio;

public interface TipoIdentificacionJpaDAO extends JpaRepository<TipoIdentificacionDominio, Integer> {

}
