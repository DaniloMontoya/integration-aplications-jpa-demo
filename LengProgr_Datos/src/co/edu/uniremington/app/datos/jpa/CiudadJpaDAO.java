package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.app.dominio.CiudadDominio;

public interface CiudadJpaDAO extends JpaRepository<CiudadDominio, Integer> {

}
