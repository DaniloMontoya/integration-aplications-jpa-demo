package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.app.datos.jpa.customizacion.PaisJpaDAOCustom;
import co.edu.uniremington.app.dominio.PaisDominio;

@Repository
public interface PaisJpaDAO extends JpaRepository<PaisDominio, Integer>, PaisJpaDAOCustom {

}
