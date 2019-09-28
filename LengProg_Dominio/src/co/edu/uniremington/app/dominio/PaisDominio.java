package co.edu.uniremington.app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="APP_PAIS_TBL", schema = "dbo")
@Entity
public class PaisDominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@Column(name = "NV_NOMBRE")
	private String nombre;
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
	@Override
	public String toString() {
		return "PaisDominio [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
