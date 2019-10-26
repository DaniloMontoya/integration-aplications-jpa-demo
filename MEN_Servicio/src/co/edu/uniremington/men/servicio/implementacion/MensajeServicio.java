package co.edu.uniremington.men.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniremington.men.datos.jpa.MensajeJpaDAO;
import co.edu.uniremington.men.dominio.MensajeDominio;
import co.edu.uniremington.men.servicio.IMensajeServicio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@Transactional
@Service("MensajeServicio")
public class MensajeServicio implements IMensajeServicio{
	
	@Autowired
	private MensajeJpaDAO mensajeDAO;

	@Override
	public void crear(MensajeDominio dominio) {
		try {
			// 1. Asegurar que no exista un pais con el nombre enviado
			MensajeDominio mensajeDominio = new MensajeDominio();
			mensajeDominio.setMensaje(dominio.getMensaje());
			
			if(!mensajeDAO.consultar(mensajeDominio).isEmpty()) {
				throw ExcepcionCustomizada.crear("El mensaje con el nombre enviado ya existe", ComponenteEnumeracion.SERVICIO);
			}
			// 2. Creamos el país
			mensajeDAO.save(dominio);
			
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas creando los mensajes deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la creacion de los paises, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
			
			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

	@Override
	public void actualizar(MensajeDominio dominio) {
		try {
			// 1. Exista un pais con el c�digo enviado
			MensajeDominio MensajeFiltro = new MensajeDominio();
			MensajeFiltro.setCodigo(dominio.getCodigo());

			if (mensajeDAO.consultar(MensajeFiltro).isEmpty()) {
				String mensajeUsuario = "El pa�s que intenta modificar no existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 2. Asegurar que ya no exista otro pa�s con el mismo nombre
			MensajeFiltro = new MensajeDominio();
			MensajeFiltro.setMensaje(dominio.getMensaje());

			List<MensajeDominio> resultado = mensajeDAO.consultar(MensajeFiltro);

			if (!resultado.isEmpty() && resultado.get(0).getCodigo() != dominio.getCodigo()) {
				String mensajeUsuario = "El pa�s que intenta modificar ya existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 3. Modificar el pa�s
			mensajeDAO.save(dominio);
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas modificando el pa�s deseado...";
			String mensajeUsuario = "Se ha presentado un problema, tratando de llevar a cabo la modificaci�n del pa�s deseado. Por favor intente de nuevo y si el problema persiste, contacte al administrador...";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
		
	}

	@Override
	public void eliminar(MensajeDominio dominio) {
		try {
			// 1. Exista un pais con el c�digo enviado
			MensajeDominio MensajeFiltro = new MensajeDominio();
			MensajeFiltro.setCodigo(dominio.getCodigo());

			if (mensajeDAO.consultar(MensajeFiltro).isEmpty()) {
				String mensajeUsuario = "El pa�s que intenta eliminar no existe...";
				ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;
				throw ExcepcionCustomizada.crear(mensajeUsuario, componente);
			}

			// 2. Eliminar el pa�s
			mensajeDAO.delete(dominio);
		} catch (ExcepcionCustomizada excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas eliminando el pa�s deseado...";
			String mensajeUsuario = "Se ha presentado un problema, tratando de llevar a cabo la eliminaci�n del pa�s deseado. Por favor intente de nuevo y si el problema persiste, contacte al administrador...";
			ComponenteEnumeracion componente = ComponenteEnumeracion.SERVICIO;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
		
	}

	@Override
	public List<MensajeDominio> consultar(MensajeDominio dominio) {
		if(dominio != null) {
			return mensajeDAO.consultar(dominio);
		}else {
			return mensajeDAO.findAll();
		}
	}

}
