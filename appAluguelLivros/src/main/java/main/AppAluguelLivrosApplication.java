package main;

import main.persistence.jpa.entities.library.Livro;
import main.repository.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppAluguelLivrosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppAluguelLivrosApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(LivroRepository livroRepository) {
		return args -> {
			livroRepository.save(new Livro("Java vs Python", "Contenido Java", "isbn3", "Ma", "Tecnologia", "Nao"));
			livroRepository.save(new Livro("Spring", "Contenido Spring", "isbn4", "Ma", "Programacion", "Sim"));
			livroRepository
					.save(new Livro("Spring boot", "Contenido Spring boot", "isbn5", "Leo", "Programacion", "Nao"));
			livroRepository
					.save(new Livro("Democracia Social", "Contenido eclipse", "isbn6", "Cintia", "Politica", "Sim"));
			livroRepository.save(new Livro("Eclipse", "Contenido eclipse", "isbn7", "Karla", "Tecnologia", "Nao"));
		};
	}
}