
package com.mycompany.springtutorial;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnection {
    final private MongoClient client;
    
    public MongoConnection(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://Steve:" + System.getProperty("mongopw") + "@cluster0.pijrp.mongodb.net/Steve?retryWrites=true&w=majority");
        
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                                                        .applyConnectionString(connectionString)
                                                        .codecRegistry(codecRegistry)
                                                        .build();
        
        client = MongoClients.create(clientSettings);
    }
    
    public MongoClient getClient() { return client; }
}
