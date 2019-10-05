package co.edu.uniremington.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.CiudadDominio;
import co.edu.uniremington.app.servicio.implementacion.CiudadServicio;

@Controller
public class CiudadControlador {

	@Autowired
	private CiudadServicio ciudadServicio;
	
	@GetMapping("/crear-ciudad")
	public void crearciudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setNombre("Marinilla-Danilo");
		ciudadServicio.crear(ciudad);
		mostrarCiudades();	
	}
	
	
	@GetMapping("/actualizar-ciudad")
	public void actualizarciudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setCodigo(179);
		ciudad.setNombre("Marinilla-Danilo Montoya");
		ciudadServicio.actualizar(ciudad);
		mostrarCiudades();
			
	}
	
	@GetMapping("/eliminar-ciudad")
	public void eliminarciudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setCodigo(179);
		ciudadServicio.eliminar(ciudad);
		mostrarCiudades();	
	}
	
	@GetMapping(value = "/get-ciudades", produces = "application/json")
	private ResponseEntity<List<CiudadDominio>> mostrarCiudades() {
		List<CiudadDominio> lista = ciudadServicio.consultar(null);
		
		for(CiudadDominio ciudadDominio : lista) {
			System.out.println(ciudadDominio.toString());
		}
		return new ResponseEntity<List<CiudadDominio>>(lista, HttpStatus.OK);
	}
}
