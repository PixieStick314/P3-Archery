package src.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnector(String uri, String dbName) {
        MongoClientURI clientUri = new MongoClientURI(uri);
        this.mongoClient = new MongoClient(clientUri);
        this.database = mongoClient.getDatabase(dbName);
    }
}
