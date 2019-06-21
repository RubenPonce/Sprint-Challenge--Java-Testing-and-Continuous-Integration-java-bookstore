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

    private String booktitle;

    private String ISBN;

    @Column(nullable = true)
    private int publishDate;


    public Book() {
    }

    public Book(String booktitle, String ISBN, int publishDate, Author author) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
