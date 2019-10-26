package co.edu.uniremington.app.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.app.dominio.DepartamentoDominio;

@Repository
public interface DepartamentoJpaDAO extends JpaRepository<DepartamentoDominio, Integer>{

}
