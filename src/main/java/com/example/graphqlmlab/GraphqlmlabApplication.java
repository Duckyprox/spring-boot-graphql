package com.example.graphqlmlab;

import com.example.graphqlmlab.models.Author;
import com.example.graphqlmlab.models.Book;
import com.example.graphqlmlab.repositories.AuthorRepository;
import com.example.graphqlmlab.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlmlabApplication {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepositoryl;

    public static void main(String[] args) {
        SpringApplication.run(GraphqlmlabApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository, AuthorRepository authorRepository) {
        return args -> {

        };
    }
}
