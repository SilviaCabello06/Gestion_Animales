package com.silvia.animales;

import com.silvia.animales.models.Animal;
import com.silvia.animales.models.Clase;
import com.silvia.animales.repositories.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalesApplication.class, args);
	}
	@Bean
	CommandLineRunner seedAnimals(AnimalRepository ar) {
		return (args) -> {
			if (ar.count() == 0) {
				ar.save(new Animal("Dodo", 30, true ));
				ar.save(new Animal("Tortuga", 100, false, ));
				ar.save(new Animal("Lince", 15, false, ));
			}
		};
	}
}
