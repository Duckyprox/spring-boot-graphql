package com.example.graphqlmlab.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "duckyshop", catalog = "")
public class Author {
    private int id;
    private String name;
    private Integer age;
    private Collection<Book> booksById;

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
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name) &&
                Objects.equals(age, author.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }

    @OneToMany(mappedBy = "authorByAuthorId")
    public Collection<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Book> booksById) {
        this.booksById = booksById;
    }
}
