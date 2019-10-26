package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.app.datos.jpa.EstudianteJpaDAO;
import co.edu.uniremington.app.dominio.EstudianteDominio;
import co.edu.uniremington.app.servicio.IEstudianteServicio;

@Service
public class EstudianteServicio implements IEstudianteServicio {

	@Autowired
	private EstudianteJpaDAO estudianteDao;
	
	@Override
	public void crear(EstudianteDominio dominio) {
		estudianteDao.save(dominio);
	}

	@Override
	public void actualizar(EstudianteDominio dominio) {
		estudianteDao.save(dominio);
	}

	@Override
	public void eliminar(EstudianteDominio dominio) {
		estudianteDao.delete(dominio);
	}

	@Override
	public List<EstudianteDominio> consultar(EstudianteDominio dominio) {
		return estudianteDao.findAll();
	}

}
