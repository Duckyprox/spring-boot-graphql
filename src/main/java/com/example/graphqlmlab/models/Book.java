package com.example.graphqlmlab.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "duckyshop", catalog = "")
public class Book {
    private int id;
    private String name;
    private String genre;
    private Integer authorId;
    private Author authorByAuthorId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "genre", nullable = true, length = 255)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "author_id", nullable = true)
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(authorId, book.authorId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, genre, authorId);
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
