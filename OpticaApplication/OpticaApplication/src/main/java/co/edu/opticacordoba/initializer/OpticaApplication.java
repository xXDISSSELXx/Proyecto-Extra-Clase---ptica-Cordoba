package co.edu.opticacordoba.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.opticacordoba.controller"})
public class OpticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpticaApplication.class, args);
	}

}
