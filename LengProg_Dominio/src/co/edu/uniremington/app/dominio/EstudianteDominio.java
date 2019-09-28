package co.edu.uniremington.app.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ESUDIANTE_DOMINIO", schema = "dbo")
public class EstudianteDominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="IN_COIGO_TIPO_IDENTIFICACION")
	private TipoIdentificacionDominio tipoIdentificacion;
	
	@Column(name = "NV_NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;
	
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	@Column(name = "DA_FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="IN_CODIGO_ESTADO_CIVIL")
	private EstadoCivilDominio estadoCivil;
	
	@Column(name = "NV_CORREO_ELECTRONICO")
	private String correoElectronico;
	
	@Column(name = "NV_DIRECCION")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="IN_COIGO_CIUDAD_RESIDENCIA")
	private CiudadDominio ciudadResidencia;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoIdentificacionDominio getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(TipoIdentificacionDominio tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public EstadoCivilDominio getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivilDominio estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public CiudadDominio getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(CiudadDominio ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	
}
