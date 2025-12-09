package org.example.crud.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase dataBase;
    private static final String CONNECTION_STRING = "";
    private static final String DATABASE_NAME = "netflix_db";

    public static MongoClient getMongoClient(){
        if(mongoClient == null){
            try {
                mongoClient = MongoClients.create(CONNECTION_STRING);
                System.out.println("Conexcion a MongoDB atlas establecida.");
            }catch (Exception e){
                System.out.println("Error al conectar a mongo DB atlas "+e.getMessage());
            }
        }
        return mongoClient;
    }

    public static MongoDatabase getDatabase(){
        if(dataBase == null && getMongoClient() != null){
            dataBase = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Base de datos '"+DATABASE_NAME+"' seleccionada");
        }
        return dataBase;
    }


}
