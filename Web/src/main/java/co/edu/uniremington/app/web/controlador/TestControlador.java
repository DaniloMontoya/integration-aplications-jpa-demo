package co.edu.uniremington.app.web.controlador;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.uniremington.app.dominio.CiudadDominio;
import co.edu.uniremington.app.dominio.DepartamentoDominio;
import co.edu.uniremington.app.dominio.EstadoCivilDominio;
import co.edu.uniremington.app.dominio.EstudianteDominio;
import co.edu.uniremington.app.dominio.PaisDominio;
import co.edu.uniremington.app.dominio.TipoIdentificacionDominio;
import co.edu.uniremington.app.servicio.implementacion.CiudadServicio;
import co.edu.uniremington.app.servicio.implementacion.DepartamentoServicio;
import co.edu.uniremington.app.servicio.implementacion.EstadoCivilServicio;
import co.edu.uniremington.app.servicio.implementacion.PaisServicio;
import co.edu.uniremington.app.servicio.implementacion.TipoIdentificacionServicio;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;
import co.edu.uniremington.transversal.loggin.Logger;
import co.edu.uniremington.transversal.mensajes.CatalogoMensajes;
import co.edu.uniremington.app.servicio.implementacion.EstudianteServicio;

@Controller
public class TestControlador {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private CatalogoMensajes catalogoMenajes;
	
	@Autowired
	private PaisServicio paisServicio;

	@GetMapping("/pais")
	public String mostrarPaises(Model model) {
		List<PaisDominio> lista = paisServicio.consultar(null);
		model.addAttribute("list", lista);
		return "pais/index";
	}
	
	@GetMapping("/pais/guardar/{codigo}")
	public String mostrarPais(@PathVariable("codigo") int codigo, Model model) {
		if(codigo > 0) {
			PaisDominio pais = new PaisDominio();
			pais.setCodigo(codigo);
			
			PaisDominio lista = paisServicio.consultar(pais).get(0);
			model.addAttribute("pais",lista);
		}else{
			model.addAttribute("pais",new PaisDominio());
		}
		return "pais/guardar";
	}
	
	@PostMapping("pais/guardar")
	public String guardarPais(PaisDominio pais,Model model) {
		
		try {
			if(pais.getCodigo() > 0) {
				paisServicio.actualizar(pais);
				String mensaje = catalogoMenajes.obtenerMensaje("APP", "APP_USU_EXI_0002").getMensaje();
				logger.trazarEvento(mensaje);
			}else {
				paisServicio.crear(pais);
				String mensaje = catalogoMenajes.obtenerMensaje("APP", "APP_USU_EXI_0001").getMensaje();
				logger.trazarEvento(mensaje);
			}
		} catch (ExcepcionCustomizada excepcion) {
			logger.trazarEvento(excepcion.toString());
			excepcion.printStackTrace();
		
		} catch (Exception excepcion) {
			logger.trazarEvento(excepcion.toString());
			excepcion.printStackTrace();
		}
		
		return "redirect:/pais";
	}
	

	
	@GetMapping("/pais/eliminar/{codigo}")
	public String eliminarPais(@PathVariable("codigo") int codigo, Model model) {
		
		try {
			PaisDominio pais = new PaisDominio();
			pais.setCodigo(codigo);
			paisServicio.eliminar(pais);
			String mensaje = catalogoMenajes.obtenerMensaje("APP", "APP_USU_EXI_0003").getMensaje();
			logger.trazarEvento(mensaje);
		} catch (ExcepcionCustomizada excepcion) {
			logger.trazarEvento(excepcion.getMensajeTecnico());
		} catch (Exception excepcion) {
			logger.trazarEvento(excepcion.toString());
		}
		
		return "redirect:/pais";
	}
	
	
	
	@Autowired
	private CiudadServicio ciudadServicio;
	
	@GetMapping("/crear-ciudad")
	public void crearCiudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setNombre("Marinilla");
		ciudad.setDepartamento(new DepartamentoDominio()); //Revisar Tema de departamento
		ciudadServicio.crear(ciudad);
		mostrarCiudades();
	}
	
	@GetMapping("/actualizar-ciudad")
	public void actualizarCiudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setCodigo(180);
		ciudad.setNombre("Rionegro Nuevo- Sergio");
		ciudad.setDepartamento(new DepartamentoDominio()); //Revisar Tema de departamento
		ciudadServicio.actualizar(ciudad);
		mostrarCiudades();
	}
	
	@GetMapping("/eliminar-ciudad")
	public void eliminarCiudad() {
		CiudadDominio ciudad = new CiudadDominio();
		ciudad.setCodigo(180);
		ciudadServicio.eliminar(ciudad);
		mostrarCiudades();
	}
	
	private void mostrarCiudades() {
		List<CiudadDominio> lista = ciudadServicio.consultar(null);
		for(CiudadDominio ciudadDominio : lista) {
			System.out.println(ciudadDominio.toString());
		}
	}
	
	@Autowired
	private DepartamentoServicio departamentoServicio;
	
	@GetMapping("/crear-departamento")
	public void crearDepartamento() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setNombre("Antioquia - Sergio");
		departamento.setPais(new PaisDominio()); //Revisar Tema de pais
		departamentoServicio.crear(departamento);
		mostrarDepartamentos();
	}
	
	@GetMapping("/actualizar-departamento")
	public void actualizarDepartamento() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setCodigo(180);
		departamento.setNombre("Antioquia Nuevo- Sergio");
		departamento.setPais(new PaisDominio()); //Revisar Tema de pais
		departamentoServicio.actualizar(departamento);
		mostrarDepartamentos();
	}
	
	@GetMapping("/eliminar-departamento")
	public void eliminarDepartamento() {
		DepartamentoDominio departamento = new DepartamentoDominio();
		departamento.setCodigo(180);
		departamentoServicio.eliminar(departamento);
		mostrarDepartamentos();
	}
	
	private void mostrarDepartamentos() {
		List<DepartamentoDominio> lista = departamentoServicio.consultar(null);
		for(DepartamentoDominio departamentoDominio : lista) {
			System.out.println(departamentoDominio.toString());
		}
	}
	
	
	@Autowired
	private EstadoCivilServicio estadoServicio;

	@GetMapping("/crear-estado")
	public void crearEstado() {
		EstadoCivilDominio estado = new EstadoCivilDominio();
		estado.setNombre("Soltero - Sergio");
		estadoServicio.crear(estado);
		mostrarEstado();
	}
	
	@GetMapping("/actualizar-estado")
	public void actualizarEstado() {
		EstadoCivilDominio estado = new EstadoCivilDominio();
		estado.setNombre("Soltero Nuevo- Sergio");
		estado.setCodigo(180);
		estadoServicio.actualizar(estado);
		mostrarEstado();
	}
	
	@GetMapping("/eliminar-estado")
	public void eliminarEstado() {
		EstadoCivilDominio estado = new EstadoCivilDominio();
		estado.setCodigo(180);
		estadoServicio.eliminar(estado);
		mostrarEstado();
	}
	
	private void mostrarEstado() {
		List<EstadoCivilDominio> lista = estadoServicio.consultar(null);
		for(EstadoCivilDominio estado : lista) {
			System.out.println(estado.toString());
		}
	}
	
	@Autowired
	private EstudianteServicio estudianteServicio;

	@GetMapping("/crear-estudiante")
	public void crearEstudiante() {
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setNombre("Sergio - Sergio");
		estudiante.setCiudadResidencia(new CiudadDominio());
		estudiante.setCorreoElectronico("sergio@gmail.com");
		estudiante.setDireccion("Crra 34 # 34-43");
		estudiante.setEstadoCivil(new EstadoCivilDominio());
		estudiante.setFechaNacimiento(new GregorianCalendar(1995,2,23).getTime());
		estudiante.setNumeroIdentificacion("103352423");
		estudiante.setTipoIdentificacion(new TipoIdentificacionDominio());
		estudianteServicio.crear(estudiante);
		mostrarEstudiante();
	}
	
	@GetMapping("/actualizar-estudiante")
	public void actualizarEstudiante() {
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setNombre("Soltero Nuevo- Sergio");
		estudiante.setCiudadResidencia(new CiudadDominio());
		estudiante.setCorreoElectronico("sergio@gmail.com");
		estudiante.setDireccion("Crra 34 # 34-43");
		estudiante.setEstadoCivil(new EstadoCivilDominio());
		estudiante.setFechaNacimiento(new GregorianCalendar(1995,2,23).getTime());
		estudiante.setNumeroIdentificacion("103352423");
		estudiante.setTipoIdentificacion(new TipoIdentificacionDominio());
		estudiante.setCodigo(180);
		estudianteServicio.actualizar(estudiante);
		mostrarEstudiante();
	}
	
	@GetMapping("/eliminar-estudiante")
	public void eliminarEstudiante() {
		EstudianteDominio estudiante = new EstudianteDominio();
		estudiante.setCodigo(180);
		estudianteServicio.eliminar(estudiante);
		mostrarEstudiante();
	}
	
	private void mostrarEstudiante() {
		List<EstudianteDominio> lista = estudianteServicio.consultar(null);
		for(EstudianteDominio estudiante : lista) {
			System.out.println(estudiante.toString());
		}
	}
	
	@Autowired
	private TipoIdentificacionServicio tipoServicio;

	@GetMapping("/crear-tipo")
	public void crearTipo() {
		TipoIdentificacionDominio tipo = new TipoIdentificacionDominio();
		tipo.setNombre("Cedula - Sergio");
		tipo.setEdadMinima(18);
		tipo.setEdadMaxima(100);
		tipoServicio.crear(tipo);
		mostrarTipo();
	}
	
	@GetMapping("/actualizar-tipo")
	public void actualizarTipo() {
		TipoIdentificacionDominio tipo = new TipoIdentificacionDominio();
		tipo.setNombre("Cedula Nuevo- Sergio");
		tipo.setCodigo(180);
		tipo.setEdadMinima(18);
		tipo.setEdadMaxima(100);
		tipoServicio.actualizar(tipo);
		mostrarTipo();
	}
	
	@GetMapping("/eliminar-tipo")
	public void eliminarTipo() {
		TipoIdentificacionDominio tipo = new TipoIdentificacionDominio();
		tipo.setCodigo(180);
		tipoServicio.eliminar(tipo);
		mostrarTipo();
	}
	
	private void mostrarTipo() {
		List<TipoIdentificacionDominio> lista = tipoServicio.consultar(null);
		for(TipoIdentificacionDominio tipoDominio : lista) {
			System.out.println(tipoDominio.toString());
		}
	}
	
	
}
