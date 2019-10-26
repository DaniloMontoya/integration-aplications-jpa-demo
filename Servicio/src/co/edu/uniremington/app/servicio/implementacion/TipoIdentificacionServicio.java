package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.app.datos.jpa.TipoIdentificacionJpaDAO;
import co.edu.uniremington.app.dominio.TipoIdentificacionDominio;
import co.edu.uniremington.app.servicio.ITipoIdentificacionServicio;

@Service
public class TipoIdentificacionServicio implements ITipoIdentificacionServicio {

	@Autowired
	private TipoIdentificacionJpaDAO tipoDao;
	
	@Override
	public void crear(TipoIdentificacionDominio dominio) {
		tipoDao.save(dominio);
	}

	@Override
	public void actualizar(TipoIdentificacionDominio dominio) {
		tipoDao.save(dominio);
	}

	@Override
	public void eliminar(TipoIdentificacionDominio dominio) {
		tipoDao.delete(dominio);
	}

	@Override
	public List<TipoIdentificacionDominio> consultar(TipoIdentificacionDominio dominio) {
		return tipoDao.findAll();
	}

	
}
