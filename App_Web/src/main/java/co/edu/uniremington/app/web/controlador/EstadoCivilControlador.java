package co.edu.uniremington.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.EstadoCivilDominio;
import co.edu.uniremington.app.servicio.implementacion.EstadoCivilServicio;

@Controller
public class EstadoCivilControlador {

	@Autowired
	private EstadoCivilServicio estadoCivilServicio;
	
	@GetMapping("/crear-estadoCivil")
	public void crearestadoCivil() {
		EstadoCivilDominio estadoCivil = new EstadoCivilDominio();
		estadoCivil.setNombre("Est.Civ-Danilo");
		estadoCivilServicio.crear(estadoCivil);
		mostrarestadoCiviles();	
	}
	
	
	@GetMapping("/actualizar-estadoCivil")
	public void actualizarestadoCivil() {
		EstadoCivilDominio estadoCivil = new EstadoCivilDominio();
		estadoCivil.setCodigo(179);
		estadoCivil.setNombre("Est.Civ-Danilo Montoya");
		estadoCivilServicio.actualizar(estadoCivil);
		mostrarestadoCiviles();
			
	}
	
	@GetMapping("/eliminar-estadoCivil")
	public void eliminarestadoCivil() {
		EstadoCivilDominio estadoCivil = new EstadoCivilDominio();
		estadoCivil.setCodigo(179);
		estadoCivilServicio.eliminar(estadoCivil);
		mostrarestadoCiviles();	
	}
	
	@GetMapping(value = "/get-estadosCiviles", produces = "application/json")
	private ResponseEntity<List<EstadoCivilDominio>> mostrarestadoCiviles() {
		List<EstadoCivilDominio> lista = estadoCivilServicio.consultar(null);
		
		for(EstadoCivilDominio estadoCivilDominio : lista) {
			System.out.println(estadoCivilDominio.toString());
		}
		return new ResponseEntity<List<EstadoCivilDominio>>(lista, HttpStatus.OK);
	}
}
