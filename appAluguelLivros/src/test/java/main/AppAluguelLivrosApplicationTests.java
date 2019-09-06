package main;

import java.util.List;
import main.injection.LivroService;
import main.persistence.jpa.entities.library.Livro;
import main.restControllers.AdminResource;

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

	@Before
	public void setUp() {
		this.livroNovo = new Livro("Python and Java vs PHP", "Contenido Java", "isbn7", "Ma", "Tecnologia", "Nao");
		this.listLivro = this.livroService.getAllLivro();
	}

	@Test
	public void contextLoads() {

		logger.info(environment.getProperty("app.domain"));
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
	public void AdminResource_alugarLivroTest() {
		Livro l = (Livro) this.listLivro.get(1);
		if (this.listLivro != null && !this.listLivro.isEmpty()) {
			if (l.getDisponivel().equals("Sim")) {
				String msg = (String) this.adminResource.alugarLivro(l.getId().longValue()).getBody();
				Assert.assertEquals(msg, "Nao", (

				(Livro) this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel());
				logger.trace("alugarLivroTest: " + msg);
			}
		}
	}

	@Test
	public void AdminResource_alugarLivroNegadoTest() {
		Livro l = (Livro) this.listLivro.get(0);
		if (l.getDisponivel().equals("Nao")) {
			String msg = (String) this.adminResource.alugarLivro(l.getId().longValue()).getBody();

			Assert.assertEquals(msg, "Nao",
					((Livro) this.adminResource.getToDoById(l.getId().longValue()).getBody()).getDisponivel());

			System.out.println("Regra de Negocio 1: " + msg);
		}
	}
}
