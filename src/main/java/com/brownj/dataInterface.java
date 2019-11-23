package com.brownj;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoCredential;

import org.bson.Document;
import java.util.ArrayList;

import java.util.List;


public class dataInterface {

    private static dataInterface myDataInterface = null;
    private final String uriString= "localhost";
    private MongoClient mongo;

    private dataInterface() {

        mongo = new MongoClient(uriString, 27017);
    }
    public static dataInterface getInstance(){
        if(myDataInterface == null){
            myDataInterface = new dataInterface();
        }

        return myDataInterface;
    }
//--------------------------------------------------------
    private MongoCredential createCredential(){
        MongoCredential credential;

        //Create Credentials
        try {
            credential = MongoCredential.createCredential("MongoDB", "schedO",
                    "MongoDB".toCharArray());
            return credential;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }//end createCredential
//--------------------------------------------------------
    private MongoDatabase getTheDatabase(){
        MongoDatabase database;
        //Accessing the database
        database = mongo.getDatabase("schedO");

        return database;
    }
//----------------------------------------------------------

public static void main(String[] args){
        dataInterface mongo = dataInterface.getInstance();
        //MongoClient mongoClient = mongo.getMongo();

    System.out.println("Credentials :: "+ mongo.createCredential());
    MongoDatabase mongoData = mongo.getTheDatabase();
    MongoCollection<Document> collection = mongoData.getCollection("customers");

    List<Document> docs = (List<Document>) collection.find().into(new ArrayList<Document>());
    for(Document document : docs){
        System.out.println(document);

    }

}
}
