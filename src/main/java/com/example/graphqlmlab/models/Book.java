package com.example.graphqlmlab.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String name;
    private String genre;
    private Author author;

}
