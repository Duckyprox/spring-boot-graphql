package com.example.graphqlmlab.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "authors")
public class Author {

    @Id
    private String id;
    private String name;
    private int age;
    @DBRef
    private Set<Book> books;
}
