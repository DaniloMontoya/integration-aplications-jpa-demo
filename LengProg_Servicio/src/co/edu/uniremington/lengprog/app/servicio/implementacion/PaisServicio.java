package co.edu.uniremington.lengprog.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.lengprog.app.datos.jpa.PaisJpaDAO;
import co.edu.uniremington.lengprog.app.dominio.PaisDominio;
import co.edu.uniremington.lengprog.app.servicio.IPaisServicio;

@Transactional
@Service("paisNegocio")
public class PaisServicio implements IPaisServicio {

	@Autowired
	private PaisJpaDAO dao;

	@Override
	public void crear(PaisDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void actualizar(PaisDominio dominio) {
		dao.save(dominio);

	}

	@Override
	public void eliminar(PaisDominio dominio) {
		dao.delete(dominio);

	}

	@Override
	public List<PaisDominio> consultar(PaisDominio dominio) {
		return dao.findAll();
	}

}
