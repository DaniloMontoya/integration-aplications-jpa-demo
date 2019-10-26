package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.app.datos.jpa.EstadoCivilJpaDAO;
import co.edu.uniremington.app.dominio.EstadoCivilDominio;
import co.edu.uniremington.app.servicio.IEstadoCivilServicio;

@Service
public class EstadoCivilServicio implements IEstadoCivilServicio{

	@Autowired
	private EstadoCivilJpaDAO estadoDao;
	
	@Override
	public void crear(EstadoCivilDominio dominio) {
		estadoDao.save(dominio);
	}

	@Override
	public void actualizar(EstadoCivilDominio dominio) {
		estadoDao.save(dominio);
	}

	@Override
	public void eliminar(EstadoCivilDominio dominio) {
		estadoDao.delete(dominio);
	}

	@Override
	public List<EstadoCivilDominio> consultar(EstadoCivilDominio dominio) {
		return estadoDao.findAll();
	}
}
