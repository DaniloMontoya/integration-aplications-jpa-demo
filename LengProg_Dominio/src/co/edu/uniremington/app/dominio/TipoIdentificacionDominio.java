package co.edu.uniremington.app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_TIPO_IDENTIFICACION_TBL", schema = "dbo")
public class TipoIdentificacionDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	@Column(name = "IN_EDAD_MINIMA")
	private int edadMinima;
	
	@Column(name = "IN_EDAD_MAXIMA")
	private int edadMaxima;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public int getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	@Override
	public String toString() {
		return "TipoIdentificacionDominio [codigo=" + codigo + ", nombre=" + nombre + ", edadMinima=" + edadMinima
				+ ", edadMaxima=" + edadMaxima + "]";
	}
	
}
