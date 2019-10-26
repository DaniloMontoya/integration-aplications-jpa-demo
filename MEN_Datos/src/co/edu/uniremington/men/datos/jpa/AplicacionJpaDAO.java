package co.edu.uniremington.men.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.men.dominio.AplicacionDominio;

@Repository
public interface AplicacionJpaDAO extends JpaRepository<AplicacionDominio, Integer>{

}
