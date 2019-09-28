package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.app.datos.jpa.DeparatamentoJpaDAO;
import co.edu.uniremington.app.dominio.DepartamentoDominio;
import co.edu.uniremington.app.servicio.IDepartamentoServicio;

@Transactional
@Service("departamentoNegocio")
public class DepartamentoServicio implements IDepartamentoServicio{
	
	@Autowired
	private DeparatamentoJpaDAO dao;

	@Override
	public void crear(DepartamentoDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void actualizar(DepartamentoDominio dominio) {
		dao.save(dominio);
		
	}

	@Override
	public void eliminar(DepartamentoDominio dominio) {
		dao.delete(dominio);
		
	}

	@Override
	public List<DepartamentoDominio> consultar(DepartamentoDominio dominio) {
		return dao.findAll();
	}

}
