package com.example.graphqlmlab.dataFetcher;

import com.example.graphqlmlab.models.Book;
import com.example.graphqlmlab.repositories.AuthorRepository;
import com.example.graphqlmlab.repositories.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddBookDataFetcher implements DataFetcher<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        Map arguments = dataFetchingEnvironment.getArguments();
        System.out.println(arguments);
        String name = arguments.get("name").toString();
        String genre = arguments.get("genre").toString();
        int authorId = Integer.parseInt(arguments.get("authorId").toString());
        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthorId(authorId);
        bookRepository.save(book);
        return book;
    }
}
