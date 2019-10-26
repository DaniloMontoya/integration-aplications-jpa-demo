package co.edu.uniremington.par.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniremington.par.controlador.respuesta.RespuestaApi;
import co.edu.uniremington.par.controlador.respuesta.RespuestaOperacionEnumeracion;
import co.edu.uniremington.par.dominio.AplicacionDominio;
import co.edu.uniremington.par.dominio.ParametroDominio;
import co.edu.uniremington.par.servicio.IParametroServicio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@RestController
@RequestMapping("/parametros")
public class ParametroApi {
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@GetMapping("/{nombreAplicacion}")
	public  RespuestaApi<ParametroDominio> consultarParametrosAplicacion(@PathVariable String nombreAplicacion){
		RespuestaApi<ParametroDominio> respuesta = new RespuestaApi<ParametroDominio>();
		try {
			if(nombreAplicacion == null || nombreAplicacion.trim().length() == 0) {
				throw ExcepcionCustomizada.crear("el nombre de la aplicacion no puede estar vacio",ComponenteEnumeracion.API);
			}
			
			AplicacionDominio aplicacion = new AplicacionDominio();
			aplicacion.setNombre(nombreAplicacion);
			
			ParametroDominio parametroConsulta = new ParametroDominio();
			parametroConsulta.setAplicacion(aplicacion);
			
			List<ParametroDominio> listaParametros = parametroServicio.consultar(parametroConsulta);
			
			
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.EXITOSA);
			respuesta.setResultado(listaParametros);
			
			if(listaParametros.isEmpty()) {
				respuesta.agregarMensajes("No existen parametros para mostrar de la aplicacion = "+nombreAplicacion);
			}
			
		}catch (ExcepcionCustomizada ex) {
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.ERROR);
			respuesta.agregarMensajes(ex.toString());
		}
		
		return respuesta;
	}
	
	@GetMapping("/{nombreAplicacion}/{codigoParametro}")
	public RespuestaApi<ParametroDominio> consultarMensajeAplicacion(@PathVariable String nombreAplicacion,@PathVariable String codigoParametro){
		
		RespuestaApi<ParametroDominio> respuesta = new RespuestaApi<ParametroDominio>();
		try {
			
			if(nombreAplicacion == null || nombreAplicacion.trim().length() == 0) {
				throw ExcepcionCustomizada.crear("el nombre de la aplicacion no puede estar vacio",ComponenteEnumeracion.API);
			}
			
			AplicacionDominio aplicacion = new AplicacionDominio();
			aplicacion.setNombre(nombreAplicacion);
			
			ParametroDominio parametroConsulta = new ParametroDominio();
			parametroConsulta.setAplicacion(aplicacion);
			parametroConsulta.setClave(codigoParametro);
			
			List<ParametroDominio> listaParametros = parametroServicio.consultar(parametroConsulta);
			
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.EXITOSA);
			respuesta.setResultado(listaParametros);
			
			if(listaParametros.isEmpty()) {
				respuesta.agregarMensajes("No existen un parametro con el codigo"+codigoParametro+" para la aplicacion = "+nombreAplicacion);
			}
			
		}catch (ExcepcionCustomizada excepcion) {
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.ERROR);
			respuesta.agregarMensajes(excepcion.toString());
		}
		
		return respuesta;
		
	}

}
