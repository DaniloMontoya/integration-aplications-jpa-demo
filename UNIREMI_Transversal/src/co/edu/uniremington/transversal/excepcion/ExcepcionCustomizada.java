package co.edu.uniremington.transversal.excepcion;

import org.apache.commons.lang3.exception.ExceptionUtils;

import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;

public class ExcepcionCustomizada extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Throwable excepcionRaiz;
	private ComponenteEnumeracion componente;
	
	private ExcepcionCustomizada(String mensajeTecnico, String mensajeUsuario, Throwable excepcionRaiz,ComponenteEnumeracion componente) {
		super();
		setMensajeTecnico(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setExcepcionRaiz(excepcionRaiz);
		setComponente(componente);
		
	}
	
	public static ExcepcionCustomizada crear(String mensajeTecnico, String mensajeUsuario, Throwable excepcionRaiz,ComponenteEnumeracion componente) {
		return new ExcepcionCustomizada(mensajeTecnico, mensajeUsuario, excepcionRaiz, componente);
	}
	
	public static ExcepcionCustomizada crear(String mensajeTecnico, String mensajeUsuario,ComponenteEnumeracion componente) {
		return new ExcepcionCustomizada(mensajeTecnico, mensajeUsuario, null, componente);
	}
	
	public static ExcepcionCustomizada crear(String mensajeUsuario,ComponenteEnumeracion componente) {
		return new ExcepcionCustomizada(mensajeUsuario, mensajeUsuario, null, componente);
	}
	
	public static ExcepcionCustomizada crear(String mensajeTecnico, String mensajeUsuario) {
		return new ExcepcionCustomizada(mensajeTecnico, mensajeUsuario, null, null);
	}
	
	public static ExcepcionCustomizada crear(String mensajeUsuario) {
		return new ExcepcionCustomizada(mensajeUsuario, mensajeUsuario, null, null);
	}
	
	private void setMensajeTecnico(String mensajeTecnico) {
		if(mensajeTecnico == null || mensajeTecnico.trim().length() == 0) {
			throw crear("Al momento de crear una excepcion customizada es obligatorio el mensaje tecnico",ComponenteEnumeracion.TRANSVERSAL);
		}
		this.mensajeTecnico = mensajeTecnico;
	}
	
	private void setMensajeUsuario(String mensajeUsuario) {
		if(mensajeUsuario == null || mensajeUsuario.trim().length() == 0) {
			throw crear("Al momento de crear una excepcion customizada es obligatorio el mensaje de usuario",ComponenteEnumeracion.TRANSVERSAL);
		}
		this.mensajeUsuario = mensajeUsuario;
	}
	
	private void setExcepcionRaiz(Throwable excepcionRaiz) {
		if(excepcionRaiz == null) {
			this.excepcionRaiz = new Exception();
		}else {
			this.excepcionRaiz = excepcionRaiz;
		}
	}
	
	private void setComponente(ComponenteEnumeracion componente) {
		if(componente == null) {
			this.componente = ComponenteEnumeracion.GENERAL;
		}else {
			this.componente = componente;
		}
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	public Throwable getExcepcionRaiz() {
		return excepcionRaiz;
	}

	public ComponenteEnumeracion getComponente() {
		return componente;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append("[componente=").append(getComponente()).append("]");
		retorno.append("[mensaje tecnico=").append(getMensajeTecnico()).append("]");
		retorno.append("[mensaje usuario=").append(getMensajeUsuario()).append("]");
		retorno.append("[excepcion raiz=").append(ExceptionUtils.getStackTrace(getExcepcionRaiz())).append("]");
		
		return retorno.toString();
	}
	
}
