package elasticsearch.service;

//import static org.elasticsearch.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Date;

//import org.elasticsearch.action.bulk.BulkRequestBuilder;
//import org.elasticsearch.action.bulk.BulkResponse;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.*;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.get.GetResult;
import co.elastic.clients.elasticsearch.core.mget.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ooleon
 *
 */
public class UpdateService {
    @Autowired
    ElasticsearchClient client;

    public UpdateService(ElasticsearchClient client) {
        this.client = client;
    }

    public void update() throws IOException {

        String toUpdate = "test";

        UpdateResponse<String> response = client.update(u -> u
                .index("products")
                .id("bk-1")
                .upsert(toUpdate),
                String.class);

        System.out.println(response.get());

    }

    /*
	public void bulkUpdate() {

		BulkRequestBuilder bulkRequest = client.prepareBulk();

		try {
			bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
					.setSource(jsonBuilder().startObject().field("user", "arjun").field("postDate", new Date())
							.field("message", "trying out Elasticsearch").endObject()));

			bulkRequest.add(client.prepareIndex("twitter", "tweet", "2")
					.setSource(jsonBuilder().startObject().field("user", "arjun").field("postDate", new Date())
							.field("message", "another post").endObject()));

			BulkResponse bulkResponse = bulkRequest.get();
			if (bulkResponse.hasFailures()) {
				// process failures by iterating through each bulk response item
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    */
}
