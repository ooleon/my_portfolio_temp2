package practica.CamelVendas;

import org.apache.camel.builder.RouteBuilder;

public class FirstRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
	from("file:dados/in?noop=true")
	.process(new LogProcessor())
	.bean(new Transormer(),"transformContent")
	.to("file:dados/output");	
	}

}

