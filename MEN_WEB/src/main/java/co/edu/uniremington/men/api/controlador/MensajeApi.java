package co.edu.uniremington.men.api.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniremington.men.api.controlador.respuesta.RespuestaApi;
import co.edu.uniremington.men.api.controlador.respuesta.RespuestaOperacionEnumeracion;
import co.edu.uniremington.men.dominio.AplicacionDominio;
import co.edu.uniremington.men.dominio.MensajeDominio;
import co.edu.uniremington.men.servicio.implementacion.MensajeServicio;
import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@RestController
@RequestMapping("/mensajes")
public class MensajeApi {
	
	@Autowired
	private MensajeServicio mensajeServicio;
	
	@GetMapping("/{nombreAplicacion}")
	public RespuestaApi<MensajeDominio> consultarMensajesAplicacion(@PathVariable String nombreAplicacion){
		
		RespuestaApi<MensajeDominio> respuesta = new RespuestaApi<MensajeDominio>();
		try {
			
			if(nombreAplicacion == null || nombreAplicacion.trim().length() == 0) {
				throw ExcepcionCustomizada.crear("el nombre de la aplicacion no puede estar vacio",ComponenteEnumeracion.API);
			}
			
			AplicacionDominio aplicacion = new AplicacionDominio();
			aplicacion.setNombre(nombreAplicacion);
			
			MensajeDominio mensajeConsulta = new MensajeDominio();
			mensajeConsulta.setAplicacion(aplicacion);
			
			List<MensajeDominio> listaMensajes = mensajeServicio.consultar(mensajeConsulta);
			
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.EXITOSA);
			respuesta.setResultado(listaMensajes);
			
			if(listaMensajes.isEmpty()) {
				respuesta.agregarMensajes("No existen mensajes para mostrar de la aplicacion = "+nombreAplicacion);
			}
			
		}catch (ExcepcionCustomizada excepcion) {
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.ERROR);
			respuesta.agregarMensajes(excepcion.toString());
		}
		
		return respuesta;
	}
	
	@GetMapping("/{nombreAplicacion}/{codigoMensaje}")
	public RespuestaApi<MensajeDominio> consultarMensajeAplicacion(@PathVariable String nombreAplicacion,@PathVariable String codigoMensaje){
		
		RespuestaApi<MensajeDominio> respuesta = new RespuestaApi<MensajeDominio>();
		try {
			
			if(nombreAplicacion == null || nombreAplicacion.trim().length() == 0) {
				throw ExcepcionCustomizada.crear("el nombre de la aplicacion no puede estar vacio",ComponenteEnumeracion.API);
			}
			
			AplicacionDominio aplicacion = new AplicacionDominio();
			aplicacion.setNombre(nombreAplicacion);
			
			MensajeDominio mensajeConsulta = new MensajeDominio();
			mensajeConsulta.setAplicacion(aplicacion);
			mensajeConsulta.setNvcodigo(codigoMensaje);
			
			List<MensajeDominio> listaMensajes = mensajeServicio.consultar(mensajeConsulta);
			
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.EXITOSA);
			respuesta.setResultado(listaMensajes);
			
			if(listaMensajes.isEmpty()) {
				respuesta.agregarMensajes("No existen un mensaje con el codigo"+codigoMensaje+" para la aplicacion = "+nombreAplicacion);
			}
			
		}catch (ExcepcionCustomizada excepcion) {
			respuesta.setRespuesta(RespuestaOperacionEnumeracion.ERROR);
			respuesta.agregarMensajes(excepcion.toString());
		}
		
		return respuesta;
		
		
	}
	
	
}
