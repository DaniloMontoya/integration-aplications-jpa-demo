package co.edu.uniremington.par.datos.jpa.customizacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uniremington.par.dominio.ParametroDominio;

@Repository
public interface ParametroJpaDAOCustom {
	
	List<ParametroDominio> consultar(ParametroDominio parametro);

}
