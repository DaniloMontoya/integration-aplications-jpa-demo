package co.edu.uniremington.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.DepartamentoDominio;
import co.edu.uniremington.app.servicio.implementacion.DepartamentoServicio;

@Controller("departamentoControlador")
public class DepartamentoControlador {
	
	@Autowired
	private DepartamentoServicio departamentoServicio;
	
	@GetMapping("/crear-departamento")
	public void crearDepartamento() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setNombre("Colombia-Danilo");
		departamentoServicio.crear(departamento);
		mostrarPaises();	
	}
	
	
	@GetMapping("/actualizar-departamento")
	public void actualizarPais() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setCodigo(179);
		departamento.setNombre("Antioquia-Danilo Montoya");
		departamentoServicio.actualizar(departamento);
		mostrarPaises();
			
	}
	
	@GetMapping("/eliminar-departamento")
	public void eliminarPais() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setCodigo(179);
		departamentoServicio.eliminar(departamento);
		mostrarPaises();	
	}
	
	@GetMapping(value = "/get-departamentos", produces = "application/json")
	private ResponseEntity<List<DepartamentoDominio>> mostrarPaises() {
		List<DepartamentoDominio> lista = departamentoServicio.consultar(null);
		
		for(DepartamentoDominio departamentoDominio : lista) {
			System.out.println(departamentoDominio.toString());
		}
		
		return new ResponseEntity<List<DepartamentoDominio>>(lista, HttpStatus.OK);
	}
}
