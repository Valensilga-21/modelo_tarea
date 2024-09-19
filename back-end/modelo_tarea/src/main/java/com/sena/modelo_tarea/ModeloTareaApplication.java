package com.sena.modelo_tarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ModeloTareaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloTareaApplication.class, args);
	}

}
