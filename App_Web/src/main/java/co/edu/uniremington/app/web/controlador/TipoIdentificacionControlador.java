package co.edu.uniremington.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.TipoIdentificacionDominio;
import co.edu.uniremington.app.servicio.implementacion.TipoIdentificacionServicio;

@Controller
public class TipoIdentificacionControlador {

	@Autowired
	private TipoIdentificacionServicio tipoIdentificacionServicio;
	
	@GetMapping("/crear-tipoIdentificacion")
	public void crearTipoIdentificacion() {
		TipoIdentificacionDominio tipoIdentificacion = new TipoIdentificacionDominio();
		tipoIdentificacion.setNombre("Cedula-Danilo");
		tipoIdentificacion.setEdadMinima(18);
		tipoIdentificacion.setEdadMaxima(80);
		tipoIdentificacionServicio.crear(tipoIdentificacion);
		mostrarTipoIdentificaciones();	
	}
	
	
	@GetMapping("/actualizar-tipoIdentificacion")
	public void actualizarTipoIdentificacion() {
		TipoIdentificacionDominio tipoIdentificacion = new TipoIdentificacionDominio();
		tipoIdentificacion.setCodigo(179);
		tipoIdentificacion.setNombre("Cedula-Danilo Montoya");
		tipoIdentificacion.setEdadMinima(16);
		tipoIdentificacion.setEdadMaxima(50);
		tipoIdentificacionServicio.actualizar(tipoIdentificacion);
		mostrarTipoIdentificaciones();
			
	}
	
	@GetMapping("/eliminar-tipoIdentificacion")
	public void eliminarTipoIdentificacion() {
		TipoIdentificacionDominio tipoIdentificacion = new TipoIdentificacionDominio();
		tipoIdentificacion.setCodigo(179);
		tipoIdentificacionServicio.eliminar(tipoIdentificacion);
		mostrarTipoIdentificaciones();	
	}
	
	@GetMapping(value = "/get-tipoIdentificaciones", produces = "application/json")
	private ResponseEntity<List<TipoIdentificacionDominio>> mostrarTipoIdentificaciones() {
		List<TipoIdentificacionDominio> lista = tipoIdentificacionServicio.consultar(null);
		
		for(TipoIdentificacionDominio tipoIdentificacionDominio : lista) {
			System.out.println(tipoIdentificacionDominio.toString());
		}
		return new ResponseEntity<List<TipoIdentificacionDominio>>(lista, HttpStatus.OK);
	}
}
