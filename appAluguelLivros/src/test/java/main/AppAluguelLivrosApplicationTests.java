package main;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import main.injection.LivroService;
import main.persistence.jpa.entities.Livro;
import main.restControllers.AdminResource;
import main.util.LivroUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.RestController;

@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = { "classpath:test.properties" })
public class AppAluguelLivrosApplicationTests {
	@Autowired
	private LivroService livroService;
	Livro livroNovo;
	long idLivroNovo;
	List<Livro> listLivro;

	private static final Logger logger = LogManager.getLogger(AppAluguelLivrosApplicationTests.class);

	@SpyBean
	@Autowired
	private AdminResource adminResource;

	@Autowired
	private Environment environment;
	private int microIterationTest;

	@Before
	public void setUp() {
		this.livroNovo = new Livro("Python and Java vs PHP", "Contenido Java", "isbn7", "Ma", "Tecnologia",
				LivroUtil.NAO);
		this.listLivro = this.livroService.getAllLivro();

		microIterationTest = Integer.parseInt(environment.getProperty("microIterationTest"));
		logger.info("microIterationTest: " + microIterationTest);
		logger.info(environment.getProperty("app.domain"));
	}

	@Test
	public void contextLoads() {
		System.out.println("contextLoads");
		logger.debug("contextLoads");
	}

	@Test
	public void getLivroByIdTest() {
		int idLast = ((Livro) this.listLivro.get(this.listLivro.size() - 1)).getId().intValue();
		Livro l = this.livroService.saveLivro(this.livroNovo);

		Assert.assertEquals("mensaje", (idLast + 1), l.getId().intValue());
	}

	@Test
	public void getLivroByIsbnTest() {
		Livro l = this.livroService.saveLivro(this.livroNovo);
		logger.trace(l.getIsbn());
		Assert.assertTrue((l.getIsbn() == this.livroNovo.getIsbn()));
	}

	@Test
	public void getLivroByIsbn2Test() {
		int id = 0;
		int id2 = 1;
		if (this.listLivro != null) {
			id = ((Livro) this.listLivro.get(0)).getId().intValue();
			id2 = this.livroService.getLivroByIsbn(((Livro) this.listLivro.get(0)).getIsbn()).getId().intValue();
		}

		Assert.assertTrue((id == id2));
	}

	@Test
	public void getAllLivroTest() {
		if (this.listLivro != null && !this.listLivro.isEmpty()) {
			Assert.assertTrue((this.listLivro.size() >= 0));
		}
	}

	@Test
	public void AdminResource_getAllBlog_sizeTest() {
		if (this.listLivro != null && !this.listLivro.isEmpty()) {
			Assert.assertTrue("getAllBlog.size: " + ((List) this.adminResource.getAllBlog().getBody()).size(),
					(((List) this.adminResource.getAllBlog().getBody()).size() == this.listLivro.size()));
			logger.trace("getAllBlog.size: " + ((List) this.adminResource.getAllBlog().getBody()).size());
		}
	}

	@Test
	public void servicoEditarLivroTest() {
		Livro al = (Livro) this.livroService.getLivroById(this.listLivro.get(1).getId());
		StringBuilder msg = new StringBuilder("");
		if (al.getDisponivel() == LivroUtil.NAO) {
			al.setConteudo("test para modificar diferente conteudo");
			// livro nao pode ser edidado por nao estar disponivel
			Assert.assertEquals(this.livroService.editarLivro(al), null);
		}else {
			al.setConteudo("test para modificar diferente conteudo");
			// livro pode ser edidado por estar disponivel
			Livro lSalvado = this.livroService.editarLivro(al);
			Assert.assertEquals(lSalvado.getConteudo(), al.getConteudo());

		}
	}

	@Test
	public void AdminResource_alugarLivroTest() {
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
		Assert.assertEquals(al.getDisponivel(), LivroUtil.NAO);

		String msg1 = (String) this.adminResource.alugarLivro(al.getId().longValue()).getBody();
		// RestController para o livro da Valor de Disponivel = nao.
		Assert.assertEquals(msg1, LivroUtil.NAO,
				((Livro) this.adminResource.getToDoById(al.getId().longValue()).getBody()).getDisponivel());
		logger.trace("alugarLivroTest: " + msg1);
	}

	@Test
	public void AdminResource_alugarLivroNegadoTest() {
		Livro l = (Livro) this.listLivro.get(0);
		if (l.getDisponivel().equals(LivroUtil.NAO)) {
			String msg = (String) this.adminResource.alugarLivro(l.getId().longValue()).getBody();

			Assert.assertEquals(msg, LivroUtil.NAO,
					((Livro) this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel());

			logger.trace("Regra de Negocio 1: " + msg);
		}
	}

	@Test
	public void AdminResource_alugarLivroNegadoRandomTest() {
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

				Assert.assertEquals(msg, LivroUtil.NAO,
						(this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel());

				logger.trace("Regra de Negocio 1: " + msg);
			}

		}
	}
}
