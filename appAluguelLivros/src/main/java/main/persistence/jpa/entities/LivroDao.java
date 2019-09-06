package main.persistence.jpa.entities;

import java.util.List;
import main.persistence.jpa.entities.library.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroDao extends JpaRepository<Livro, String> {
	List<Livro> findByGeneroIgnoreCase(String paramString);

	Livro findByTituloIgnoreCase(String paramString);

	Livro findByIsbnIgnoreCase(String paramString);

	List<Livro> findByAutorIgnoreCase(String paramString);

	List<Livro> findByDisponivelIgnoreCase(String paramString);
}
