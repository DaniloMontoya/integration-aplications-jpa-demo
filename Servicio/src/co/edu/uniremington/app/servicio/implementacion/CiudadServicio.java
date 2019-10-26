package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.app.datos.jpa.CiudadJpaDAO;
import co.edu.uniremington.app.dominio.CiudadDominio;
import co.edu.uniremington.app.servicio.ICiudadServicio;

@Service
public class CiudadServicio implements ICiudadServicio{
	
	@Autowired
	private CiudadJpaDAO ciudadDao;

	@Override
	public void crear(CiudadDominio dominio) {
		ciudadDao.save(dominio);
	}

	@Override
	public void actualizar(CiudadDominio dominio) {
		ciudadDao.save(dominio);
	}

	@Override
	public void eliminar(CiudadDominio dominio) {
		ciudadDao.delete(dominio);
	}

	@Override
	public List<CiudadDominio> consultar(CiudadDominio dominio) {
		return ciudadDao.findAll();
	}

}
