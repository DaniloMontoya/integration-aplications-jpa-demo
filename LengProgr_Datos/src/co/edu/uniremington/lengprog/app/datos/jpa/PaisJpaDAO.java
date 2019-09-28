package co.edu.uniremington.lengprog.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.lengprog.app.dominio.PaisDominio;

@Repository
public interface PaisJpaDAO extends JpaRepository<PaisDominio, Integer>{

}
