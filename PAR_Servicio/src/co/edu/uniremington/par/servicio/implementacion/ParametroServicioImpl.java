package co.edu.uniremington.par.servicio.implementacion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniremington.par.datos.jpa.ParametroJpaDAO;
import co.edu.uniremington.par.dominio.ParametroDominio;
import co.edu.uniremington.par.servicio.IParametroServicio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@Transactional
@Service("parametroServicio")
public class ParametroServicioImpl implements IParametroServicio {

	@Autowired
	private ParametroJpaDAO dao;

	@Override
	public void crear(ParametroDominio dominio) {
		try {
			// 1. Asegurar que no exista un parametro con el nombre enviado
			ParametroDominio parametroDominio = new ParametroDominio();
			parametroDominio.setValor(dominio.getValor());

			if (!dao.consultar(parametroDominio).isEmpty()) {
				throw ExcepcionCustomizada.crear("El parametro con el valor enviado ya existe",
						ComponenteEnumeracion.SERVICIO);
			}
			// 2. Creamos el parametro
			dao.save(dominio);

		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas creando el parametro deseado";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la creacion de los parametros, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}

	}

	@Override
	public void actualizar(ParametroDominio dominio) {
		try {
			// 1. Exista un pais con el codigo enviado
			ParametroDominio parametroFiltro = new ParametroDominio();
			parametroFiltro.setCodigo(dominio.getCodigo());

			if (dao.consultar(parametroFiltro).isEmpty()) {
				String mensajeUsuario = "El parametro que intenta modificar no existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 2. Asegurar que ya no exista otro parametro con el mismo valor
			parametroFiltro = new ParametroDominio();
			parametroFiltro.setValor(dominio.getValor());

			List<ParametroDominio> resultado = dao.consultar(parametroFiltro);

			if (!resultado.isEmpty() && resultado.get(0).getCodigo() != dominio.getCodigo()) {
				String mensajeUsuario = "El parametro que intenta modificar ya existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 3. Modificar el parametro
			dao.save(dominio);
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas modificando el parametro deseado...";
			String mensajeUsuario = "Se ha presentado un problema, tratando de llevar a cabo la modificacion del parametro deseado. Por favor intente de nuevo y si el problema persiste, contacte al administrador...";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}

	}

	@Override
	public void eliminar(ParametroDominio dominio) {
		try {
			// 1. Exista un parametro con el codigo enviado
			ParametroDominio parametroFiltro = new ParametroDominio();
			parametroFiltro.setCodigo(dominio.getCodigo());

			if (dao.consultar(parametroFiltro).isEmpty()) {
				String mensajeUsuario = "El parametro que intenta eliminar no existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 2. Eliminar el parametro
			dao.delete(dominio);
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas eliminando el parametro deseado...";
			String mensajeUsuario = "Se ha presentado un problema, tratando de llevar a cabo la eliminacion del pais deseado. Por favor intente de nuevo y si el problema persiste, contacte al administrador...";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}

	}

	@Override
	public List<ParametroDominio> consultar(ParametroDominio dominio) {
		if(dominio != null) {
			return dao.consultar(dominio);
		}else {
			return dao.findAll();
		}
	}

}
