package co.edu.uniremington.men.servicio;

import java.util.List;

public interface IServicio<D> {

	void crear(D dominio);
	void actualizar(D dominio);
	void eliminar(D dominio);
	List<D> consultar(D dominio);

}
