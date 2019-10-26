package co.edu.uniremington.par.controlador.respuesta;

import java.util.ArrayList;
import java.util.List;

public class RespuestaApi<T> {
	
	private RespuestaOperacionEnumeracion respuesta;
	private List<String> mensajes;
	private List<T> resultado;
	
	public void agregarMensajes(String mensaje) {
		getMensajes().add(mensaje);
	}

	public RespuestaOperacionEnumeracion getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaOperacionEnumeracion respuesta) {
		this.respuesta = respuesta;
	}

	public List<String> getMensajes() {
		if(mensajes == null) {
			mensajes = new ArrayList<String>();
		}
		return mensajes;
	}

	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}

	public List<T> getResultado() {
		return resultado;
	}

	public void setResultado(List<T> resultado) {
		this.resultado = resultado;
	}	
	

}
