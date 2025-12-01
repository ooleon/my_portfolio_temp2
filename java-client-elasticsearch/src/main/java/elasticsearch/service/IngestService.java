package elasticsearch.service;

import java.io.IOException;
import java.util.List;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
//import org.elasticsearch.action.bulk.BulkRequestBuilder;
//import org.elasticsearch.xcontent.XContentType;

/**
 * @author ooleon
 *
 */

public class IngestService {

    ElasticsearchClient client;

    public IngestService(ElasticsearchClient client) {
        this.client = client;
    }

    public void ingest(String type, String doc) throws IOException {
//		client.prepareIndex("twitter", "tweet").setSource(doc, XContentType.JSON ).get();
        // Create (solo si no existe)
        client.create(c -> c
                .index("my-index")
                .id("1")
                .document(doc)
        );

// Index (crear o reemplazar)
        client.index(i -> i
                .index("my-index")
                .id("1")
                .document(doc)
        );
    }

    public boolean ingest(String type, List<String> docs) throws IOException {
        /*
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		docs.forEach(doc -> bulkRequest.add(client.prepareIndex("twitter", type).setSource(doc, XContentType.JSON)));
		return bulkRequest.get().hasFailures();
	    */
        return this.ingest("1", docs);
    }

    public boolean ingest(String index, String type, List<String> docs) throws IOException {
        String id = "1";
        docs.forEach(doc -> {
            IndexResponse indexResponse;
            try {
                indexResponse = client.index(i -> i
                        .index(index)
                        .id(id)
                        .document(doc));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return client.get(g -> g
                        .index(index)
                        .id(id))
                .found();
        /*
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		docs.forEach(doc -> bulkRequest.add(client.prepareIndex(index, type).setSource(doc, XContentType.JSON)));
		return bulkRequest.get().hasFailures();
	    */
    }
}

