package main.persistence.jpa.entities.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Livro {
	@Id
	@GeneratedValue
	private Long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String conteudo;
	private String genero;
	private String disponivel;

	public Livro() {
	}

	public Livro(String titulo, String conteudo, String isbn, String autor, String genero, String disponivel) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.conteudo = conteudo;
		this.genero = genero;
		this.disponivel = disponivel;
	}

	public String toString() {
		return "{id=" + this.id + ", isbn='" + this.isbn + '\'' + ", titulo='" + this.titulo + '\'' + ", autor='"
				+ this.autor + '\'' + ", genero='" + this.genero + '\'' + ", disponivel='" + this.disponivel + '\''
				+ ", conteudo='" + this.conteudo + '\'' + '}';
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
}
