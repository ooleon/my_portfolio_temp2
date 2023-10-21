# es-5.x-java-client
 Prerequisite : Java 8 and Later version 

### Start ElasticSearch
1) Download elasticsearch from [here](https://www.elastic.co/downloads/elasticsearch)   
2) Extract downloaded elasticsearch     
3) cd elasticsearch-X.X.X       
4) $ bin/elasticsearch     

### Insert data into elasticsearch
     $ curl -XPOST localhost:9200/test/tweet   -d '{"name":"Monica", "job":"consultant" , "location":"Brasil", "age":28}'
     $ curl -XPOST localhost:9200/test/tweet   -d '{"name":"Leo", "job":"consultant" , "location":"Venezuela", "age":42}'
     $ curl -XPOST localhost:9200/test/tweet   -d '{"name":"Mariela", "job":"consultant" , "location":"America", "age":25}'
 

### Run project 
    $ mvn package
    $ mvn exec:java -Dexec.mainClass="elasticsearch.app.ESMain"

