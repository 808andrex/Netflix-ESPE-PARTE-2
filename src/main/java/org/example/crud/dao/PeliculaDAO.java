package org.example.crud.dao;

import org.example.crud.db.MongoConnection;
import org.example.crud.model.Pelicula;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class PeliculaDAO {
    private final MongoCollection<Pelicula> collection;

    public PeliculaDAO(){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoDatabase database = MongoConnection.getDatabase().withCodecRegistry(pojoCodecRegistry);
        this.collection = database.getCollection("peliculas", Pelicula.class);
    }

    // --- METODOS CRUD---
    public void crearPelicula(Pelicula pelicula){
        try {
            collection.insertOne(pelicula);
            System.out.printf("Pelicula guardado en Mongo ID"+pelicula.getId());
        }catch(Exception e){
            System.out.printf("Error al guardar: "+e.getMessage());
        }
        collection.insertOne(pelicula);
    }

    public List<Pelicula> obtenerTodasLasPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        collection.find().into(peliculas);
        return peliculas;
    }

    public boolean actualizarPelicula(Pelicula pelicula){
        UpdateResult result = collection.updateOne(
                Filters.eq("_id",pelicula.getId()),
                Updates.combine(
                        Updates.set("titulo",pelicula.getTitulo()),
                        Updates.set("director",pelicula.getDirector()),
                        Updates.set("anio",pelicula.getAnio())
                )
        );
        return result.getModifiedCount()>0;
    }

    public boolean eliminarPelicula(ObjectId id){
        DeleteResult result = collection.deleteOne(Filters.eq("_id",id));
        return result.getDeletedCount() > 0;
    }
}

