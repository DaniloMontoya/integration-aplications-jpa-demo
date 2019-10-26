package co.edu.uniremington.app.datos.jpa.customizacion.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import co.edu.uniremington.app.datos.jpa.customizacion.PaisJpaDAOCustom;
import co.edu.uniremington.app.dominio.PaisDominio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

public class PaisJpaDAOImpl implements PaisJpaDAOCustom {

	@PersistenceContext
	private EntityManager gestorEntidades;

	@Override
	public List<PaisDominio> consultar(PaisDominio pais) {
		try {
			CriteriaBuilder constructorCriterio = gestorEntidades.getCriteriaBuilder();
			CriteriaQuery<PaisDominio> criterioConsulta = constructorCriterio.createQuery(PaisDominio.class);
			Root<PaisDominio> raiz = criterioConsulta.from(PaisDominio.class);
			List<Predicate> predicados = new ArrayList<>();

			if (pais != null) {
				if (pais.getCodigo() > 0) {
					predicados.add(constructorCriterio.equal(raiz.get("codigo"), pais.getCodigo()));
				}
				if (pais.getNombre() != null && pais.getNombre().trim().length() > 0) {
					predicados.add(constructorCriterio.like(raiz.get("nombre"), pais.getNombre()));
				}
			}

			criterioConsulta.select(raiz).where(constructorCriterio.and(predicados.toArray(new Predicate[0])));

			return gestorEntidades.createQuery(criterioConsulta).getResultList();
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas consultando los paises deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la consulta de los paises, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.DATOS;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

}
