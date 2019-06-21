package com.titrate.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ManyToMany
    @JoinTable(name = "wrote", joinColumns = {@JoinColumn(name="bookid")}, inverseJoinColumns = {@JoinColumn(name="authorid")})
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    private String title;

    private String isbn;

    @Column(nullable = true)
    private int copy;


    public Book() {
    }

    public Book(String title, String isbn, int copy) {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;

    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return title;
    }

    public void setBooktitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishDate() {
        return copy;
    }

    public void setPublishDate(int copy) {
        this.copy = copy;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authorList) {
        this.authors = authorList;
    }
}
