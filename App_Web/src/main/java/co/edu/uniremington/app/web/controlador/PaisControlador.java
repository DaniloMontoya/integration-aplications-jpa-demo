package co.edu.uniremington.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.PaisDominio;
import co.edu.uniremington.app.servicio.implementacion.PaisServicio;

@Controller
public class PaisControlador {

	@Autowired
	private PaisServicio paisServicio;
	
	@GetMapping("/crear-pais")
	public void crearPais() {
		PaisDominio pais = new PaisDominio();
		pais.setNombre("Colombia-Danilo");
		paisServicio.crear(pais);
		mostrarPaises();	
	}
	
	
	@GetMapping("/actualizar-pais")
	public void actualizarPais() {
		PaisDominio pais = new PaisDominio();
		pais.setCodigo(179);
		pais.setNombre("Colombia-Danilo Montoya");
		paisServicio.actualizar(pais);
		mostrarPaises();
			
	}
	
	@GetMapping("/eliminar-pais")
	public void eliminarPais() {
		PaisDominio pais = new PaisDominio();
		pais.setCodigo(179);
		paisServicio.eliminar(pais);
		mostrarPaises();	
	}
	
	@GetMapping(value = "/get-paises", produces = "application/json")
	private ResponseEntity<List<PaisDominio>> mostrarPaises() {
		List<PaisDominio> lista = paisServicio.consultar(null);
		
		for(PaisDominio paisDominio : lista) {
			System.out.println(paisDominio.toString());
		}
		return new ResponseEntity<List<PaisDominio>>(lista, HttpStatus.OK);
	}
}
