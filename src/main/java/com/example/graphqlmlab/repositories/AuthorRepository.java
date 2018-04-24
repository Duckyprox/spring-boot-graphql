package com.example.graphqlmlab.repositories;

import com.example.graphqlmlab.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findOneById(String id);
}
