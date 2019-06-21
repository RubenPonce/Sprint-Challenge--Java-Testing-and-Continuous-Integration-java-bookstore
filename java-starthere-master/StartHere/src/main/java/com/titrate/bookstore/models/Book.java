package com.titrate.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("book")
    private Author author;

    private String title;

    private String isbn;

    @Column(nullable = true)
    private int copy;


    public Book() {
    }

    public Book(String title, String isbn, int copy, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
