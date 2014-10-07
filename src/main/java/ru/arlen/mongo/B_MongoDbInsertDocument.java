package ru.arlen.mongo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class B_MongoDbInsertDocument {
    public static void main(String[] args) throws UnknownHostException {
        // Creates MongoDB client instance.
        MongoClient client = new MongoClient(
                new ServerAddress("localhost", 27017));

        // Gets the school database from the MongoDB instance.
        DB database = client.getDB("peopledb");

        // Gets the teachers collection from the database.
        DBCollection collection = database.getCollection("persons");
        collection.drop();

        // Creates a document to be stored in the teachers collections.
        DBObject person1 = new BasicDBObject("firstName", "John")
                .append("lastName", "Doe")
                .append("cityOfBirth", "New York");
        DBObject person2 = new BasicDBObject("firstName", "Julia")
                .append("lastName", "Roberts")
                .append("movieTitles", Arrays.asList("Pretty Woman", "Nothing Hill", "Runaway Bride"));

        // Prints the value of the document.
        System.out.println("person1 = " + person1);
        System.out.println("person2 = " + person2);

        // Inserts the document into the collection in the database.
        collection.insert(person1);
        collection.insert(person2);

        // Prints the value of the document after inserted in the collection.
        System.out.println("person1 = " + person1);
        System.out.println("person2 = " + person2);
    }
}
