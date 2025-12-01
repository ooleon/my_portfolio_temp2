package elasticsearch.util;

import java.net.InetAddress;
import java.util.Optional;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.*;
import co.elastic.clients.elasticsearch.transform.Settings;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.ElasticsearchTransportBase;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogBuilder;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.elasticsearch.client.RestClient;

import static co.elastic.clients.elasticsearch.indices.get.Feature.Settings;

/**
 * @author ooleon
 *
 */

//@Component
public class ESTransportClient {
//    private final org.slf4j.Logger logger0 = LoggerFactory.getLogger(this.getClass().getName().toString());
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ESTransportClient.class);


	public Optional<ElasticsearchClient> getClient(String clusterName, String host, int port) {
		try {
//            Settings settings = Settings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true).build();
//			TransportClient client = new PreBuiltTransportClient(settings);
//			client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));



            // 1. Crear el RestClient de bajo nivel (de la librería elasticsearch-java)
            RestClient restClient = RestClient.builder(
                    new HttpHost(host, port)

            ).build();

            // 2. Crear el transporte usando el RestClient y un mapper JSON
            ElasticsearchTransport transport = new RestClientTransport(
                    restClient,
                    new JacksonJsonpMapper()
            );

            // 3. Crear y devolver el cliente de alto nivel
//            return Optional.of(new ElasticsearchClient(transport));



            String serverUrl = "https://" +host +":" + port;
            String apiKey = "";

            ElasticsearchClient client = ElasticsearchClient.of(b -> b
                    .host(serverUrl)
                    .apiKey(apiKey)
            );
            return Optional.of(client);
		} catch (Exception e) {
			e.printStackTrace();
//            logger.error("Error while initializing TransportClient :" + e.getMessage(), e);
            logger.error("Error while initializing Client :" + e.getMessage(), e);
			return Optional.empty();
			
		}
	}

}

/*
org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'application': 
Unsatisfied dependency expressed through field 'es'; 
nested exception is 
org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'elasticsearchTemplate' defined in class path resource
 [org/springframework/boot/autoconfigure/data/elasticsearch/ElasticsearchDataAutoConfiguration.class]: 
Unsatisfied dependency expressed through method 'elasticsearchTemplate' 
parameter 0; nested exception is 
org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'client' defined in class path resource
 [com/mkyong/EsConfig.class]: Bean instantiation via factory method failed; 
nested exception is org.springframework.beans.BeanInstantiationException: 
Failed to instantiate [org.elasticsearch.client.Client]: 
Factory method 'client' threw exception; nested exception is
 java.lang.NoClassDefFoundError: org/elasticsearch/transport/Netty3Plugin
 */
