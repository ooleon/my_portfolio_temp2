package elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.get.GetResult;
import co.elastic.clients.elasticsearch.core.mget.*;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.IndexResponse;

import elasticsearch.util.ESTransportClient;
//import org.elasticsearch.client.*;
/*
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import static org.elasticsearch.index.query.QueryBuilders.*;
*/
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.Queries.*;
import static org.springframework.data.elasticsearch.client.elc.Queries.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ooleon
 *
 */
public class DataService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DataService.class);

    @Autowired
    ElasticsearchClient client;

	public DataService(ElasticsearchClient client) {
		this.client = client;
	}

    public String multiGet() throws IOException {
        String data="";
        GetResult response = client.get(g -> g
                        .index("products")


                        .id("bk-1"),
                String.class
        );

        if (response.found()) {
            data = response.source().toString();
            logger.info("Product name " + data.toUpperCase());
        } else {
            logger.info ("Product not found");
        }
        return data;
    }


    public String searchText() throws IOException {
    String toSearchText = "bike";

    SearchResponse response = client.search(s -> s
                    .index("products")
                    .query(q -> q
                            .match(t -> t
                                    .field("name")
                                    .query(toSearchText)
                            )
                    ),
            String.class
    );
    return response.toString();

    /*
	public void multiGet() {
		MultiGetResponse multiGetItemResponses = client.prepareMultiGet().add("twitter", "tweet", "1")
				.add("twitter", "tweet", "2", "3", "4")
				// .add("another", "type", "foo")
				.get();
		for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
			GetResponse response = itemResponse.getResponse();
			if (response.isExists()) {
				String jsonRes = response.getSourceAsString();
				System.out.println(jsonRes);
			}
		}
	}

	public List<String> getMatchAllQueryData() {
		QueryBuilder query = matchAllQuery();
		//System.out.println("getMatchAllQueryCount query =>" + query.toString());
		SearchHit[] hits = client.prepareSearch("test").setQuery(query).execute().actionGet().getHits().getHits();
		List<String> list = new ArrayList<String>();
		for (SearchHit hit : hits) {
			// hit.sourceAsMap()
			list.add(hit.getSourceAsString());
		}
		return list;
	}

	public List<String> getBoolQueryData() {
		QueryBuilder query = boolQuery().must(termQuery("name", "revanth")).must(termQuery("location", "india"));
		//System.out.println("getBoolQueryCount query =>" + query.toString());
		SearchHit[] hits = client.prepareSearch("test").setQuery(query).execute().actionGet().getHits().getHits();
		List<String> list = new ArrayList<String>();
		for (SearchHit hit : hits) {
			// hit.sourceAsMap()
			list.add(hit.getSourceAsString());
		}
		return list;
	}

	public List<String> getPhraseQueryData() {
		QueryBuilder query = matchPhraseQuery("name", "revanth");
		//System.out.println("getPhraseQueryCount query =>" + query.toString());
		SearchHit[] hits = client.prepareSearch("test").setQuery(query).execute().actionGet().getHits().getHits();
		List<String> list = new ArrayList<String>();
		for (SearchHit hit : hits) {
			// hit.sourceAsMap()
			list.add(hit.getSourceAsString());
		}
		return list;
	}
    */
    }
}
