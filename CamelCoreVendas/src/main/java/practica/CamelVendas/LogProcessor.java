package practica.CamelVendas;

import java.util.List;
import java.util.TreeMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.Exchange;
import org.apache.camel.NoTypeConversionAvailableException;
import org.apache.camel.util.ExchangeHelper;
import org.apache.camel.util.IOHelper;
import org.apache.camel.util.ObjectHelper;
import org.apache.commons.csv.*;

public class LogProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("processing:\n" + exchange.getIn().getBody(String.class));
	}

}
