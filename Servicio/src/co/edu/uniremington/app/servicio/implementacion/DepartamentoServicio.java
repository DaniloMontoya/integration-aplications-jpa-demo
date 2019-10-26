package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.app.datos.jpa.DepartamentoJpaDAO;
import co.edu.uniremington.app.dominio.DepartamentoDominio;
import co.edu.uniremington.app.servicio.IDepartamentoServicio;

@Service
public class DepartamentoServicio implements IDepartamentoServicio {

	@Autowired
	private DepartamentoJpaDAO departamentoDao;

	@Override
	public void crear(DepartamentoDominio dominio) {
		departamentoDao.save(dominio);
	}

	@Override
	public void actualizar(DepartamentoDominio dominio) {
		departamentoDao.save(dominio);
	}

	@Override
	public void eliminar(DepartamentoDominio dominio) {
		departamentoDao.delete(dominio);
	}

	@Override
	public List<DepartamentoDominio> consultar(DepartamentoDominio dominio) {
		return departamentoDao.findAll();
	}

}
