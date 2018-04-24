package com.example.graphqlmlab.dataFetcher;

import com.example.graphqlmlab.models.Book;
import com.example.graphqlmlab.repositories.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllBookDataFetcher implements DataFetcher<Iterable<Book>> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findAll();
    }
}
