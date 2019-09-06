package main.injection;

import java.util.List;
import main.persistence.jpa.entities.LivroDao;
import main.persistence.jpa.entities.library.Livro;
import main.repository.LivroRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	private static final Logger logger = LogManager.getLogger(LivroService.class);

	@Autowired
	private LivroRepository livroRepository;

	public String getMessage() {
		logger.info(getMessage());
		return "(" + hashCode() + "): LivroService!!!";
	}

	@Autowired
	private LivroDao livroDao;

	public List<Livro> getAllLivro() {
		return this.livroRepository.findAll();
	}

	public Livro getLivroById(long id) {
		return (Livro) this.livroRepository.findById(Long.valueOf(id)).get();
	}

	public Livro getLivroByTitulo(String titulo) {
		return this.livroDao.findByTituloIgnoreCase(titulo);
	}

	public List<Livro> getLivroByGenero(String s) {
		return this.livroDao.findByGeneroIgnoreCase(s);
	}

	public Livro getLivroByIsbn(String s) {
		return this.livroDao.findByIsbnIgnoreCase(s);
	}

	public List<Livro> getLivroByAutor(String s) {
		return this.livroDao.findByAutorIgnoreCase(s);
	}

	public List<Livro> getLivroByDisponivel(String s) {
		return this.livroDao.findByDisponivelIgnoreCase(s);
	}

	public Livro saveLivro(Livro livro) {
		Livro l = this.livroRepository.save(livro);
		logger.info(l.toString());
		return l;
	}

	public void removeLivro(Livro livro) {
		this.livroRepository.delete(livro);
		logger.info(livro.toString());
	}
}
