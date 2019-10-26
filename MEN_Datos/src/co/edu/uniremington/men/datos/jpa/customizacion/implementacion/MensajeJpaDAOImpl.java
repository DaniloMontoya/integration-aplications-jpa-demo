package co.edu.uniremington.men.datos.jpa.customizacion.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import co.edu.uniremington.men.datos.jpa.customizacion.MensajeJpaDAOCustom;
import co.edu.uniremington.men.dominio.MensajeDominio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;


public class MensajeJpaDAOImpl implements MensajeJpaDAOCustom{

	@PersistenceContext
	private EntityManager gestorEntidades;

	@Override
	public List<MensajeDominio> consultar(MensajeDominio mensaje) {
		try {
			CriteriaBuilder constructorCriterio = gestorEntidades.getCriteriaBuilder();
			CriteriaQuery<MensajeDominio> criterioConsulta = constructorCriterio.createQuery(MensajeDominio.class);
			Root<MensajeDominio> raiz = criterioConsulta.from(MensajeDominio.class);
			List<Predicate> predicados = new ArrayList<>();

			if (mensaje != null) {
				
				//Validamos si consultar por codigo
				if (mensaje.getCodigo() > 0) {
					predicados.add(constructorCriterio.equal(raiz.get("codigo"), mensaje.getCodigo()));
				}
				
				//Validamos si consultar por nombre
				if (mensaje.getMensaje() != null && mensaje.getMensaje().trim().length() > 0) {
					predicados.add(constructorCriterio.like(raiz.get("nombre"), mensaje.getMensaje()));
				}
				
				// Validamos si consultar por codigo texto
				if (mensaje.getNvcodigo() != null && mensaje.getNvcodigo().trim().length() != 0) {
					predicados.add(constructorCriterio.like(raiz.get("nvcodigo"), mensaje.getNvcodigo().trim()));
				}

				// Validamos si consultar por codigo texto
				if (mensaje.getAplicacion() != null) {
					if (mensaje.getAplicacion().getCodigo() > 0) {
						predicados.add(constructorCriterio.equal(raiz.get("aplicacion").get("codigo"),
								mensaje.getAplicacion().getCodigo()));
					}

					// Validamos si consultar por nombre
					if (mensaje.getAplicacion().getNombre() != null
							&& mensaje.getAplicacion().getNombre().trim().length() != 0) {
						predicados.add(constructorCriterio.like(raiz.get("aplicacion").get("nombre"),
								mensaje.getAplicacion().getNombre().trim()));
					}
				}
				
			}

			criterioConsulta.select(raiz).where(constructorCriterio.and(predicados.toArray(new Predicate[0])));

			return gestorEntidades.createQuery(criterioConsulta).getResultList();
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas consultando los mensajes deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la consulta de los mensajes, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.DATOS;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}
}
