package co.edu.uniremington.par.datos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniremington.par.dominio.TipoDatoDominio;

@Repository
public interface TipoDatoJpaDAO extends JpaRepository<TipoDatoDominio, Integer>{

}
