package co.edu.uniremington.par.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.par.datos.jpa.customizacion.ParametroJpaDAOCustom;
import co.edu.uniremington.par.dominio.ParametroDominio;

@Repository
public interface ParametroJpaDAO extends JpaRepository<ParametroDominio, Integer>, ParametroJpaDAOCustom{

}
