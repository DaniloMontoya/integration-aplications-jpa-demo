package co.edu.uniremington.par.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAR_PARAMETRO_TBL",schema = "dbo")
public class ParametroDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_APLICACION")
	private AplicacionDominio aplicacion;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_TIPO_DATO")
	private TipoDatoDominio tipoDato;
	
	@Column(name = "NV_CLAVE")
	private String clave;
	
	@Column(name = "NV_VALOR")
	private String valor;

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

	public TipoDatoDominio getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDatoDominio tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
}
