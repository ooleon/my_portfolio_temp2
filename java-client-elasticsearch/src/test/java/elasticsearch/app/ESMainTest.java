package elasticsearch.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Timer;

import elasticsearch.util.ESTransportClient;
import org.junit.Test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

//Test
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import elasticsearch.app.ESMain;

/**
 * @author ooleon
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESMainTest {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ESMainTest.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Test
	public void test(){
        System.out.println( ESMain.test() );
        LocalDateTime now = LocalDateTime.now();
        String formattedNow = now.format(formatter);

        logger.info(now.format(formatter));

        try {
            ESMain.app();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
