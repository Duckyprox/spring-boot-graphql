package com.example.graphqlmlab.repositories;

import com.example.graphqlmlab.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findOneById(int id);

    List<Book> findAllByAuthorId(int authorId);
}
