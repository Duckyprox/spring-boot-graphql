package com.example.graphqlmlab.dataFetcher;


import com.example.graphqlmlab.models.Author;
import com.example.graphqlmlab.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddAuthorDataFetcher implements DataFetcher<Author> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author get(DataFetchingEnvironment dataFetchingEnvironment) {
        Map arguments = dataFetchingEnvironment.getArguments();
        Author author = new Author();
        String authorName = arguments.get("name").toString();
        int authorAge = Integer.parseInt(arguments.get("age").toString());
        author.setName(authorName);
        author.setAge(authorAge);
        authorRepository.save(author);
        return author;
    }
}
