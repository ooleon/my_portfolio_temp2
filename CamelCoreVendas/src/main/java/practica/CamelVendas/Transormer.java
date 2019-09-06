package practica.CamelVendas;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Transormer {
	public String transformContent(String body)
	{
		


		String string = body;
		CSVParser parser = null;
		try {
			parser = CSVParser.parse(string, CSVFormat.newFormat(';'));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer v=0,c=0;
		double vmais=0, vmenor=0;
		String idmais="null", nmenor="null";
		TreeMap tm = new TreeMap();
		
		for (CSVRecord csvRecord : parser) {
			
			//Vendedor
			if (csvRecord.get(0).equals("001")) {
				v++;
			}
			
			//Clente
			if (csvRecord.get(0).equals("002")) {
				c++;
			}
			
			//Vendas
			/*
			 *
			 */
			if (csvRecord.get(0).equals("003")) {
				//Key key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
				double venda = (Double.valueOf(csvRecord.get(3)) * Double.valueOf(csvRecord.get(4) ));
				if (venda > vmais ) { 
					idmais=csvRecord.get(1);
					vmais = venda;
				}
					
				double vendamenor = (Double.valueOf(csvRecord.get(3)) * Double.valueOf(csvRecord.get(4) ));
				if (vmenor == 0) vmenor = vendamenor;
				if (vendamenor < vmenor ) { 
					nmenor=csvRecord.get(5);
					vmenor = vendamenor;
				}

			}

			System.out.println("csvRecord:\t" + csvRecord + "\n\t" + csvRecord.get(0));
			System.out.println( "Clientes:" + c.toString() + "\tVendedores:" + v.toString() +  
			"\tid Venda Maior: " + idmais + "\t Nome Vendedor menor: " + nmenor) ;
		}


		return c.toString() + ";" + v.toString() +  
				";" + idmais + ";" + nmenor ;
	}

}
