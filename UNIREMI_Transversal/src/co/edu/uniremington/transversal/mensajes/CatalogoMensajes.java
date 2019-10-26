package co.edu.uniremington.transversal.mensajes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;
import co.edu.uniremington.transversal.mensajes.dto.Mensaje;
import co.edu.uniremington.transversal.respuesta.RespuestaApi;
import co.edu.uniremington.transversal.respuesta.RespuestaOperacionEnumeracion;

@Component
public class CatalogoMensajes {

	@Value("${url.servicio.mensajes}")
	private String urlServicio;
	
	public Mensaje obtenerMensaje(String aplicacion, String codigoMensaje) {
		try {
			Map<String, String> parametros = new HashMap<String, String>();
			parametros.put("nombreAplicacion", aplicacion);
			parametros.put("codigoMensaje", codigoMensaje);

			RestTemplate plantillaEjecucion = new RestTemplate();
			ParameterizedTypeReference<RespuestaApi<Mensaje>> parameterizedType =  new ParameterizedTypeReference<RespuestaApi<Mensaje>>() {};
			RespuestaApi<Mensaje> respuesta = plantillaEjecucion
					.exchange(urlServicio, HttpMethod.GET, null, parameterizedType, parametros).getBody();
			
			if(respuesta.getRespuesta().equals(RespuestaOperacionEnumeracion.ERROR)
					|| respuesta.getResultado().isEmpty()) {
				String mensajeTecnico = respuesta.getMensajes().toString();
				String mensajeUsuario = "Se presenta un problema conectando con la aplicacion de mensajeria";
				throw ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, ComponenteEnumeracion.TRANSVERSAL);
			}

			return respuesta.getResultado().get(0);
			
		} catch (IllegalArgumentException excepcion) {
			String mensajeTecnico = "Url de llamada ala servicio mal formada o faltan parametros por mapear";
			String mensajeUsuario = "Se presenta un problema conectando con la aplicacion de mensajeria";
			throw ExcepcionCustomizada.crear(mensajeUsuario, mensajeTecnico, excepcion, ComponenteEnumeracion.TRANSVERSAL);
		}catch (ResourceAccessException ex) {
			String mensajeTecnico = "Servicio no disponible...";
			String mensajeUsuario = "Se presenta un problema, consultando los mensajes para la aplicacion";
			throw ExcepcionCustomizada.crear(mensajeUsuario, mensajeTecnico, ex, ComponenteEnumeracion.TRANSVERSAL);
		}catch (Exception ex) {
			String mensajeTecnico = "Problema no encontrado o esperado...";
			String mensajeUsuario = "Se presenta un problema, consultando los mensajes para la aplicacion";
			throw ExcepcionCustomizada.crear(mensajeUsuario, mensajeTecnico, ex, ComponenteEnumeracion.TRANSVERSAL);
		}
	}

}
