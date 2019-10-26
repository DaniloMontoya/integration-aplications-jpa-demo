package co.edu.uniremington.men.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.uniremington.men.dominio.MensajeDominio;
import co.edu.uniremington.men.servicio.IMensajeServicio;
import co.edu.uniremington.men.servicio.implementacion.MensajeServicio;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@Controller
public class Controlador {

	
	@Autowired
	private IMensajeServicio mensajeServicio;
	
	
	@GetMapping("/mensaje")
	public String mostrarMensajes(Model model) {
		List<MensajeDominio> lista = mensajeServicio.consultar(null);
		model.addAttribute("list", lista);
		return "mensaje/index";
	}
	
	@GetMapping("/mensaje/guardar/{codigo}")
	public String mostrarMensaje(@PathVariable("codigo") int codigo, Model model) {
		if(codigo > 0) {
			MensajeDominio mensaje = new MensajeDominio();
			mensaje.setCodigo(codigo);
			
			MensajeDominio lista = mensajeServicio.consultar(mensaje).get(0);
			model.addAttribute("mensaje",lista);
		}else{
			model.addAttribute("mensaje",new MensajeDominio());
		}
		return "mensaje/guardar";
	}
	
	@PostMapping("mensaje/guardar")
	public String guardarMensaje(MensajeDominio mensaje,Model model) {
		
		try {
			if(mensaje.getCodigo() > 0) {
				mensajeServicio.actualizar(mensaje);
			}else {
				mensajeServicio.crear(mensaje);
			}
		} catch (ExcepcionCustomizada excepcion) {
			System.out.println(excepcion.toString());
		} catch (Exception excepcion) {
			System.out.println("Excepcion no controlada");
			excepcion.printStackTrace();
		}
		
		return "redirect:/mensaje";
	}
	

	
	@GetMapping("/mensaje/eliminar/{codigo}")
	public String eliminarMensaje(@PathVariable("codigo") int codigo, Model model) {
		
		try {
			MensajeDominio mensaje = new MensajeDominio();
			mensaje.setCodigo(codigo);
			mensajeServicio.eliminar(mensaje);
		} catch (ExcepcionCustomizada excepcion) {
			System.out.println(excepcion.toString());
		} catch (Exception excepcion) {
			System.out.println("Excepcion no controlada");
			excepcion.printStackTrace();
		}
		
		return "redirect:/mensaje";
	}
	
}
