package main;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import main.injection.LivroService;

import static org.junit.jupiter.api.Assertions.*;

import main.persistence.jpa.entities.Livro;
import main.restControllers.AdminResource;
import main.util.LivroUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test.properties"})
class AppAluguelLivrosApplicationTests {
	@Autowired
	private LivroService livroService;
	Livro livroNovo;
	long idLivroNovo;
	List<Livro> listLivro;

	private static final Logger logger = LogManager.getLogger(AppAluguelLivrosApplicationTests.class);

    //    @SpyBean
    @Spy
	@Autowired
	private AdminResource adminResource;

	@Autowired
	private Environment environment;
	private int microIterationTest;

    @BeforeEach
    void setUp() {
		this.livroNovo = new Livro("Python and Java vs PHP", "Contenido Java", "isbn7", "Ma", "Tecnologia",
				LivroUtil.NAO);
		this.listLivro = this.livroService.getAllLivro();

		microIterationTest = Integer.parseInt(environment.getProperty("microIterationTest"));
		logger.info("microIterationTest: " + microIterationTest);
		logger.info(environment.getProperty("app.domain"));
	}

    @Test
    void contextLoads() {
		System.out.println("contextLoads");
		logger.debug("contextLoads");
	}

    @Test
    void getLivroByIdTest() {
		int idLast = ((Livro) this.listLivro.get(this.listLivro.size() - 1)).getId().intValue();
		Livro l = this.livroService.saveLivro(this.livroNovo);

		assertEquals((idLast + 1), l.getId().intValue(), "mensaje");
	}

    @Test
    void getLivroByIsbnTest() {
		Livro l = this.livroService.saveLivro(this.livroNovo);
		logger.trace(l.getIsbn());
		assertTrue((l.getIsbn() == this.livroNovo.getIsbn()));
	}

    @Test
    void getLivroByIsbn2Test() {
		int id = 0;
		int id2 = 1;
		if (this.listLivro != null) {
			id = ((Livro) this.listLivro.get(0)).getId().intValue();
			id2 = this.livroService.getLivroByIsbn(((Livro) this.listLivro.get(0)).getIsbn()).getId().intValue();
		}

		assertTrue((id == id2));
	}

    @Test
    void getAllLivroTest() {
		if (this.listLivro != null && !this.listLivro.isEmpty()) {
			assertTrue((this.listLivro.size() >= 0));
		}
	}

    @Test
    void AdminResource_getAllBlog_sizeTest() {
		if (this.listLivro != null && !this.listLivro.isEmpty()) {
			assertTrue((((List) this.adminResource.getAllBlog().getBody()).size() == this.listLivro.size()),
					"getAllBlog.size: " + ((List) this.adminResource.getAllBlog().getBody()).size());
			logger.trace("getAllBlog.size: " + ((List) this.adminResource.getAllBlog().getBody()).size());
		}
	}

    @Test
    void servicoEditarLivroTest() {
		Livro al = (Livro) this.livroService.getLivroById(this.listLivro.get(1).getId());
		StringBuilder msg = new StringBuilder("");
		if (al.getDisponivel() == LivroUtil.NAO) {
			al.setConteudo("test para modificar diferente conteudo");
            // livro nao pode ser edidado por nao estar disponivel
            assertNull(this.livroService.editarLivro(al));
		}else {
			al.setConteudo("test para modificar diferente conteudo");
			// livro pode ser edidado por estar disponivel
			Livro lSalvado = this.livroService.editarLivro(al);
			assertEquals(lSalvado.getConteudo(), al.getConteudo());

		}
	}

    @Test
    void AdminResource_alugarLivroTest() {
		Livro al = (Livro) this.listLivro.get(1);
		StringBuilder msg = new StringBuilder("");
		if (this.livroService.alugarLivro(al.getId())) {
			msg.append("Livro: ID: " + al.getId());
			msg.append(" Titulo: " + al.getTitulo());
			msg.append(LivroUtil.ALUGADO_COM_SUCESSO);
		} else {
			msg.append("Livro: " + al.getId());
			msg.append(" Titulo:" + al.getTitulo());
			msg.append(LivroUtil.NAO_DISPONIVEL);
		}

		al = (Livro) this.livroService.getLivroById(al.getId());
        // Livro salvado e Disponivel = nao.
        assertEquals(LivroUtil.NAO, al.getDisponivel());

		String msg1 = (String) this.adminResource.alugarLivro(al.getId().longValue()).getBody();
		// RestController para o livro da Valor de Disponivel = nao.
		assertEquals(LivroUtil.NAO,
				((Livro) this.adminResource.getToDoById(al.getId().longValue()).getBody()).getDisponivel(),
				msg1);
		logger.trace("alugarLivroTest: " + msg1);
	}

    @Test
    void AdminResource_alugarLivroNegadoTest() {
		Livro l = (Livro) this.listLivro.get(0);
		if (l.getDisponivel().equals(LivroUtil.NAO)) {
			String msg = (String) this.adminResource.alugarLivro(l.getId().longValue()).getBody();

			assertEquals(LivroUtil.NAO,
					((Livro) this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel(),
					msg);

			logger.trace("Regra de Negocio 1: " + msg);
		}
	}

    @Test
    void AdminResource_alugarLivroNegadoRandomTest() {
		Random r = new Random();
		Livro l;

		for (int i = 0; i <= microIterationTest; i++) {
			do {
				l = (Livro) this.listLivro.get((int) r.nextInt(listLivro.size()));

			} while (l.getDisponivel().equals(LivroUtil.SIM));
			logger.trace("Livro random: ");
			logger.trace(l);

			if (l.getDisponivel().equals(LivroUtil.NAO)) {
				String msg = this.adminResource.alugarLivro(l.getId().longValue()).getBody();

				assertEquals(LivroUtil.NAO,
						(this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel(),
						msg);

				logger.trace("Regra de Negocio 1: " + msg);
			}

		}
	}
}
