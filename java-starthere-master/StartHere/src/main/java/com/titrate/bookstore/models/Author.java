package com.titrate.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String authorid;
    private String lastName;
    private String firstName;

    @ManyToMany
    @JoinTable(name = "book",
            joinColumns = {@JoinColumn(name = "authorid")},
            inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnoreProperties("author")
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(String lastName, String firstName, List<Book> books) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.books = books;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }
}
