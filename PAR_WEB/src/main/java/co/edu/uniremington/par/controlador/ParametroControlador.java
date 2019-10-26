package co.edu.uniremington.par.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.uniremington.par.dominio.ParametroDominio;
import co.edu.uniremington.par.servicio.IParametroServicio;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;

@Controller
public class ParametroControlador {
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@GetMapping("parametro")
	public String mostrarParametros(Model model) {
		List<ParametroDominio> lista = parametroServicio.consultar(null);
		model.addAttribute("list", lista);
		return "parametro/index";
	}
	
	@GetMapping("/parametro/guardar/{codigo}")
	public String mostrarMensaje(@PathVariable("codigo") int codigo, Model model) {
		if(codigo > 0) {
			ParametroDominio parametro = new ParametroDominio();
			parametro.setCodigo(codigo);
			
			ParametroDominio lista = parametroServicio.consultar(parametro).get(0);
			model.addAttribute("parametro",lista);
		}else{
			model.addAttribute("parametro",new ParametroDominio());
		}
		return "parametro/guardar";
	}
	
	@PostMapping("parametro/guardar")
	public String guardarMensaje(ParametroDominio parametro,Model model) {
		
		try {
			if(parametro.getCodigo() > 0) {
				parametroServicio.actualizar(parametro);
			}else {
				parametroServicio.crear(parametro);
			}
		} catch (ExcepcionCustomizada excepcion) {
			System.out.println(excepcion.toString());
		} catch (Exception excepcion) {
			System.out.println("Excepcion no controlada");
			excepcion.printStackTrace();
		}
		
		return "redirect:/parametro";
	}
	
	@GetMapping("/parametro/eliminar/{codigo}")
	public String eliminarMensaje(@PathVariable("codigo") int codigo, Model model) {
		
		try {
			ParametroDominio parametro = new ParametroDominio();
			parametro.setCodigo(codigo);
			parametroServicio.eliminar(parametro);
		} catch (ExcepcionCustomizada excepcion) {
			System.out.println(excepcion.toString());
		} catch (Exception excepcion) {
			System.out.println("Excepcion no controlada");
			excepcion.printStackTrace();
		}
		
		return "redirect:/parametro";
	}

}
