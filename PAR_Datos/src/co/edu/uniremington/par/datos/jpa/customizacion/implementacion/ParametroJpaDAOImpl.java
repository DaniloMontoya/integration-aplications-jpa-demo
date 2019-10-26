package co.edu.uniremington.par.datos.jpa.customizacion.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import co.edu.uniremington.par.datos.jpa.customizacion.ParametroJpaDAOCustom;
import co.edu.uniremington.par.dominio.ParametroDominio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

public class ParametroJpaDAOImpl implements ParametroJpaDAOCustom {

	@PersistenceContext
	private EntityManager gestorEntidades;

	@Override
	public List<ParametroDominio> consultar(ParametroDominio parametro) {
		try {
			CriteriaBuilder constructorCriterio = gestorEntidades.getCriteriaBuilder();
			CriteriaQuery<ParametroDominio> criterioConsulta = constructorCriterio.createQuery(ParametroDominio.class);
			Root<ParametroDominio> raiz = criterioConsulta.from(ParametroDominio.class);
			List<Predicate> predicados = new ArrayList<>();

			if (parametro != null) {

				// Validamos si consultar por codigo
				if (parametro.getCodigo() > 0) {
					predicados.add(constructorCriterio.equal(raiz.get("codigo"), parametro.getCodigo()));
				}

				// Validamos si consultar por clave
				if (parametro.getClave() != null && parametro.getClave().trim().length() > 0) {
					predicados.add(constructorCriterio.like(raiz.get("clave"), parametro.getClave()));
				}

				// Validamos si consultar por valor
				if (parametro.getValor() != null && parametro.getValor().trim().length() != 0) {
					predicados.add(constructorCriterio.like(raiz.get("valor"), parametro.getValor().trim()));
				}

				// Validamos si consultar por aplicacion
				if (parametro.getAplicacion() != null) {
					if (parametro.getAplicacion().getCodigo() > 0) {
						predicados.add(constructorCriterio.equal(raiz.get("aplicacion").get("codigo"),
								parametro.getAplicacion().getCodigo()));
					}

					// Validamos si consultar por nombre
					if (parametro.getAplicacion().getNombre() != null
							&& parametro.getAplicacion().getNombre().trim().length() != 0) {
						predicados.add(constructorCriterio.like(raiz.get("aplicacion").get("nombre"),
								parametro.getAplicacion().getNombre().trim()));
					}
				}
				
				// Validamos si consultar por tipo de dato
				if (parametro.getTipoDato() != null) {
					if (parametro.getTipoDato().getCodigo() > 0) {
						predicados.add(constructorCriterio.equal(raiz.get("tipoDato").get("codigo"),
								parametro.getTipoDato().getCodigo()));
					}

					// Validamos si consultar por nombre
					if (parametro.getTipoDato().getNombre() != null
							&& parametro.getTipoDato().getNombre().trim().length() != 0) {
						predicados.add(constructorCriterio.like(raiz.get("aplicacion").get("nombre"),
								parametro.getTipoDato().getNombre().trim()));
					}
				}

			}

			criterioConsulta.select(raiz).where(constructorCriterio.and(predicados.toArray(new Predicate[0])));

			return gestorEntidades.createQuery(criterioConsulta).getResultList();
		} catch (Exception excepcion) {
			String mensajeTecnico = "Problemas consultando los parametros deseados";
			String mensajeUsuario = "Se ha presentando un problema tratando de llevar a cabo la consulta de los PARAMETROS, por favor intente de nuevo y si el problema persiste contacte al administrador";
			ComponenteEnumeracion componente = ComponenteEnumeracion.DATOS;

			throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, excepcion, componente);
		}
	}

}
