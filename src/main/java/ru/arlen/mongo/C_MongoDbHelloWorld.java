package ru.arlen.mongo;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class C_MongoDbHelloWorld {
    public static void main(String[] args) throws UnknownHostException {
        // Creates a new instance of MongoDBClient and connect to localhost port 27017.
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        // Gets the peopledb from the MongoDB instance.
        DB database = client.getDB("peopledb");

        // Gets the persons collections from the database.
        DBCollection collection = database.getCollection("persons");

        // Gets a single document / object from this collection.
        DBObject document = collection.findOne();

        // Prints out the document.
        System.out.println(document);
    }
}
