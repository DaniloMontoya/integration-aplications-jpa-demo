package co.edu.uniremington.app.datos.jpa.customizacion;

import java.util.List;
import org.springframework.stereotype.Repository;
import co.edu.uniremington.app.dominio.PaisDominio;

@Repository
public interface PaisJpaDAOCustom {

	List<PaisDominio> consultar(PaisDominio pais);
}
