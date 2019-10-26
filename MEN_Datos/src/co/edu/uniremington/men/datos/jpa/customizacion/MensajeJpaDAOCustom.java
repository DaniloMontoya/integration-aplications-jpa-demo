package co.edu.uniremington.men.datos.jpa.customizacion;

import java.util.List;
import org.springframework.stereotype.Repository;
import co.edu.uniremington.men.dominio.MensajeDominio;

@Repository
public interface MensajeJpaDAOCustom {
	
	List<MensajeDominio> consultar(MensajeDominio mensaje);

}
