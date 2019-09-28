package co.edu.uniremington.lengprog.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.lengprog.app.datos.jpa.TipoIdentificacionJpaDAO;
import co.edu.uniremington.lengprog.app.dominio.TipoIdentificacionDominio;
import co.edu.uniremington.lengprog.app.servicio.ITipoIdentificacionServicio;

@Transactional
@Service("tipoIdentificacionNegocio")
public class TipoIdentificacionServicio implements ITipoIdentificacionServicio {

	@Autowired
	private TipoIdentificacionJpaDAO dao;
	
	@Override
	public void crear(TipoIdentificacionDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void actualizar(TipoIdentificacionDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void eliminar(TipoIdentificacionDominio dominio) {
		dao.delete(dominio);

	}

	@Override
	public List<TipoIdentificacionDominio> consultar(TipoIdentificacionDominio dominio) {
		return dao.findAll();
	}

}
