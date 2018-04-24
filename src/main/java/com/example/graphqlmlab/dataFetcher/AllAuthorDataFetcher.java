package com.example.graphqlmlab.dataFetcher;

import com.example.graphqlmlab.models.Author;
import com.example.graphqlmlab.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllAuthorDataFetcher implements DataFetcher<Iterable<Author>> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Iterable<Author> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return authorRepository.findAll();
    }
}
