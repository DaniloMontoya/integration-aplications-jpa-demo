package co.edu.uniremington.transversal.mensajes.dto;



public class Mensaje {

		private int codigo;
		
		private Aplicacion aplicacion;
		
		private Categoria categoria;
		
		private Tipo tipo;
		
		private String mensaje;
		
		private String nvcodigo;

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public Aplicacion getAplicacion() {
			return aplicacion;
		}

		public void setAplicacion(Aplicacion aplicacion) {
			this.aplicacion = aplicacion;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Tipo getTipo() {
			return tipo;
		}

		public void setTipo(Tipo tipo) {
			this.tipo = tipo;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getNvcodigo() {
			return nvcodigo;
		}

		public void setNvcodigo(String nvcodigo) {
			this.nvcodigo = nvcodigo;
		}

	
}
