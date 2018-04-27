package com.example.graphqlmlab.controllers;

import com.example.graphqlmlab.dataFetcher.*;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@RestController
public class QueryController {

    private GraphQL graphQL;

    @Autowired
    private AllBookDataFetcher allBookDataFetcher;

    @Autowired
    private BookDataFetcher bookDataFetcher;

    @Autowired
    private AddBookDataFetcher addBookDataFetcher;

    @Autowired
    private AllAuthorDataFetcher allAuthorDataFetcher;

    @Autowired
    private AddAuthorDataFetcher addAuthorDataFetcher;

    @Value("classpath:schema.graphqls")
    private org.springframework.core.io.Resource schemaResource;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allBooks", allBookDataFetcher)
                        .dataFetcher("book", bookDataFetcher)
                        .dataFetcher("allAuthors", allAuthorDataFetcher))
                .type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("newBook", addBookDataFetcher)
                        .dataFetcher("newAuthor", addAuthorDataFetcher))
                .build();
    }

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        System.out.println(String.valueOf(result.getErrors()));
        return ResponseEntity.ok(result);
    }

}
