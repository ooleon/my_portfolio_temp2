package main.restControllers;

import java.util.Arrays;
import java.util.List;

import main.injection.LivroService;
import main.persistence.jpa.entities.library.Livro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/livros" })
public class AdminResource {
	public static final String ADMINS = "/admins";
	public static final String STATE = "/state";
	public static final String ECHO = "/echo";
	public static final String ID = "/{id}";
	public static final String BODY = "/body";
	public static final String STRING_LIST = "/string-list";
	public static final String DTO_LIST = "/dto-list";
	public static final String ROOT_CONTROLLER = "/livros";
	public static final String ALLBOOKS = "/tudos";
	public static final String BOOK = "/livro";
	public static final String TITULO = "/titulo";
	public static final String GENERO = "/genero";
	public static final String ISBN = "/isbn";
	public static final String AUTOR = "/autor";
	public static final String DISPONIVEL = "/disponivel";
	public static final String RETORNAR = "/retornar";
	public static final String ALUGAR = "/alugar";
	public static final String ATUALIZAR = "/atualizar";
	public static final String GUARDAR = "/guardar";
	public static final String PARAM_TITULO = "/{titulo}";
	public static final String PARAM_GENERO = "/{genero}";
	public static final String PARAM_ISBN = "/{isbn}";
	public static final String PARAM_DISPONIVEL = "/{disponivel}";
	public static final String PARAM = "/{parametro}";

	private static final Logger logger = LogManager.getLogger(AdminResource.class);

	@Autowired
	private LivroService livroService;

	@RequestMapping(value = { "/tudos" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Livro>> getAllBlog() {
		return new ResponseEntity(this.livroService.getAllLivro(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/livro/{id}" }, method = { RequestMethod.GET })
	public ResponseEntity<Livro> getToDoById(@PathVariable("id") long id) {
		return new ResponseEntity(this.livroService.getLivroById(id), HttpStatus.OK);
	}

	@RequestMapping(value = { "/titulo/{titulo}" }, method = { RequestMethod.GET })
	public ResponseEntity<Livro> getToDoByTitulo(@PathVariable("titulo") String titulo) {
		return new ResponseEntity(this.livroService.getLivroByTitulo(titulo), HttpStatus.OK);
	}

	@RequestMapping(value = { "/genero/{parametro}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Livro>> getLivroByGenero(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByGenero(s), HttpStatus.OK);
	}

	@RequestMapping(value = { "/isbn/{parametro}" }, method = { RequestMethod.GET })
	public ResponseEntity<Livro> getLivroByIsbn(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByIsbn(s), HttpStatus.OK);
	}

	@RequestMapping(value = { "/autor/{parametro}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Livro>> getLivroByAutor(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByAutor(s), HttpStatus.OK);
	}

	@RequestMapping(value = { "/disponivel/{parametro}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Livro>> getLivroByDisponivel(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByDisponivel(s), HttpStatus.OK);
	}

	@RequestMapping(value = { "/guardar" }, method = { RequestMethod.POST })
	public ResponseEntity<Livro> saveToDo(@RequestBody Livro l) {
		return new ResponseEntity(this.livroService.saveLivro(l), HttpStatus.OK);
	}

	@RequestMapping(value = { "/retornar/{id}" }, method = { RequestMethod.GET })
	public ResponseEntity<String> retornarLivro(@PathVariable("id") long id) {
		StringBuilder msg = new StringBuilder("");
		Livro l = this.livroService.getLivroById(id);
		l.setDisponivel("Sim");
		this.livroService.saveLivro(l);
		msg.append("Livro: ID: " + l.getId());
		msg.append(" Titulo: " + l.getTitulo());
		msg.append(" foi retornado com sucesso!!");

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/alugar/{id}" }, method = { RequestMethod.GET })
	public ResponseEntity<String> alugarLivro(@PathVariable("id") long id) {
		StringBuilder msg = new StringBuilder("");
		Livro al = this.livroService.getLivroById(id);
		if (al.getDisponivel().equals("Sim")) {
			al.setDisponivel("Nao");
			this.livroService.saveLivro(al);
			msg.append("Livro: ID: " + al.getId());
			msg.append(" Titulo: " + al.getTitulo());
			msg.append(" foi alugado com sucesso!!");
		} else {
			msg.append("Livro: " + al.getId());
			msg.append(" Titulo:" + al.getTitulo());
			msg.append(" :-( nao disponible :-(");
		}

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/atualizar" }, method = { RequestMethod.PUT })
	public ResponseEntity<String> updateToDo(@RequestBody Livro livroAnterior) {
		StringBuilder msg = new StringBuilder("");
		Livro l = this.livroService.getLivroById(livroAnterior.getId().longValue());
		if (l.getDisponivel().equals("Sim")) {
			this.livroService.removeLivro(l);
			msg.append("Livro: ID: " + l.getId());
			msg.append(" Titulo: " + l.getTitulo());
			msg.append(" foi atualizado com sucesso!!");
		} else {
			msg.append("Livro " + l.getId() + l.getTitulo());
			msg.append(" :-( nao disponible, nao pode ser atualizado :-(");
		}

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/livro/{id}" }, method = { RequestMethod.DELETE })
	public ResponseEntity<String> removeToDoById(@PathVariable("id") long id) {
		StringBuilder msg = new StringBuilder("");
		Livro l = this.livroService.getLivroById(id);
		if (l.getDisponivel().equals("Sim")) {
			this.livroService.removeLivro(l);
			msg.append("Livro: ID: " + l.getId());
			msg.append("Titulo: " + l.getTitulo());
			msg.append("foi removido com sucesso!!");
		} else {
			msg.append("Livro " + l.getId() + l.getTitulo());
			msg.append(" :-( nao disponible, nao pode ser removido :-(");
		}

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}
}
