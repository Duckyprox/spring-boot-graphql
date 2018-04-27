package com.example.graphqlmlab.repositories;

import com.example.graphqlmlab.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Author findOneById(int id);
    List<Author> findAll();
}
