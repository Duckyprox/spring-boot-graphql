package com.example.graphqlmlab.repositories;

import com.example.graphqlmlab.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findOneById(String id);

    List<Book> findAllByAuthorId(String authorId);
}
