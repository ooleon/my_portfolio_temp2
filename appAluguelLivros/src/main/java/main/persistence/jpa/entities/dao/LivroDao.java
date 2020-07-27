package main.persistence.jpa.entities.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.persistence.jpa.entities.Livro;

public interface LivroDao extends JpaRepository<Livro, String> {
	List<Livro> findByGeneroIgnoreCase(String paramString);

	Livro findByTituloIgnoreCase(String paramString);

	Livro findByIsbnIgnoreCase(String paramString);

	List<Livro> findByAutorIgnoreCase(String paramString);

	List<Livro> findByDisponivelIgnoreCase(String paramString);
}
