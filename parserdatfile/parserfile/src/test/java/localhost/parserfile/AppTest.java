package localhost.parserfile;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AppTest
{
	public App a;


	@Before
    public void setup()
    {
    	a = new App();
    	a.readFilesJuntos();
    }


	@Test
    public void testQtdeClientesMaiorCero()
    {
        assertTrue( a.clienteList.size() > 0 );
    }

	@Test
    public void testQtdeVendedoresMaiorCero()
    {
        assertTrue( a.vendedorList.size() > 0 );
    }

	@Test
    public void testIdVendaValorMaisAlto()
    {
        assertTrue( !a.idVendaValorMaisAlto.isEmpty() );
    }

	@Test
    public void testNomeVendedorMenosVendeu()
    {
        assertTrue( !a.nomeVendedorMenosVendeu.isEmpty() );
    }
	
	@Test
    public void testFileExist()
    {
		File f = new File("./dados/out/Vendas_Sep.dat.proc");
        assertTrue( f.exists() );
    }

}
