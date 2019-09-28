package co.edu.uniremington.lengprog.app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "APP_DEPARTAMENTO_TBL", schema = "dbo")
public class DepartamentoDominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_PAIS")
	private PaisDominio pais;

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

	public PaisDominio getPais() {
		return pais;
	}

	public void setPais(PaisDominio pais) {
		this.pais = pais;
	}

}
