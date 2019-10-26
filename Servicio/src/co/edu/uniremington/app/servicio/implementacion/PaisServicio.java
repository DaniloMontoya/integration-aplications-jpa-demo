package co.edu.uniremington.app.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.app.datos.jpa.PaisJpaDAO;
import co.edu.uniremington.app.dominio.PaisDominio;
import co.edu.uniremington.app.servicio.IPaisServicio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;
import co.edu.uniremington.transversal.mensajes.CatalogoMensajes;
import co.edu.uniremington.transversal.notificacion.Notificacion;
import co.edu.uniremington.transversal.parametros.CatalogoParametros;

@Transactional
@Service("PaisNegocio")
public class PaisServicio implements IPaisServicio{
	
	@Autowired
	private PaisJpaDAO paisDao;
	
	@Autowired
	private CatalogoMensajes catalogoMensajes;
	
	@Autowired
	private CatalogoParametros catalogoParametros;
	
	@Autowired
	private Notificacion notificador;

	@Override
	public void crear(PaisDominio dominio) {
		try {
			// 1. Asegurar que no exista un pais con el nombre enviado
			PaisDominio paisFiltro = new PaisDominio();
			paisFiltro.setNombre(dominio.getNombre());
			
			if(!paisDao.consultar(paisFiltro).isEmpty()) {
				String mensajeUsuario = catalogoMensajes.obtenerMensaje("APP", "APP_USU_ERR_0001").getMensaje();
				throw ExcepcionCustomizada.crear(mensajeUsuario, ComponenteEnumeracion.SERVICIO);
			}
			// 2. Creamos el pais
			paisDao.save(dominio);
			String parametroCorreo = catalogoParametros.obtenerParametro("APP", "NOMBRE_APP_EDISON").getValor();
			notificador.notificar(parametroCorreo, "Se creo un pais!!!", "crearon pais " + dominio.getNombre());
			
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas creando los paises deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la creacion de los paises, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
			
			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

	@Override
	public void actualizar(PaisDominio dominio) {
		try {
			// 1. Exista un pais con el codigo enviado
			PaisDominio paisFiltro = new PaisDominio();
			paisFiltro.setCodigo(dominio.getCodigo());
			
			if(paisDao.consultar(paisFiltro).isEmpty()) {
				throw ExcepcionCustomizada.crear("El pais que intenta modificar no existe", ComponenteEnumeracion.SERVICIO);
			}
			
			// 2.Asegurar que no exista otro pais con el mismo nombre
			paisFiltro = new PaisDominio();
			paisFiltro.setNombre(dominio.getNombre());
			
			List<PaisDominio> resultado = paisDao.consultar(paisFiltro);
			
			if(!resultado.isEmpty() && resultado.get(0).getCodigo() != dominio.getCodigo()) {
				throw ExcepcionCustomizada.crear("El pais que intenta modificar ya existe", ComponenteEnumeracion.SERVICIO);
			}
			
			paisDao.save(dominio);
			
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas actualizando los paises deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la actualización de los paises, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
			
			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

	@Override
	public void eliminar(PaisDominio dominio) {
		try {
			// 1. Exista un pais con el codigo enviado
			PaisDominio paisFiltro = new PaisDominio();
			paisFiltro.setCodigo(dominio.getCodigo());
			
			if(paisDao.consultar(paisFiltro).isEmpty()) {
				throw ExcepcionCustomizada.crear("El pais que intenta eliminar no existe", ComponenteEnumeracion.SERVICIO);
			}
			
			paisDao.delete(dominio);
			
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas eliminando el pais deseado";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la eliminacion del pais, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
			
			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

	@Override
	public List<PaisDominio> consultar(PaisDominio dominio) {
		if(dominio != null) {
			return paisDao.consultar(dominio);
		}else {
			return paisDao.findAll();
		}
		
	}
	

}
