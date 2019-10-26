package co.edu.uniremington.app.web.inicializador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uniremington")
@EnableJpaRepositories(basePackages = "co.edu.uniremington.app.datos")
@EntityScan(basePackages = "co.edu.uniremington.app.dominio")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}


}
