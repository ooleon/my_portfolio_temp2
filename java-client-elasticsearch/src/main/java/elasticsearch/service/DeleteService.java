package elasticsearch.service;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteByQueryResponse;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;

import java.io.IOException;

/**
 * @author ooleon
 *
 */
@Service
public class DeleteService {

    @Autowired
    private ElasticsearchClient client;

	public DeleteService(ElasticsearchClient client) {
		this.client = client;
	}

    public long deleteInactiveDocuments(String indexName) throws IOException {
        DeleteByQueryResponse response = client.deleteByQuery(b -> b
                .index(indexName)
                .query(q -> q
                        .match(m -> m
                                .field("status")
                                .query("inactive")
                        )
                )
        );

        long deleted = response.deleted();
        System.out.println("Documentos eliminados: " + deleted);
        return deleted;
    }
    public void delete(String id) {
//        client.prepareDelete("twitter", "tweet", id).get();
	}


    /*
	public long deleteByMatchQuery(String name) {

		BulkByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
				.filter(QueryBuilders.matchQuery("user", name))
				//.filter(QueryBuilders.typeQuery("tweet"))
				.source("twitter").get();
		return response.getDeleted();
	}

	public long deleteByTermQuery(String name) {

		BulkByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
				.filter(QueryBuilders.termQuery("user", name))
				//.filter(QueryBuilders.typeQuery("tweet"))
				.source("twitter").get();
		return response.getDeleted();
	}
    */
}
