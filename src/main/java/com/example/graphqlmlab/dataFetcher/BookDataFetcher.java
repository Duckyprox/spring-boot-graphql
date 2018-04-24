package com.example.graphqlmlab.dataFetcher;

import com.example.graphqlmlab.models.Book;
import com.example.graphqlmlab.repositories.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        Map arguments = dataFetchingEnvironment.getArguments();
        return bookRepository.findOneById(arguments.get("id").toString());
    }
}
