package main.restControllers;

import java.util.Arrays;
import java.util.List;

import main.injection.LivroService;
import main.persistence.jpa.entities.Livro;
import main.util.LivroUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/livros" })
public class AdminResource {
	public static final String ADMINS = "/admins";
	public static final String STATE = "/state";
	public static final String ECHO = "/echo";
	public static final String BODY = "/body";
	public static final String STRING_LIST = "/string-list";
	public static final String DTO_LIST = "/dto-list";
	public static final String ROOT_CONTROLLER = "/livros";
	
	public static final String TUDOS = "/tudos";
	public static final String LIVRO = "/livro";
	public static final String TITULO = "/titulo";
	public static final String GENERO = "/genero";
	public static final String ISBN = "/isbn";
	public static final String AUTOR = "/autor";
	public static final String DISPONIVEL = "/disponivel";
	public static final String RETORNAR = "/retornar";
	public static final String ALUGAR = "/alugar";
	public static final String ATUALIZAR = "/atualizar";
	public static final String GUARDAR = "/guardar";
	public static final String PARAM_ID = "/{id}";
	public static final String PARAM_TITULO = "/{titulo}";
	public static final String PARAM_GENERO = "/{genero}";
	public static final String PARAM_ISBN = "/{isbn}";
	public static final String PARAM_DISPONIVEL = "/{disponivel}";
	public static final String PARAM = "/{parametro}";

	private static final Logger logger = LogManager.getLogger(AdminResource.class);

	@Autowired
	private LivroService livroService;

	@GetMapping({TUDOS})
	public ResponseEntity<List<Livro>> getAllBlog() {
		return new ResponseEntity(this.livroService.getAllLivro(), HttpStatus.OK);
	}

	@GetMapping({LIVRO + "/{id}"})
	public ResponseEntity<Livro> getToDoById(@PathVariable long id) {
		return new ResponseEntity(this.livroService.getLivroById(id), HttpStatus.OK);
	}

	@GetMapping({TITULO + PARAM})
	public ResponseEntity<Livro> getToDoByTitulo(@PathVariable("parametro") String titulo) {
		return new ResponseEntity(this.livroService.getLivroByTitulo(titulo), HttpStatus.OK);
	}

	@GetMapping({GENERO + PARAM})
	public ResponseEntity<List<Livro>> getLivroByGenero(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByGenero(s), HttpStatus.OK);
	}

	@GetMapping({ISBN + PARAM})
	public ResponseEntity<Livro> getLivroByIsbn(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByIsbn(s), HttpStatus.OK);
	}

	@GetMapping({AUTOR + PARAM})
	public ResponseEntity<List<Livro>> getLivroByAutor(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByAutor(s), HttpStatus.OK);
	}

	@GetMapping({DISPONIVEL + PARAM})
	public ResponseEntity<List<Livro>> getLivroByDisponivel(@PathVariable("parametro") String s) {
		return new ResponseEntity(this.livroService.getLivroByDisponivel(s), HttpStatus.OK);
	}

	@PostMapping({GUARDAR})
	public ResponseEntity<Livro> saveToDo(@RequestBody Livro l) {
		return new ResponseEntity(this.livroService.saveLivro(l), HttpStatus.OK);
	}

	@GetMapping({RETORNAR + PARAM_ID})
	public ResponseEntity<String> retornarLivro(@PathVariable long id) {
		StringBuilder msg = new StringBuilder("");
		Livro l = this.livroService.getLivroById(id);
		this.livroService.saveLivro(l);
		l.setDisponivel(LivroUtil.SIM);
		msg.append("Livro: ID: " + l.getId());
		msg.append(" Titulo: " + l.getTitulo());
		msg.append(LivroUtil.RETORNADO_COM_SUCESSO);

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@GetMapping({ALUGAR + PARAM_ID})
	public ResponseEntity<String> alugarLivro(@PathVariable long id) {
		StringBuilder msg = new StringBuilder("");
		Livro al = this.livroService.getLivroById(id);
		
		if (al != null) {
			if (this.livroService.alugarLivro(id)) {
				msg.append("Livro: ID: " + al.getId());
				msg.append(" Titulo: " + al.getTitulo());
				msg.append(LivroUtil.ALUGADO_COM_SUCESSO);
			}else {
				msg.append("Livro: " + al.getId());
				msg.append(" Titulo:" + al.getTitulo());
				msg.append(LivroUtil.NAO_DISPONIVEL);
			}
		}else {
			msg.append("id: " + id + LivroUtil.NAO_CONSEGUIDO );
		}
			
		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@PutMapping({ATUALIZAR})
	public ResponseEntity<String> updateToDo(@RequestBody Livro livroAnterior) {
		StringBuilder msg = new StringBuilder("");
		Livro al = this.livroService.getLivroById(livroAnterior.getId().longValue());

		if (al != null) {
			if (this.livroService.editarLivro(al) != null) {
				msg.append("Livro: ID: " + al.getId());
				msg.append(" Titulo: " + al.getTitulo());
				msg.append(LivroUtil.ATUALIZADO);
			}else {
				msg.append("Livro: " + al.getId());
				msg.append(" Titulo:" + al.getTitulo());
				msg.append(LivroUtil.NAO_DISPONIVEL);
				msg.append(", nao pode ser atualizado :-(");
			}
		}else {
			msg.append("id: " + livroAnterior.getId().longValue() + LivroUtil.NAO_CONSEGUIDO );
		}
		
		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}

	@DeleteMapping({LIVRO + PARAM_ID})
	public ResponseEntity<String> removeToDoById(@PathVariable long id) {
		StringBuilder msg = new StringBuilder("");
		Livro l = this.livroService.getLivroById(id);
		if (l.getDisponivel().equals(LivroUtil.SIM)) {
			this.livroService.removeLivro(l);
			msg.append("Livro: ID: " + l.getId());
			msg.append("Titulo: " + l.getTitulo());
			msg.append(LivroUtil.REMOVIDO_SUCESSO);
		} else {
			msg.append("Livro " + l.getId() + l.getTitulo());
			msg.append(" :-( nao disponible, nao pode ser removido :-(");
		}

		logger.info(msg.toString());
		return new ResponseEntity(msg.toString(), HttpStatus.OK);
	}
}
