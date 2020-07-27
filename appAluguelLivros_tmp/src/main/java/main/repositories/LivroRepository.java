package main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import main.persistence.jpa.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
