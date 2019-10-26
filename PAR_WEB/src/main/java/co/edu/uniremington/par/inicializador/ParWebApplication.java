package co.edu.uniremington.par.inicializador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uniremington.par")
@EnableJpaRepositories(basePackages = "co.edu.uniremington.par.datos")
@EntityScan(basePackages = "co.edu.uniremington.par.dominio")
public class ParWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParWebApplication.class, args);
	}

}
