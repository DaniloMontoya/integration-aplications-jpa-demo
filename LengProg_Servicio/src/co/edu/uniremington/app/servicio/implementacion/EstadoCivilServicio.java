package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.app.datos.jpa.EstadoCivilJpaDAO;
import co.edu.uniremington.app.dominio.EstadoCivilDominio;
import co.edu.uniremington.app.servicio.IEstadoCivilServicio;

@Transactional
@Service("estadoCivilNegocio")
public class EstadoCivilServicio implements IEstadoCivilServicio {
	
	@Autowired
	private EstadoCivilJpaDAO dao;

	@Override
	public void crear(EstadoCivilDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void actualizar(EstadoCivilDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void eliminar(EstadoCivilDominio dominio) {
		dao.delete(dominio);
		
	}

	@Override
	public List<EstadoCivilDominio> consultar(EstadoCivilDominio dominio) {
		return dao.findAll();
	}


}
