package main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import main.persistence.jpa.entities.Livro;
import main.repositories.LivroRepository;
import main.util.LivroUtil;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

	@Bean
	public CommandLineRunner setup(LivroRepository livroRepository) {
		return args -> {
			livroRepository.save(new Livro("Java vs Python", "Contenido Java", "isbn3", "Ma", "Tecnologia", LivroUtil.NAO));
			livroRepository.save(new Livro("Spring", "Contenido Spring", "isbn4", "Ma", "Programacion", LivroUtil.SIM));
			livroRepository
					.save(new Livro("Spring boot", "Contenido Spring boot", "isbn5", "Leo", "Programacion", LivroUtil.NAO));
			livroRepository
					.save(new Livro("Democracia Social", "Contenido eclipse", "isbn6", "Cintia", "Politica", LivroUtil.SIM));
			livroRepository.save(new Livro("Eclipse", "Contenido eclipse", "isbn7", "Karla", "Tecnologia", LivroUtil.NAO));
		};
	}
}