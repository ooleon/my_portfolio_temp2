/**
 *
 */
package elasticsearch.service;

/**
 * @author ooleon
 *
 */

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import static org.springframework.data.elasticsearch.client.elc.Queries.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


//import static org.elasticsearch.index.query.QueryBuilders.*;

public class CountService {

    @Autowired
    ElasticsearchClient client;

    public CountService(ElasticsearchClient client) {
        this.client = client;
    }

    public long getMatchAllQueryCount() throws IOException {
        Query query = matchAllQuery()._toQuery();
        System.out.println("getMatchAllQueryCount query =>" + query.toString());
//		long count = client.search("test").setQuery(query).setSize(0).execute().actionGet().getHits().getTotalHits();
        long count = client.search(builder -> builder.index("").query(q -> q.match(t -> t.field("").query("")

                ))

                , String.class).took();

        return count;
    }

    /*
	public long getBoolQueryCount() {
		QueryBuilder query = boolQuery().must(termQuery("name", "shyam")).must(termQuery("location", "india"));
		System.out.println("getBoolQueryCount query =>" + query.toString());
		long count = client.prepareSearch("test").setQuery(query).setSize(0).execute().actionGet().getHits()
				.getTotalHits();
		return count;
	}

	public long getPhraseQueryCount() {
		QueryBuilder query = matchPhraseQuery("name", "revanth");
		System.out.println("getPhraseQueryCount query =>" + query.toString());
		long count = client.prepareSearch("test").setQuery(query).setSize(0).execute().actionGet().getHits()
				.getTotalHits();
		return count;
	}
*/
}
