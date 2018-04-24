package com.example.graphqlmlab;

import com.example.graphqlmlab.models.Author;
import com.example.graphqlmlab.models.Book;
import com.example.graphqlmlab.repositories.AuthorRepository;
import com.example.graphqlmlab.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlmlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlmlabApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository, AuthorRepository authorRepository) {
        return args -> {
//            System.out.println("Start project");
//            Book book = bookRepository.findOneById("5ace308a02188e6252aad4a6");
//            System.out.println(book.getAuthorId());
//            System.out.println(authorRepository.findAll());

            Book book2 = new Book();
            book2.setName("Book 2 Marvel");
            book2.setGenre("Book 2 Genre");
            Author author = authorRepository.findOneById("5adef81010c6b00af9db4241");
            book2.setAuthor(author);
            bookRepository.save(book2);
////
//            System.out.println("Count");
//            long count = bookRepository.count();
//            System.out.println(count);
//
//            System.out.println("Author");
//            long countAuthor = authorRepository.count();
//            System.out.println(countAuthor);

//            Author author = new Author();
//            author.setName("Vit Dep Trai");
//            author.setAge(18);
//            Set<Book> setBook = new HashSet<>();
//            setBook.add(bookRepository.findOneById("5adef58c10c6b003925727be"));
//            author.setBooks(setBook);
//            authorRepository.save(author);
        };
    }
}
