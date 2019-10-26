package co.edu.uniremington.par.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.par.dominio.AplicacionDominio;

@Repository
public interface AplicacionJpaDAO extends JpaRepository<AplicacionDominio, Integer>{

}
