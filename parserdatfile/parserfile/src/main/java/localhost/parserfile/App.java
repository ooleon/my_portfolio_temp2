package localhost.parserfile;

import java.io.*;
import java.util.*;

import javax.swing.event.ListSelectionEvent;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.opencsv.CSVReader;

public class App {
	public static String file;
	public static String pathFile = "vendedores.dat";
	public static String nfVendedores = "Vendedores.dat";
	public static String nfClientes = "Clientes.dat";
	public static String nfVendas = "Vendas.dat";
	public static String sDiretorioIn = "./dados/in/";
	public static String sDiretorioOut = "./dados/out/";
	public static String nfSaida = "archivoSaida.dat.proc";
	public static String dirH = "~/";

	public String[] nextLine = {};
	public Vendedor vendedor;
	public Cliente cliente;
	public Venda venda;
	public List<Vendedor> vendedorList;
	public List<Cliente> clienteList;
	public List<Venda> vendaList;

	public String idVendaValorMaisAlto;
	public String nomeVendedorMenosVendeu;

	public static void main(String[] args) {
		App a = new App();
		a.readFilesJuntos();
	}

	/*
	 * Se espera que haya un unico archivo con toda la información de los
	 * Vendedores, Clientes y Ventas identificado por id. 
	 * 1. Dados de Vendedores: (001;CPF;nome;salário) 
	 * 2. Dados de Clientes: (002;CNPJ;nome;ramo de atividade) 
	 * 3. Dados de Vendas: (003;ID da venda;ID do item;qtde do item;preço do item;Nome do Vendedor) 
	 * Se asume que no hay id duplicados, que los datos estan correctamente en el formato indicado. 
	 * Se asume que no es necesario hacer revisión de la calidad de los datos.
	 */
	public void readFilesJuntos() {

		File file = null;
		FileInputStream fs = null;
		try {

			File ff = new File(sDiretorioIn);
			System.out.println("directorio in: " + ff);

			for (String archivo : ff.list()) {

				iniArrays();

				System.out.println("Leyendo archivo: " + sDiretorioIn + archivo + " ");
				file = new File(sDiretorioIn + archivo);

				System.out.println(" parseando semi colon: " + sDiretorioIn + archivo + " ");
				semicolonParse(file);

				System.out.println(" preparando saida: " + sDiretorioOut + archivo + " \n");
				StringBuilder sb = new  StringBuilder();
				sb.append("1. Quantidade de Clientes:" + QuantidadeDeClientes()    + " \n");
				sb.append("2. Quantidade de Vendedores:" + QuantidadeDeVendedores() + " \n");
				sb.append("3. ID da Venda de valor mais alto:" + ID_da_Venda_de_valor_mais_alto() + " \n");
				sb.append("4. Nome do Vendedor que menos vendeu:" + Nome_do_Vendedor_que_menos_vendeu() + " \n");

				saidaManager(sb.toString(), archivo+".proc");
//				saidaManager(nextLine, archivo+".proc");

			}

			// fs = new FileInputStream(f);
			// streamPrint(fs);
			// fs.close();
			// for (String archivo : ff.list()) {
			// File fileList = new File(dir + archivo);
			// System.out.println(" " + dir + archivo + " " + fileList.list());
			// semicolonPrint(fileList);
			// }

		} catch (Exception e1) {
			e1.printStackTrace();

		} finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {

				}
			}
		}

	}

	private void semicolonParse(File f) throws FileNotFoundException, IOException {
		// openCSV reader to parse the CSV file
		CSVReader reader = new CSVReader(new FileReader(f));

		// nextLine array contains a an entire row of data,
		// Each element represents a cell in the spreadsheet.
		// Iterate though the CSV while there are more lines to read
		while ((nextLine = reader.readNext()) != null) {
			// Iterate through the elements on this line
//			System.out.println(nextLine[0]);
//			System.out.println(nextLine[0].split(";")[0] + " " + nextLine[0].split(";")[1]);

			// pic and separate each line dipend of code to it's procesor
			if (nextLine[0].split(";")[0].equals("001")) {
				managerVendedores(nextLine[0]);
			}
			if (nextLine[0].split(";")[0].equals("002")) {
				managerClientes(nextLine[0]);
			}
			if (nextLine[0].split(";")[0].equals("003")) {
				managerVendas(nextLine[0]);
			}
		}

		System.out.println("cantidad de lineas han sido leidas: " + reader.getLinesRead() + "\n");
		System.out.println("fin de lectura: " + f + "\n");
		reader.close();

	}

	private void iniArrays() {
		clienteList = new ArrayList();
		vendedorList = new ArrayList();
		vendaList = new ArrayList();
	}

	void managerVendedores(String line) {

		System.out.println("Manager Vendedores:");
		System.out.println("\tLista de campos: " + line.split(";").length);
		vendedor = new Vendedor(line.split(";")[0].toString(), line.split(";")[1].toString(),
				line.split(";")[2].toString(), line.split(";")[3].toString());
		vendedorList.add(vendedor);
	}

	void managerClientes(String line) {
		System.out.println("Manager Cliente:");
		System.out.println("\tLista de campos: " + line.split(";").length);
		cliente = new Cliente(line.split(";")[0].toString(), line.split(";")[1].toString(),
				line.split(";")[2].toString(), line.split(";")[3].toString());
		clienteList.add(cliente);
	}

	void managerVendas(String line) {
		try {

			System.out.println("Manager Vendas:");
			System.out.println("\tLista de Vendas: " + line.split(";").length);

			int qtdeDoItem = Integer.parseInt(line.split(";")[3].toString());
			String spreçoDoItem = line.split(";")[4].toString();
			System.out.println("\t spreçoDoItem: " + spreçoDoItem);
			double preçoDoItem = Double.parseDouble(spreçoDoItem);
			double qtd_vendida = qtdeDoItem * preçoDoItem;
			venda = new Venda(line.split(";")[0].toString(), line.split(";")[1].toString(), qtdeDoItem, preçoDoItem,
					qtd_vendida, line.split(";")[5].toString());
			vendaList.add(venda);
			System.out.println("\t" + "qtdeDoItem: " + qtdeDoItem + " preçoDoItem: " + preçoDoItem + " Qtde de Vendas: "
					+ qtd_vendida);

			System.out.println(vendaList);
			
/**
 * Opcionalmente se pode usar este códico para versoes anteriores a 8. Em lugar da seguinte.
 * 			 vendaList.sort(new Comparator<Venda>() {
			 @Override
			 public int compare(Venda o1, Venda o2) {
			 //Return 0 if o1 and o2 are equal
			 //Return +1 if o1 comes after o2
			 //Return -1 if o1 comes before o2
			 if (o1 == o2) {
			 return 0;
			 }
			 if (o1 != null) {
			 return (o2 != null) ? o1.getVenda().compareTo(o2.getVenda()) : 1;
			 }
			 return -1;
			 }
			 });
*/

			/**
			 * Expresao lamda usando java 8 para ordenar lista de objetos por um atributo especifico.
			 */
			vendaList.sort((vl1, vl2) -> {
				if (vl1.getVenda() == vl2.getVenda()) {
					return 0;
				}
				return (vl1.getVenda() <= vl2.getVenda()) ? -1 : 1;
			});

			System.out.println(vendaList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		 idVendaValorMaisAlto = vendaList.get(vendaList.size() - 1).getIdDoItem();
		 nomeVendedorMenosVendeu = vendaList.get(0).getNomeDovendedor();
	}

	/*
	 * Requisitos:
	 *
	 * 1. Quantidade de Clientes:
	 * 
	 * 2. Quantidade de Vendedores:
	 * 
	 * 3. ID da Venda de valor mais alto:
	 * 
	 * 4. Nome do Vendedor que menos vendeu:
	 * 
	 */

	/*
	 * 1. Quantidade de Clientes:
	 */
	public int QuantidadeDeClientes() {
		int i = clienteList.size();
		System.out.println("Quantidade de clientes:" + i);
		return i;
	}

	/*
	 * 2. Quantidade de Vendedores:
	 */
	private int QuantidadeDeVendedores() {
		int i = vendedorList.size();
		System.out.println("Quantidade de vendedores:" + i);
		return i;
	}

	/*
	 * 3. ID da Venda de valor mais alto:
	 */
	private String ID_da_Venda_de_valor_mais_alto() {
		System.out.println("id Venda Valor Mais Alto:" + idVendaValorMaisAlto);

		return idVendaValorMaisAlto;

	}

	/*
	 * 4. Nome do Vendedor que menos vendeu:
	 */
	private String Nome_do_Vendedor_que_menos_vendeu() {
		System.out.println("nome Vendedor Menos Vendeu:" + nomeVendedorMenosVendeu);
		return nomeVendedorMenosVendeu;

	}

	
	
	
	private void saidaManager(String conteudo, String archivoSaida) {
		File outDir = new File(sDiretorioOut);

		// if the directory does not exist, create it
		if (!outDir.exists()) {
			System.out.println("Creando directorio saida: " + outDir.getName());
			boolean result = false;

			try {
				outDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("\tdirectorio " + sDiretorioOut + " creado");
			}
		}
		File file = new File(sDiretorioOut + archivoSaida);
		String content = conteudo;
		saidaOutputStream(content, file);

	}

	private void saidaOutputStream(String content, File file) {
		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Crado o Archivo de saida: " + file);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
