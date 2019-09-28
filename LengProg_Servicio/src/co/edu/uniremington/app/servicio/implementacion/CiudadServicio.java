package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.app.datos.jpa.CiudadJpaDAO;
import co.edu.uniremington.app.dominio.CiudadDominio;
import co.edu.uniremington.app.servicio.ICiudadServicio;

@Transactional
@Service("ciudadNegocio")
public class CiudadServicio implements ICiudadServicio {
	
	@Autowired
	private CiudadJpaDAO dao;

	@Override
	public void crear(CiudadDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void actualizar(CiudadDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void eliminar(CiudadDominio dominio) {
		dao.delete(dominio);
		
	}

	@Override
	public List<CiudadDominio> consultar(CiudadDominio dominio) {
		return dao.findAll();
	}

}
