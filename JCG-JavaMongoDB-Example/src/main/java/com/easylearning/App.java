package com.easylearning;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static  MongoClient mongoClient;

    public static void main( String[] args )
    {
        MongoClient client=getClient1();





    }



    public static MongoCollection<Document> getCollection(String databaseName, String collectionName){
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        System.out.println("collection selected successfully");
        return collection;
    }

    public static void createConnection(String databaseName,String connectionName){
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        database.createCollection(connectionName);
        System.out.println("collection created");
    }


    public static MongoClient getClient(){
        // Creating a Mongo client
        mongoClient = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongoClient.getDatabase("myDb");
        System.out.println("Credentials ::"+ credential);

        return mongoClient;
    }

    public static MongoClient getClient1() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        //If you’re connecting to a local instance on the default port, you can simply use:
        //MongoClient mongoClient = new MongoClient();
        List<String> databaseNames = mongoClient.getDatabaseNames();
        databaseNames.forEach(a -> System.out.println(a));

        return mongoClient;
    }
}
