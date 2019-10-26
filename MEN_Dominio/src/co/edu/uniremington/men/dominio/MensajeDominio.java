package co.edu.uniremington.men.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEN_MENSAJE_TBL",schema = "dbo")
public class MensajeDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_APLICACION")
	private AplicacionDominio aplicacion;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_CATEGORIA")
	private CategoriaDominio categoria;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_TIPO")
	private TipoDominio tipo;
	
	@Column(name = "NV_MENSAJE")
	private String mensaje;
	
	@Column(name = "NV_CODIGO")
	private String nvcodigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public AplicacionDominio getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(AplicacionDominio aplicacion) {
		this.aplicacion = aplicacion;
	}

	public CategoriaDominio getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDominio categoria) {
		this.categoria = categoria;
	}

	public TipoDominio getTipo() {
		return tipo;
	}

	public void setTipo(TipoDominio tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "MensajeDominio [codigo=" + codigo + ", aplicacion=" + aplicacion + ", categoria=" + categoria
				+ ", tipo=" + tipo + ", mensaje=" + mensaje + "]";
	}

	public String getNvcodigo() {
		return nvcodigo;
	}

	public void setNvcodigo(String nvcodigo) {
		this.nvcodigo = nvcodigo;
	}
	
	
	
	
	
	
}
