package co.edu.uniremington.lengprog.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.lengprog.app.datos.jpa.EstudianteJpaDAO;
import co.edu.uniremington.lengprog.app.dominio.EstudianteDominio;
import co.edu.uniremington.lengprog.app.servicio.IEstudianteServicio;

@Transactional
@Service("estudianteNegocio")
public class EstudianteServicio implements IEstudianteServicio {

	@Autowired
	private EstudianteJpaDAO dao;

	@Override
	public void crear(EstudianteDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void actualizar(EstudianteDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void eliminar(EstudianteDominio dominio) {
		dao.delete(dominio);

	}

	@Override
	public List<EstudianteDominio> consultar(EstudianteDominio dominio) {
		return dao.findAll();
	}

}
