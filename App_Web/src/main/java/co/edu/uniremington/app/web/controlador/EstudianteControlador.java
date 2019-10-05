package co.edu.uniremington.app.web.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.uniremington.app.dominio.CiudadDominio;
import co.edu.uniremington.app.dominio.EstadoCivilDominio;
import co.edu.uniremington.app.dominio.EstudianteDominio;
import co.edu.uniremington.app.dominio.TipoIdentificacionDominio;
import co.edu.uniremington.app.servicio.implementacion.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio estudianteServicio;
	
	@GetMapping("/crear-estudiante")
	public void crearEstudiante() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setCodigo(12);
		
		TipoIdentificacionDominio tipoIdentificacion = new TipoIdentificacionDominio();
		tipoIdentificacion.setCodigo(3);
		
		EstadoCivilDominio estadoCivil = new EstadoCivilDominio();
		estadoCivil.setCodigo(7);
		
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setNombre("La roca");
		estudiante.setNumeroIdentificacion("12345");
		estudiante.setTipoIdentificacion(tipoIdentificacion);
		estudiante.setCiudadResidencia(ciudad);
		estudiante.setCorreoElectronico("laroca@gmail.com");
		estudiante.setDireccion("Casa de la roca");
		estudiante.setFechaNacimiento(new Date());
		estudiante.setEstadoCivil(estadoCivil);
		
		estudianteServicio.crear(estudiante);
		mostrarEstudiantes();	
	}
	
	
	@GetMapping("/actualizar-estudiante")
	public void actualizarEstudiante() {
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setCodigo(15);
		estudiante.setNombre("La roca 2");
		estudianteServicio.actualizar(estudiante);
		mostrarEstudiantes();
			
	}
	
	@GetMapping("/eliminar-estudiante")
	public void eliminarEstudiante() {
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setCodigo(15);
		estudianteServicio.eliminar(estudiante);
		mostrarEstudiantes();	
	}
	
	@GetMapping(value = "/get-estudiantes", produces = "application/json")
	public ResponseEntity<List<EstudianteDominio>> mostrarEstudiantes() {
		List<EstudianteDominio> lista = estudianteServicio.consultar(null);
		
		for(EstudianteDominio estudianteDominio : lista) {
			System.out.println(estudianteDominio.toString());
		}
		return new ResponseEntity<List<EstudianteDominio>>(lista, HttpStatus.OK);
	}
}
