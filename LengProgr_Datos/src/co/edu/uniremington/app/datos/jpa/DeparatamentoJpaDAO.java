package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniremington.app.dominio.DepartamentoDominio;

public interface DeparatamentoJpaDAO extends JpaRepository<DepartamentoDominio, Integer> {

}
