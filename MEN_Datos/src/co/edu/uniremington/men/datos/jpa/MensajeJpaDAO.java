package co.edu.uniremington.men.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.men.datos.jpa.customizacion.MensajeJpaDAOCustom;
import co.edu.uniremington.men.dominio.MensajeDominio;

@Repository
public interface MensajeJpaDAO extends JpaRepository<MensajeDominio, Integer>,MensajeJpaDAOCustom{

}
