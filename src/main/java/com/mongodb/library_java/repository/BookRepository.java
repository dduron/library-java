package com.mongodb.library_java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.mongodb.library_java.schema.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{ '_id' : ?0 }")
    @Update("{ '$set' : { 'comments' : [] } }")
    void removeAllComments(String id);        
    
}